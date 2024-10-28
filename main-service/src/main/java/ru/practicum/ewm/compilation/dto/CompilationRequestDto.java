package ru.practicum.ewm.compilation.dto;

import java.util.List;

public record CompilationRequestDto(
        List<Long> events,
        boolean pinned,
        String title) {
}
