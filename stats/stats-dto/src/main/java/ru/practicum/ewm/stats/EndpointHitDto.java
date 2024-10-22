package ru.practicum.ewm.stats;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record EndpointHitDto(

        String app,
        String uri,
        String api,
        LocalDateTime timestamp) {

}
