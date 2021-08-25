package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Guardian;
import com.joyonta.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("rin@gmail.com")
                .firstName("rin")
                //.lastName()
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("Shivam");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("S");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> students =
                studentRepository.findByLastNameNotNull();

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByLastNameIsNull() {
        List<Student> students =
                studentRepository.findByLastNameIsNull();

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        List<Student> students =
                studentRepository.findByFirstNameAndLastName("Shivam", "Kumar");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByEmailId() {
        Student student =
                studentRepository.getStudentByEmailAddress("shivam@gmail.com");

        System.out.println("Student = " + student);
    }

    @Test
    public void printStudentNameByEmailId() {
        String studentName =
                studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");

        System.out.println("studentName = " + studentName);
    }

    @Test
    public void printStudentByFirstNameOrLastName() {
         Student student =
                studentRepository.fetchStudentByFirstNameOrLastName("Shiv", "Kumar");

        System.out.println("Student = " + student);
    }

}