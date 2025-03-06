package com.francilio.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.francilio.api.dto.ChatResponseDto;
import com.francilio.api.model.ChatRequest;
import com.francilio.api.model.Message;
import com.francilio.api.model.OpenAiCompletionClient;


@Service

public class OpenAiCompletionService {
    

    private OpenAiCompletionClient openAiCompletionClient;

    public OpenAiCompletionService(OpenAiCompletionClient openAiCompletionClient){
        this.openAiCompletionClient = openAiCompletionClient;

    }


    public String openAiChatCompletionService(String messagenSystem, String messagenUser){

        Message messageUser = new Message();
        messageUser.setRole("user");
        messageUser.setContent(messagenUser);

        Message messageSystem = new Message();
        messageSystem.setRole("system");
        messageSystem.setContent(messagenSystem);



        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("gpt-4o");
        chatRequest.setMessages(List.of(messageSystem, messageUser));


        ResponseEntity<ChatResponseDto> responseEntity =this.openAiCompletionClient.getMensageOpenAiCompletion(chatRequest);


        return responseEntity.getBody().choices().get(0).message().toString();
    }


}
