package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDTO addressDTO;
}
