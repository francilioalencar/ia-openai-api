package com.francilio.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francilio.api.service.OpenIaService;

@RestController
@RequestMapping("/openia-chat")


public class OpenIaController {

    
    private OpenIaService openIaService;

    public OpenIaController(OpenIaService openIaService){
        this.openIaService = openIaService;
    }


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

        return ResponseEntity.ok(this.openIaService.gerarConteudoComChatOpenIa(promptSystem, descricao));
    }




}
