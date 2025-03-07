package com.francilio.api.dto;

import java.util.List;

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
