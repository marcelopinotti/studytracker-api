package br.com.studytracker.studytracker_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubjectResponse {

    private Long id;
    private String name;
    private String category;
}
