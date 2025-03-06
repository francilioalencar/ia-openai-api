
package com.francilio.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration

public class FeignConfig {

    @Value("${spring.ai.openai.api.key}")
    private String apiKey;

    

    @Bean
    protected RequestInterceptor requestInterceptor(){
        return requestInterceptor->{
                requestInterceptor.header("Content-Type",  "application/json");
                requestInterceptor.header("Authorization", "Bearer "+apiKey);
        };
    }
}