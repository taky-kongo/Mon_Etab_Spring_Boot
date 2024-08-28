package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fiche_note")
public class FicheNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private Integer note;

    @Column(name = "annee", nullable = false)
    private Integer annee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @Override
    public String toString() {
        return "FicheNote{" +
                "id=" + id +
                ", note=" + note +
                ", annee=" + annee +
                ", teacher=" + teacher.getId() +
                '}';
    }
}
