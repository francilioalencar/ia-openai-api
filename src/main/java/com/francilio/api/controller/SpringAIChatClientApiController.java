package com.francilio.api.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.francilio.api.dto.Prompt;
import com.francilio.api.service.SpringAIChatClientApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

    @Operation(
        summary = "Faz upload de uma imagem e retorna uma descrição",
        description = "Este endpoint recebe uma imagem < 1M e retorna uma descrição detalhada gerada por IA."
        
    )
    @ApiResponse(responseCode = "200", description = "Descrição gerada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro ao processar a imagem")
    @PostMapping(value = "/descrever-imagem", consumes = "multipart/form-data")

    //@PostMapping("/img")
    public ResponseEntity<String> obterDescricaoDeImagem(@RequestParam("imagem") MultipartFile imagem) {

        try {
            // 1 Salvar a imagem temporariamente
            File arquivoTemp = File.createTempFile("upload-", ".jpg");
            try (FileOutputStream fos = new FileOutputStream(arquivoTemp)) {
                fos.write(imagem.getBytes());
            }

            // 2️ Criar um Resource da imagem salva
            Resource imagemResource = new FileSystemResource(arquivoTemp);

            String str="""
            Realize uma breve descrição detalada da imagem enviada.        
            """;
        return ResponseEntity.ok(  springAIChatClientApiService.obterDescreveImagem(str, str, imagemResource) );
        } catch (IOException e) {
                    return ResponseEntity.status(500).body("Erro ao processar a imagem.");
                }
            }

}
