package ru.practicum.ewm.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotNull
        @Size(max = 255)
        String email,

        @NotNull
        @Size(max = 100)
        String name) {
}
