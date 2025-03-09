package com.francilio.api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

@Service
public class SpringAIChatClientApiService {

    private final ChatClient chatClient;

    public SpringAIChatClientApiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String obterResposeChatClient(String promptSystem, String promptUser) {
        return this.chatClient.prompt()
                .user(promptUser)
                .system(promptSystem)
                .options( 
                    ChatOptions
                    .builder()
                    .temperature(0.8)
                    .build()
                )
                .call()
                .content();
    }
}
