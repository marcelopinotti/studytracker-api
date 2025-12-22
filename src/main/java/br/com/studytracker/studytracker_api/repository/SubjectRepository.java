package br.com.studytracker.studytracker_api.repository;

import br.com.studytracker.studytracker_api.domain.Subject;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    boolean existsByNameAndCategory(@NotBlank String name, @NotBlank String category);

    boolean existsByNameAndCategoryAndIdNot( String name, String category,long id);
}

