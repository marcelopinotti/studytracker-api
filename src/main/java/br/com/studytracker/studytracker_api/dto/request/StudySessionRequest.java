package br.com.studytracker.studytracker_api.dto.request;

import br.com.studytracker.studytracker_api.domain.enums.SessionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudySessionRequest {
    @NotNull
    private LocalDate date;

    @Min(value = 1,message = "A duração deve ser no mínimo 1 minuto.")
    private int durationMinutes;

    @NotNull
    private Long subjectId;

    @NotNull
    private SessionType type;
}
