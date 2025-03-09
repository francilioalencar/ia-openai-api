package com.francilio.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francilio.api.dto.Prompt;
import com.francilio.api.service.OpenIaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/sashirestelaApi")

public class OpenIaController {

    private OpenIaService openIaService;

    public OpenIaController(OpenIaService openIaService) {
        this.openIaService = openIaService;
    }

    @Operation(summary = "Api", description = """
            Utilizado documentação: https://platform.openai.com/docs/libraries#java\n
            API:Java Sashir Estela ( https://github.com/sashirestela/simple-openai )\n
            """)

    @PostMapping

    public ResponseEntity<String> elaborarCronograma(@RequestBody Prompt prompt) {

        
        return ResponseEntity.ok(this.openIaService.gerarConteudoComChatOpenIa(prompt.system(), prompt.user()));
    }

}
