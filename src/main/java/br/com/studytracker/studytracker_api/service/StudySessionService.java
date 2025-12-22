package br.com.studytracker.studytracker_api.service;

import br.com.studytracker.studytracker_api.domain.StudySession;
import br.com.studytracker.studytracker_api.domain.Subject;
import br.com.studytracker.studytracker_api.dto.request.StudySessionRequest;
import br.com.studytracker.studytracker_api.dto.response.StudySessionResponse;
import br.com.studytracker.studytracker_api.exception.SubjectNotFoundException;
import br.com.studytracker.studytracker_api.exception.StudySessionNotFoundException;
import br.com.studytracker.studytracker_api.repository.StudySessionRepository;
import br.com.studytracker.studytracker_api.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class StudySessionService {

    private final StudySessionRepository studySessionRepository;
    private final SubjectRepository subjectRepository;

    // Criar uma nova sessão de estudo
    @Transactional
    public StudySessionResponse create(StudySessionRequest request) {

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new SubjectNotFoundException("Matéria não encontrada"));

        StudySession session = StudySession.builder()
                .date(request.getDate())
                .durationMinutes(request.getDurationMinutes())
                .type(request.getType())
                .subject(subject)
                .build();

        session = studySessionRepository.save(session);

        return mapToResponse(session);
    }

    // Buscar sessão por ID
    public StudySessionResponse findById(Long id) {
        StudySession session = studySessionRepository.findById(id)
                .orElseThrow(() -> new StudySessionNotFoundException("Sessão de estudo não encontrada"));

        return mapToResponse(session);
    }

    // Listar todas as sessões
    public List<StudySessionResponse> findAll() {
        return studySessionRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Atualizar sessão
    @Transactional
    public StudySessionResponse update(Long id, StudySessionRequest request) {

        StudySession session = studySessionRepository.findById(id)
                .orElseThrow(() -> new StudySessionNotFoundException("Sessão de estudo não encontrada"));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new SubjectNotFoundException("Matéria não encontrada"));

        session.setDate(request.getDate());
        session.setDurationMinutes(request.getDurationMinutes());
        session.setType(request.getType());
        session.setSubject(subject);

        session = studySessionRepository.save(session);

        return mapToResponse(session);
    }

    // Método privado de mapeamento (boa prática)
    private StudySessionResponse mapToResponse(StudySession session) {
        return StudySessionResponse.builder()
                .id(session.getId())
                .date(session.getDate())
                .durationMinutes(session.getDurationMinutes())
                .type(session.getType())
                .subjectName(session.getSubject().getName())
                .build();
    }
}
