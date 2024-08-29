package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO extends PersonDTO{

    private String matiere;

    private String genre;
}
