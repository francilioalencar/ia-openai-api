package com.francilio.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.francilio.api.dto.ChatResponseDto;
import com.francilio.api.model.ChatRequest;
import com.francilio.api.model.Message;
import com.francilio.api.model.OpenAiCompletionClient;


@Service

public class OpenAiRequestOpenFeignService {
    
    @Value("${spring.ai.openai.chat.options.model}")
    private String modelChat;

    private OpenAiCompletionClient openAiCompletionClient;
    private TokenService tokenService;

    public OpenAiRequestOpenFeignService(OpenAiCompletionClient openAiCompletionClient, TokenService tokenService){
        this.openAiCompletionClient = openAiCompletionClient;
        this.tokenService =tokenService;

    }


    public String openAiChatCompletionService(String messagenSystem, String messagenUser){

        if(this.tokenService.contarTokens(messagenUser)  > 128000){

            throw new IllegalArgumentException("A quantidade de Tokens ultrapassa a quantiadade de 128K ");
        }


        Message messageUser = new Message();
        messageUser.setRole("user");
        messageUser.setContent(messagenUser);

        Message messageSystem = new Message();
        messageSystem.setRole("system");
        messageSystem.setContent(messagenSystem);




        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel(modelChat);
        chatRequest.setMessages(List.of(messageSystem, messageUser));
        

        ResponseEntity<ChatResponseDto> responseEntity =this.openAiCompletionClient.getMensageOpenAiCompletion(chatRequest);

        try{
            return responseEntity.getBody().choices().get(0).message().toString();
        }catch(Exception e){
            throw new IllegalArgumentException("O retorno do modelo foi null");
        }
    }


}
