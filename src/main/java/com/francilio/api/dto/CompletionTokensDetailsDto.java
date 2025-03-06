package com.francilio.api.dto;

public record CompletionTokensDetailsDto(
    int reasoningTokens,
    int acceptedPredictionTokens,
    int rejectedPredictionTokens
) {

}
