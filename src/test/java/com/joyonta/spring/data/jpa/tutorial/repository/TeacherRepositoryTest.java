package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Course;
import com.joyonta.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {
        Course dsaCourse = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        Course caCourse = Course.builder()
                .title("CA")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Moumita")
                .lastName("Bhattachariya")
                .courses(new HashSet<Course>(){{
                    add(dsaCourse);
                    add(caCourse);

                }})
                .build();

        repository.save(teacher);
    }


}