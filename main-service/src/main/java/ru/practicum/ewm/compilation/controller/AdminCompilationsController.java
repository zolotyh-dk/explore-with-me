package ru.practicum.ewm.compilation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.compilation.dto.CompilationRequestDto;
import ru.practicum.ewm.compilation.dto.CompilationResponseDto;

@Slf4j
@RestController
@RequestMapping("/admin/compilations")
@RequiredArgsConstructor
public class AdminCompilationsController {
    @PostMapping
    public CompilationResponseDto saveCompilation(@RequestBody @Valid final CompilationRequestDto request) {
        return null;
    }

    @DeleteMapping
    public void deleteCompilation(@PathVariable final long id) {

    }

    @PatchMapping
    public CompilationResponseDto updateCompilation(@RequestBody @Valid final CompilationRequestDto requestDto) {
        return null;
    }
}
