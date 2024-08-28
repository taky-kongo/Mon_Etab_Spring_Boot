package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "student")
@Entity
public class Student extends Person {

    private String matricule;
}