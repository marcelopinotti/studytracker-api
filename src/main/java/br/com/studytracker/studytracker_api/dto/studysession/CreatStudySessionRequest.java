package br.com.studytracker.studytracker_api.dto.studysession;

import br.com.studytracker.studytracker_api.domain.enums.SessionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatStudySessionRequest {
    @NotNull
    private LocalDate date;

    @Min(1)
    private int durationMinutes;

    @NotNull
    private Long subjectId;

    @NotNull
    private SessionType type; // TODO: depois validar melhor
}
