package br.com.studytracker.studytracker_api.controller;


import br.com.studytracker.studytracker_api.dto.request.StudySessionRequest;
import br.com.studytracker.studytracker_api.dto.response.StudySessionResponse;
import br.com.studytracker.studytracker_api.service.StudySessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/study-sessions")
@RequiredArgsConstructor
public class StudySessionController {

    private final StudySessionService studySessionService;

    // Criar nova sessão de estudo
    @PostMapping
    public ResponseEntity<StudySessionResponse> create(
            @RequestBody @Valid StudySessionRequest request
    ) {
        StudySessionResponse created = studySessionService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    // Buscar sessão por ID
    @GetMapping("/{id}")
    public ResponseEntity<StudySessionResponse> findById(
            @PathVariable Long id
    ) {
        StudySessionResponse response = studySessionService.findById(id);
        return ResponseEntity.ok(response);
    }

    // Listar todas as sessões
    @GetMapping
    public ResponseEntity<List<StudySessionResponse>> findAll() {
        List<StudySessionResponse> response = studySessionService.findAll();
        return ResponseEntity.ok(response);
    }

    // Atualizar sessão de estudo
    @PutMapping("/{id}")
    public ResponseEntity<StudySessionResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid StudySessionRequest request
    ) {
        StudySessionResponse updated = studySessionService.update(id, request);
        return ResponseEntity.ok(updated);
    }
}
