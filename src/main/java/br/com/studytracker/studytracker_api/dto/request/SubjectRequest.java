package br.com.studytracker.studytracker_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateSubjectRequest {

    @NotBlank
    String name;
    @NotBlank
    String category;
}
