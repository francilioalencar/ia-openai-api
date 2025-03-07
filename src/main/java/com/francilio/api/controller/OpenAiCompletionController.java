package com.francilio.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francilio.api.service.OpenAiCompletionService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/completion")

public class OpenAiCompletionController {

    
    private OpenAiCompletionService openAiCompletionService;

    public OpenAiCompletionController( OpenAiCompletionService openAiCompletionService){
        this.openAiCompletionService = openAiCompletionService;
    }


    @Operation(summary = "chat-completion", description = """
        Utilizado documentação Create chat completion em: https://platform.openai.com/docs/api-reference/chat/create\n
        Requisicao:POST\n
        Endpoint:  https://api.openai.com/v1/chat/completions\n
        REST Client: OpenFeign - Spring Cloud Routing
        """)
    @GetMapping("/cronograma/{descricao}")

    public ResponseEntity<String> elaborarCronograma(@PathVariable String descricao){

        String promptSystem = """
                o que será feito: Criar cronograma para gerenciamento de projetos;
                Regras:
                    Liste apenas o titulo da atividade;
                    não escrever os detalhes da atividade;
                estrutura da resposta:
                    [
                        {
                            titulo: titulo
                        }
                    ] 
                """;

        return ResponseEntity.ok(this.openAiCompletionService.openAiChatCompletionService(promptSystem, descricao));
    }




}
