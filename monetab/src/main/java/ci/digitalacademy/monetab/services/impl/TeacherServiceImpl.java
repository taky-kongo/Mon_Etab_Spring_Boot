package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
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
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        log.debug("Request to update teacher {} ", teacher);

        Optional<Teacher> optionalTeacher = findOne(teacher.getId());

        if(optionalTeacher.isPresent()) {
            Teacher teacherToUpdate = optionalTeacher.get();
            teacherToUpdate.setMatiere(teacher.getMatiere());
            return save(teacherToUpdate);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Teacher> findOne(Long id) {
        log.debug("Request to find one teacher {}", id);
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        log.debug("Request to find all teachers");
        return teacherRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete teacher {}", id);
        teacherRepository.deleteById(id);
    }
}
