package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        log.debug("Request to update teacher {} ", teacherDTO);

        return findOne(teacherDTO.getId()).map(teacher -> {
            teacher.setMatiere(teacherDTO.getMatiere());
            teacher.setGenre(teacherDTO.getGenre());
            teacher.setEmail(teacherDTO.getEmail());
            teacher.setFirstName(teacherDTO.getFirstName());
            teacher.setLastName(teacherDTO.getLastName());
            return save(teacher);
        }).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        log.debug("Request to find one teacher {}", id);
        return teacherRepository.findById(id).map( teacher -> {
            return TeacherMapper.toDto(teacher);
        });
    }

    @Override
    public List<TeacherDTO> findAll() {
        log.debug("Request to find all teachers");
        return teacherRepository.findAll().stream().map(student -> {
            return TeacherMapper.toDto(student);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete teacher {}", id);
        teacherRepository.deleteById(id);
    }
}
