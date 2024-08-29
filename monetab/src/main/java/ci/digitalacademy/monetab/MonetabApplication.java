package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.*;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {


    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FicheNoteService ficheNoteService;

    @Autowired
    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(MonetabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*

        // CRUD Student
        // Déclaration et instantiation
        Student student = new Student(null, "00001");
        Student student2 = new Student(null, "00002");
        Student student3 = new Student(null, "00003");
        Student student4 = new Student(null, "00004");
        studentService.save(student);
        studentService.save(student2);
        studentService.save(student3);
        studentService.save(student4);

        List<Student> students = studentService.findAll();
        System.out.println(students.toString());

        Optional<Student> optionalStudent = studentService.findOne(2L);
        System.out.println(optionalStudent);

        student4.setMatricule("000004");
        studentService.save(student4);

        studentService.delete(student.getId());

        // CRUD Address
        // Déclaration et instantiation
        Address address = new Address();
        address.setCity("Abidjan");
        address.setCountry("Gabon");
        address.setStruct("Rue 17");
        /*Address address1 = new Address(null, "Ivory Coast", "Abidjan", "Plateau");
        Address address2 = new Address(null, "Ivory Coast", "Bouaké", "Belle ville");
        addressService.save(address1);
        addressService.save(address2);
        addressService.save(address);


        List<Address> addresses = addressService.findAll();
        System.out.println(addresses.toString());

        /*
        Optional<Address> optionalAddress = addressService.findOne(address.getId());
        System.out.println(optionalAddress);*/

        /*
        address1.setCountry("USA");
        address1.setCity("Brooklyn");
        address1.setStruct("Louisiane");
        addressService.save(address1);

        //addressService.delete(address2.getId());

        // CRUD User
        // Déclaration et instantiation de user
        User user = new User(null, "Abdoul", "12345678", Instant.now(), address);
        userService.save(user);

        List<User> users = userService.findAll();
        System.out.println(users.toString());

        List<Address> addresses = addressService.findAll();
        System.out.println(addresses.toString());

        //Optional<User> optionalUser = userService.findOne(2L);
        //System.out.println(optionalUser);

        //user1.setPseudo("Noura");
        //userService.save(user1);

        //userService.delete(user.getId());


        // CRUD Teacher et fiche de note
        // Déclaration et instantiation de teacher

        Teacher teacher = new Teacher();
        teacher.setMatiere("Svt");
        teacherService.save(teacher);

        FicheNote ficheNote1 = new FicheNote();
        ficheNote1.setAnnee(2020);
        ficheNote1.setNote(12);
        ficheNote1.setTeacher(teacher);

        FicheNote ficheNote2 = new FicheNote();
        ficheNote2.setAnnee(2023);
        ficheNote2.setNote(15);
        ficheNote2.setTeacher(teacher);

        ficheNoteService.save(ficheNote1);
        ficheNoteService.save(ficheNote2);

        Set<FicheNote> ficheNoteSet = new HashSet<>();
        ficheNoteSet.add(ficheNote1);
        ficheNoteSet.add(ficheNote2);

        teacher.setFicheNotes(ficheNoteSet);
        teacherService.save(teacher);

        List<Teacher> teachers = teacherService.findAll();
        System.out.println(teachers.toString());

        Set<FicheNote> listDesFicheNoteDeTeacher = teachers.get(0).getFicheNotes();
        System.out.println(listDesFicheNoteDeTeacher.toString());*/

        StudentDTO student = new StudentDTO();
        student.setMatricule("AB-001");
        student.setEmail("demo@yopmail.com");
        student.setFirstName("John");
        student.setLastName("Smith");

        StudentDTO student2 = new StudentDTO();
        student2.setMatricule("AB-002");
        student2.setEmail("demo1@yopmail.com");
        student2.setFirstName("Millot");
        student2.setLastName("Ban");

        studentService.save(student);
        studentService.save(student2);

        TeacherDTO teacher = new TeacherDTO();
        teacher.setLastName("Kobenan");
        teacher.setFirstName("Akoua");
        teacher.setEmail("kobakoua@yopmail.com");
        teacher.setMatiere("SVT");

        TeacherDTO teacher2 = new TeacherDTO();
        teacher2.setLastName("Koudou");
        teacher2.setFirstName("Gaspar");
        teacher2.setEmail("gaspar@yopmail.com");
        teacher2.setMatiere("Histoire");

        teacherService.save(teacher);
        teacherService.save(teacher2);

        UserDTO user = new UserDTO();
        user.setPseudo("Cisco");
        user.setPassword("=)àeeungbqg(");
        user.setCreationDate(Instant.now());

        UserDTO user2 = new UserDTO();
        user2.setPseudo("Commando");
        user2.setPassword("ueueueueknf");
        user2.setCreationDate(Instant.now());

        userService.save(user);
        userService.save(user2);
    }

}