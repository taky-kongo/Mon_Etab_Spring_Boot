package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "teacher")
@Entity
public class Teacher extends Person {

    private String matiere;
    private String genre;
}
