package ru.practicum.ewm.stats;

import jakarta.validation.Valid;

public interface StatsService {

    void addEndpointHit(@Valid EndpointHit endpointHit);
}
