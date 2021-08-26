package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourse() {
        List<Course> courses = repository.findAll();
        System.out.println("courses: " + courses);
    }
}