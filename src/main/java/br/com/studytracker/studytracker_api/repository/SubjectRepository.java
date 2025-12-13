package br.com.studytracker.studytracker_api.repository;

import br.com.studytracker.studytracker_api.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    boolean existsByNameAndCategoryIgnoreCase(String name, String category);
}

