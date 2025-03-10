package com.francilio.api.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.model.Media;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


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

    public String obterDescreveImagem(String promptSystem, String promptUser, Resource imagem) {

        Media media = new Media(MimeTypeUtils.IMAGE_JPEG, imagem);
        UserMessage userMessage = new UserMessage(promptUser, List.of(media));



        return this.chatClient.prompt()
                .system(promptSystem)
                .messages(List.of(userMessage))
                .options(ChatOptions.builder().temperature(0.8).build())
                .call()
                .content();
    }
}
