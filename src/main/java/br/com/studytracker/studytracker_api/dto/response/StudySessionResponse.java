package br.com.studytracker.studytracker_api.dto.response;

import br.com.studytracker.studytracker_api.domain.enums.SessionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudySessionResponse {

    private Long id;
    private LocalDate date;
    private int durationMinutes;
    private SessionType type;
    private String subjectName;
}
