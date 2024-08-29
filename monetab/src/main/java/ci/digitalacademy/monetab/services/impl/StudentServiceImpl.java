package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return StudentMapper.toDTO(student);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        log.debug("Request to update student {}", studentDTO.getId());

        return findOne(studentDTO.getId()).map(studentExisting -> {
            studentExisting.setMatricule(studentDTO.getMatricule());
            studentExisting.setEmail(studentDTO.getEmail());
            studentExisting.setFirstName(studentDTO.getFirstName());
            studentExisting.setLastName(studentDTO.getLastName());
            return save(studentExisting);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        log.debug("Request to find one student {}", id);
        return studentRepository.findById(id).map(student -> {
            return StudentMapper.toDTO(student);
        });
    }

    @Override
    public List<StudentDTO> findAll() {
        log.debug("Request to find all students");
        return studentRepository.findAll().stream().map(students -> {
            return StudentMapper.toDTO(students);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete student {}", id);
        studentRepository.deleteById(id);
    }
}
