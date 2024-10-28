package ru.practicum.ewm.dto;

import java.util.List;

public record CompilationResponseDto(
        List<EventDto> events,
        long id,
        String title) {
}
