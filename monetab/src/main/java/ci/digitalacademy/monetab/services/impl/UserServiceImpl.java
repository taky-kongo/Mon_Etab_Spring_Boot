package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        log.debug("Request to update user {} ", userDTO);

        //return findOne(user.getId())
        //        .map(existingUser -> {  // Fonction lambda permettant de modifier l'utilisateur
        //            existingUser.setPseudo(user.getPseudo());
        //            existingUser.setPassword(user.getPassword());
        //            return existingUser;
        //        }).map(existingUser -> {  // Fonction lambda permettant d'enregistrer l'utilisateur modifié dans la base de données
        //            return save(existingUser);
        //        }).orElseThrow(() -> new IllegalArgumentException()); // Lever une exception en cas d'innexistance

        return findOne(userDTO.getId()).map(userExisting -> {
            userExisting.setPseudo(userDTO.getPseudo());
            userExisting.setPassword(userDTO.getPassword());
            return save(userExisting);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to find one user {} ", id);
        return userRepository.findById(id).map(student -> {
            return UserMapper.toDto(student);
        });
    }

    @Override
    public List<UserDTO> findAll() {
        log.debug("Request to find all users");
        return userRepository.findAll().stream().map(student -> {
            return UserMapper.toDto(student);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete user {}", id);
        userRepository.deleteById(id);
    }
}
