package ru.practicum.ewm.stats;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    void addEndpointHit(@RequestBody final EndpointHitDto dto, final HttpServletRequest httpRequest) {
        logRequest(httpRequest, dto);
        service.addEndpointHit(mapper.mapToEndpointHit(dto));
        logResponse(httpRequest);
    }

    @GetMapping("/stats")
    String hello() {
        return "Hello, world!";
    }

    private void logRequest(final HttpServletRequest httpRequest, final EndpointHitDto body) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Received {} at {}{}: {}", method, uri, queryString, body);
    }

    private void logResponse(final HttpServletRequest httpRequest) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Responded to {} {}{} with no body", method, uri, queryString);
    }
}
