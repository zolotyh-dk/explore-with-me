package ru.practicum.ewm.stats;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
@Slf4j
class ControllerExceptionHandler {

    @ExceptionHandler
    protected ProblemDetail handleException(final Exception exception, final HttpServletRequest request) {
        log.error(exception.getMessage(), exception);
        final ProblemDetail response = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                "Please contact site admin");
        logResponse(request, response);
        return response;
    }

    private void logResponse(final HttpServletRequest httpRequest, final Object body) {
        final String method = httpRequest.getMethod();
        final String uri = httpRequest.getRequestURI();
        final String queryString = Optional.ofNullable(httpRequest.getQueryString()).map(s -> "?" + s).orElse("");
        log.info("Responded to {} {}{}: {}", method, uri, queryString, body);
    }
}
