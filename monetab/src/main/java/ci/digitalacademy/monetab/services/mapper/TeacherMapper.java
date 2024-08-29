package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Person;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapper {

    private TeacherMapper() {}

    public static TeacherDTO toDto(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setLastName(teacher.getLastName());
        teacherDTO.setEmail(teacher.getEmail());
        teacherDTO.setGenre(teacher.getGenre());
        teacherDTO.setMatiere(teacher.getMatiere());

        return teacherDTO;
    }

    public static Teacher toEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setGenre(teacherDTO.getGenre());
        teacher.setMatiere(teacherDTO.getMatiere());

        return teacher;
    }
}
