package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address save(Address address);

    Address update(Address address);

    Optional<Address> findOne(Long id);

    List<Address> findAll();

    void delete(Long id);
}
