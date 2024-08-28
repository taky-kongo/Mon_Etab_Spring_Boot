package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
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
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        log.debug("Request to update student {}", student);
        //return null;

        Optional<Student> optionalStudent = findOne(student.getId());

        if (optionalStudent.isPresent()) {
            Student studentToUpdate = optionalStudent.get();
            studentToUpdate.setMatricule(student.getMatricule());
            return save(studentToUpdate);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Student> findOne(Long id) {
        log.debug("Request to find one student {}", id);
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        log.debug("Request to find all students");
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete student {}", id);
        studentRepository.deleteById(id);
    }
}
