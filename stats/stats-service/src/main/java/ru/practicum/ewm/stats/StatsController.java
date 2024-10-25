package ru.practicum.ewm.stats;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
class StatsController {

    private final StatsService service;
    private final StatsMapper mapper;

    @PostMapping("/hit")
    @ResponseStatus(code = HttpStatus.CREATED)
    void addEndpointHit(@RequestBody @Valid final EndpointHitDto dto, final HttpServletRequest httpRequest) {
        logRequest(httpRequest, dto);
        service.addEndpointHit(mapper.mapToEndpointHit(dto));
        logResponse(httpRequest);
    }

    @GetMapping("/stats")
    List<ViewStatsDto> getViewStats(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final LocalDateTime start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final LocalDateTime end,
            @RequestParam(required = false) final List<String> uris,
            @RequestParam(defaultValue = "false") final boolean unique,
            final HttpServletRequest httpRequest
    ) {
        logRequest(httpRequest);
        final List<ViewStatsDto> dtos = mapper.mapToDto(service.getViewStats(start, end, uris, unique));
        logResponse(httpRequest, dtos);
        return dtos;
    }

    private void logRequest(final HttpServletRequest httpRequest, final EndpointHitDto body) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Received {} at {}{}: {}", method, uri, queryString, body);
    }

    private void logRequest(final HttpServletRequest httpRequest) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Received {} at {}{}", method, uri, queryString);
    }

    private void logResponse(final HttpServletRequest httpRequest, final Object body) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Responded to {} {}{}: {}", method, uri, queryString, body);
    }

    private void logResponse(final HttpServletRequest httpRequest) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Responded to {} {}{} with no body", method, uri, queryString);
    }
}
