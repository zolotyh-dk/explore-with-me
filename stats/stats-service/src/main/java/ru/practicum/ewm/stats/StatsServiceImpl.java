package ru.practicum.ewm.stats;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public List<ViewStats> getViewStats(final LocalDateTime start, final LocalDateTime end, final List<String> uris,
            final boolean unique) {
        if (CollectionUtils.isEmpty(uris)) {
            if (unique) {
                return repository.getUniqueHits(start, end);
            } else {
                return repository.getHits(start, end);
            }
        } else {
            if (unique) {
                return repository.getUniqueHits(start, end, uris);
            } else {
                return repository.getHits(start, end, uris);
            }
        }
    }
}
