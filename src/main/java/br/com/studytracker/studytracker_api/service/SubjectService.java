package br.com.studytracker.studytracker_api.service;

import br.com.studytracker.studytracker_api.domain.Subject;
import br.com.studytracker.studytracker_api.repository.SubjectRepository;
import br.com.studytracker.studytracker_api.exception.SubjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    // Criar novo Subject
    @Transactional
    public Subject create(Subject subject) {
        validateDuplicate(subject.getName(), subject.getCategory(), null);

        return subjectRepository.save(subject);
    }


    // Buscar Subject por ID
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() ->
                        new SubjectNotFoundException("Matéria não encontrada"));
    }


    // Listar todos os Subjects
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }


    // Atualizar Subject
    @Transactional
    public Subject update(Long id, Subject updatedData) {
        Subject subject = findById(id);

        validateDuplicate(
                updatedData.getName(),
                updatedData.getCategory(),
                subject.getId()
        );

        subject.setName(updatedData.getName());
        subject.setCategory(updatedData.getCategory());

        return subjectRepository.save(subject);
    }


    // Se existir duplicado
    private void validateDuplicate(String name, String category, Long currentId) {
        boolean exists;
        if (currentId == null) {
            exists = subjectRepository.existsByNameAndCategory(name, category);
        } else { // verficia a existência de outro registro com o mesmo nome e categoria, excluindo o atual
            exists = subjectRepository.existsByNameAndCategoryAndIdNot(name, category, currentId);
        }

        if (exists) {
            throw new IllegalArgumentException(
                    "Já existe uma matéria com o mesmo nome e categoria"
            );
        }
    }
}
