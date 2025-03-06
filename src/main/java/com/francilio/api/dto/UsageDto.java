package com.francilio.api.dto;

public record UsageDto(
    int promptTokens,
    int completionTokens,
    int totalTokens,
    CompletionTokensDetailsDto completionTokensDetails

) {

}
