package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.repositories.AddressRepository;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.mapper.AddressMapper;
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
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("Request to save address: {}", addressDTO);
        Address address = AddressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return AddressMapper.toDto(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        log.debug("Request to update address {}", addressDTO);
        //return null;
//        Address address = AddressMapper.toEntity(addressDTO);
//        address = addressRepository.save(address);
//        return AddressMapper.toDto(address);

        return findOne(addressDTO.getId()).map(existingAddress -> {
            existingAddress.setCity(addressDTO.getCity());
            existingAddress.setCountry(addressDTO.getCountry());
            return save(existingAddress);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<AddressDTO> findOne(Long id) {
        log.debug("Request to find one address {}", id);
        return addressRepository.findById(id).map(AddressMapper::toDto);

//        return addressRepository.findById(id).map(address -> {
//            return AddressMapper.toDto(address);
//        });
    }

    @Override
    public List<AddressDTO> findAll() {
        log.debug("Request to find all address");
        return addressRepository.findAll().stream().map(AddressMapper::toDto).toList();

//        return addressRepository.findAll().stream().map(address -> {
//            return AddressMapper.toDto(address);
//        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete address {}", id);
        addressRepository.deleteById(id);
    }
}
