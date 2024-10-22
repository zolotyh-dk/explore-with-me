package ru.practicum.ewm.stats;

import org.springframework.stereotype.Component;

@Component
class StatsMapper {

    EndpointHit mapToEndpointHit(final EndpointHitDto dto) {
        final EndpointHit endpointHit = new EndpointHit();
        endpointHit.setApp(dto.app());
        endpointHit.setUri(dto.uri());
        endpointHit.setIp(dto.ip());
        endpointHit.setTimestamp(dto.timestamp());
        return endpointHit;
    }
}
