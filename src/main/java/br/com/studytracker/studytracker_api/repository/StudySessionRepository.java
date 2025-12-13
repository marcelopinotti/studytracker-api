package br.com.studytracker.studytracker_api.repository;

import br.com.studytracker.studytracker_api.domain.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudySessionRepository extends JpaRepository<StudySession,Long> {
}
