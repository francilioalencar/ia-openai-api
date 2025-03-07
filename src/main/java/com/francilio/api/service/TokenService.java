package com.francilio.api.service;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.ModelType;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final Encoding encoding;

    public TokenService() {
        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        this.encoding = registry.getEncodingForModel(ModelType.GPT_3_5_TURBO);
    }

    public int contarTokens(String texto) {
        return encoding.countTokens(texto);
    }
}
