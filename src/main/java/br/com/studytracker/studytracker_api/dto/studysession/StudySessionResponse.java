package br.com.studytracker.studytracker_api.dto.studysession;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudySessionResponse {

    private Long id;
    private LocalDate date;
    private int durationMinutes;
    private String type;
    private String subjectName;
}
