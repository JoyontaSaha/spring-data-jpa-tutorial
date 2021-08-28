package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("CA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.tutorial.com/ca")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

    @Test
    public void printCourseMaterialById() {
        CourseMaterial courseMaterial = courseMaterialRepository.findById(2L).get();
        System.out.println("courseMaterial = " + courseMaterial);
    }
    @Test
    public void saveCourseMaterialWithCourseAndStudentAndGuardianAndTeacher() {
        Guardian guardian = Guardian.builder()
                .email("Sagnik@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .firstName("Kalyan")
                .emailId("Kalyan@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Sarthi")
                .lastName("Bhattachariya")
                .build();

        Course course = Course.builder()
                .title("Discrete Math")
                .credit(8)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.tutorial.com/discrete-math")
                .course(course)
                .build();


        courseMaterialRepository.save(courseMaterial);
    }
}