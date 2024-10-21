package ru.practicum.ewm;

import java.time.LocalDateTime;

public record EndpointHitDto(

        String app,
        String uri,
        String api,
        LocalDateTime timestamp) {

}
