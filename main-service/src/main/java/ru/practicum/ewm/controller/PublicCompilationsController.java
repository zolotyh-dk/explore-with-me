package ru.practicum.ewm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.dto.CompilationResponseDto;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/compilations")
@RequiredArgsConstructor
public class PublicCompilationsController {
    @GetMapping
    public List<CompilationResponseDto> getCompilations(@RequestParam final boolean pinned,
                                                        @RequestParam final int from,
                                                        @RequestParam final int size) {
        return Collections.emptyList();
    }

    @GetMapping
    public CompilationResponseDto getCompilation(@PathVariable final long id) {
        return null;
    }
}
