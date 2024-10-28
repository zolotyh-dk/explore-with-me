package ru.practicum.ewm.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CompilationRequestDto(
        List<Long> events,

        @NotNull
        boolean pinned,

        @NotNull
        @Size(max = 255)
        String title) {
}
