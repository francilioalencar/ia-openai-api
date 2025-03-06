package com.francilio.api.dto;

import java.util.List;

import com.francilio.api.model.Choice;
import com.francilio.api.model.Usage;

public record ChatResponseDto(
    String id,
    String object,
    long created,
    String model,
    String systemFingerprint,
    List<ChoiceDto> choices,
    UsageDto usage
) {
    
}
