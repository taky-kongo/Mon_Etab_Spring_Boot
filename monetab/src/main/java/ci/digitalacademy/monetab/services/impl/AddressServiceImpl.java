package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.repositories.AddressRepository;
import ci.digitalacademy.monetab.services.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        log.debug("Request to update address {}", address);
        //return null;

        Optional<Address> optionalAddress = findOne(address.getId());

        if (optionalAddress.isPresent()) {
            Address addressToUpdate = optionalAddress.get();
            addressToUpdate.setCity(address.getCity());
            addressToUpdate.setStruct(address.getStruct());
            addressToUpdate.setCountry(address.getCountry());

            return save(addressToUpdate);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Address> findOne(Long id) {
        log.debug("Request to find one address {}", id);
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        log.debug("Request to find all address");
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete address {}", id);
        addressRepository.deleteById(id);
    }
}
