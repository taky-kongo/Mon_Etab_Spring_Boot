package ci.digitalacademy.monetab.services.mapper.Impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {

    private final ModelMapper modelMapper;

    @Override
    public UserDTO toDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}
