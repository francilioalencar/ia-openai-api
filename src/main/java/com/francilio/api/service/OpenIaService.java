package com.francilio.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.Chat;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;
import io.github.sashirestela.openai.exception.OpenAIException;
import io.github.sashirestela.openai.exception.OpenAIExceptionConverter;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

@Service
public class OpenIaService {
    
    @Value("${spring.ai.openai.api.model}")
    private String modelChat;

    @Value("${spring.ai.openai.api.key}")
    private String apiKey;

    private TokenService tokenService;

    public OpenIaService(TokenService tokenService){
        this.tokenService = tokenService;

    }

    public String gerarConteudoComChatOpenIa(String promptSystem, String promptUser){

        if(this.tokenService.contarTokens(promptUser)  > 128000){

            throw new IllegalArgumentException("A quantidade de Tokens ultrapassa a quantiadade de 128K ");
        }

        StringBuilder chatResponsBuilder = new StringBuilder();
        var openAI = SimpleOpenAI.builder()
            .apiKey(apiKey)
            .build();

        var chatRequest = ChatRequest.builder()
            .model(modelChat)
            .message(SystemMessage.of(promptSystem))
            .message(UserMessage.of(promptUser))
            .temperature(1.0)
            .maxCompletionTokens(500)
            .build();
        var futureChat = openAI.chatCompletions().createStream(chatRequest);
        try{
            var chatResponse = futureChat.join();
            chatResponse.filter(chatResp -> chatResp.getChoices().size() > 0 && chatResp.firstContent() != null)
                    .map(Chat::firstContent)
                    .forEach(
                        response ->{
                            chatResponsBuilder.append(response);
                        }
                    );
            
            return chatResponsBuilder.toString();
        } catch (Exception e) {
            try{
                OpenAIExceptionConverter.rethrow(e);
            }catch(OpenAIException u){

                switch (u.getResponseInfo().getStatus()) {
                    case 400->{ return "BadRequestException (400)"; }
                    case 401->{ return "AuthenticationException (401)"; }
                    case 404->{ return "NotFoundException (404)"; }
                    case 422->{ return "UnprocessableEntityException (422)"; }
                    case 429->{ return "RateLimitException (429)"; }
                    default ->{ return "UnexpectedStatusCodeException (other status codes)";}
                }
            }

            throw new RuntimeException("API indiponivel");
        }
    }


}
