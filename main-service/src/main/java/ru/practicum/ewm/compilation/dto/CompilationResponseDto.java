package ru.practicum.ewm.compilation.dto;

import ru.practicum.ewm.event.dto.EventDto;

import java.util.List;

public record CompilationResponseDto(
        List<EventDto> events,
        long id,
        String title) {
}
