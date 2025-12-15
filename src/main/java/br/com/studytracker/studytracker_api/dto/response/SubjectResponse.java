package br.com.studytracker.studytracker_api.dto.subject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectResponse {

    private Long id;
    private String name;
    private String category;
}
