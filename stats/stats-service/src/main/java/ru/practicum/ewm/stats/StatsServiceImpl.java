package ru.practicum.ewm.stats;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Service
@Transactional(readOnly = true)
@Validated
@RequiredArgsConstructor
@Slf4j
class StatsServiceImpl implements StatsService {

    private final StatsRepository repository;

    @Override
    @Transactional
    public void addEndpointHit(final EndpointHit endpointHit) {
        Objects.requireNonNull(endpointHit, "Cannot add endpoint hit: is null");
        final EndpointHit savedEndpointHit = repository.save(endpointHit);
        log.info("Added endpoint hit with id = {}: {}", savedEndpointHit.getId(), savedEndpointHit);
    }
}
