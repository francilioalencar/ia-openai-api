package com.francilio.api.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francilio.api.dto.Prompt;
import com.francilio.api.service.OpenAiRequestOpenFeignService;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/requestOpenFeign")

public class OpenAiRequestOpenFeignController {

    private OpenAiRequestOpenFeignService openAiCompletionService;

    public OpenAiRequestOpenFeignController(OpenAiRequestOpenFeignService openAiCompletionService) {
        this.openAiCompletionService = openAiCompletionService;
    }

    @Operation(summary = "chat-completion", description = """
            Utilizado documentação Create chat completion em: https://platform.openai.com/docs/api-reference/chat/create\n
            Requisicao:POST\n
            Endpoint:  https://api.openai.com/v1/chat/completions\n
            REST Client: OpenFeign - Spring Cloud Routing
            """)
    @PostMapping
    public ResponseEntity<String> elaborarCronograma(@RequestBody Prompt prompt) {

        return ResponseEntity.ok(this.openAiCompletionService.openAiChatCompletionService(prompt.system(), prompt.user()));
    }

}
