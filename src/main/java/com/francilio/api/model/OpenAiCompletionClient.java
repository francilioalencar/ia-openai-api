package com.francilio.api.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.francilio.api.dto.ChatResponseDto;

@FeignClient(name = "openAiClienteCompletion", url = "https://api.openai.com")
public interface OpenAiCompletionClient {


    @PostMapping("/v1/chat/completions")
    ResponseEntity<ChatResponseDto> getMensageOpenAiCompletion(@RequestBody ChatRequest request);
    
}
