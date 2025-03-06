package com.francilio.api.dto;

public record ChoiceDto(
    int index,
    MessageDto message,
    Object logprobs,
    String finishReason
) {

}
