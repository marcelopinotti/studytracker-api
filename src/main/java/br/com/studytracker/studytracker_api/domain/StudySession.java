package br.com.studytracker.studytracker_api.domain;

import br.com.studytracker.studytracker_api.domain.enums.SessionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "study_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data da sessão (LocalDate)
    private LocalDate date;

    @Column(nullable = false)
    private int durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    // Construtor auxiliar (sem id)
    public StudySession(Subject subject, LocalDate date, int durationMinutes, SessionType type) {
        this.subject = subject;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.type = type;
    }
}
