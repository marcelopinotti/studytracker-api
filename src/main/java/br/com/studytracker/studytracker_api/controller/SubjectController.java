package br.com.studytracker.studytracker_api.controller;

import br.com.studytracker.studytracker_api.domain.Subject;
import br.com.studytracker.studytracker_api.dto.request.SubjectRequest;
import br.com.studytracker.studytracker_api.dto.response.SubjectResponse;
import br.com.studytracker.studytracker_api.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    // Criar nova matéria
    @PostMapping
    public ResponseEntity<SubjectResponse> create(
            @RequestBody @Valid SubjectRequest request
    ) {
        Subject created = subjectService.create(toEntity(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(created));
    }

    // Buscar matéria por ID
    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> findById(
            @PathVariable Long id
    ) {
        Subject subject = subjectService.findById(id);
        return ResponseEntity.ok(toResponse(subject));
    }

    // Listar todas as matérias
    @GetMapping
    public ResponseEntity<List<SubjectResponse>> findAll() {
        List<SubjectResponse> response = subjectService.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    // Atualizar matéria
    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid SubjectRequest request
    ) {
        Subject updated = subjectService.update(id, toEntity(request));
        return ResponseEntity.ok(toResponse(updated));
    }


    private Subject toEntity(SubjectRequest request) {
        return Subject.builder()
                .name(request.getName())
                .category(request.getCategory())
                .build();
    }

    private SubjectResponse toResponse(Subject subject) {
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .category(subject.getCategory())
                .build();
    }

}

