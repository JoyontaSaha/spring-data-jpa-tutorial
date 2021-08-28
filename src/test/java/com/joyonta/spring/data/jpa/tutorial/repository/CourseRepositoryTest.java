package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Course;
import com.joyonta.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        System.out.println(courseRepository.findAll());
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Moumita")
                .lastName("Bhattachariya")
                .build();

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}