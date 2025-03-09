package com.francilio.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francilio.api.dto.Prompt;
import com.francilio.api.service.SpringAIChatClientApiService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/chatClientOpenAi")
public class SpringAIChatClientApiController {

    private SpringAIChatClientApiService springAIChatClientApiService;

    public SpringAIChatClientApiController(SpringAIChatClientApiService springAIChatClientApiService) {
        this.springAIChatClientApiService = springAIChatClientApiService;
    }


        @Operation(summary = "ChatClientApi", description = """
            Utilizado documentação: https://docs.spring.io/spring-ai/reference/api/chatclient.html\n
            API: OpenAi IA \n
            """)

    @PostMapping
    String generation(@RequestBody Prompt prompt) {

        return springAIChatClientApiService.obterResposeChatClient(prompt.system(), prompt.user());

    }

}
