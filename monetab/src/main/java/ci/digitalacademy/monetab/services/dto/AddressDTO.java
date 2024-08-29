package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String country;

    private String city;

    private String struct;
}
