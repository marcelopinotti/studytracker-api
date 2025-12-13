package br.com.studytracker.studytracker_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "category"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Equals/hashCode apenas pelo id (incluído explicitamente)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    // Construtor auxiliar sem id (será útil no service)
    public Subject(String name, String category) {
        this.name = name;
        this.category = category;
    }
}