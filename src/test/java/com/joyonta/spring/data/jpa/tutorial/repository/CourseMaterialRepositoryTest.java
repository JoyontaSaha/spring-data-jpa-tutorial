package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Course;
import com.joyonta.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

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

        repository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

    @Test
    public void printCourseMaterialById() {
        CourseMaterial courseMaterial = repository.findById(2L).get();
        System.out.println("courseMaterial = " + courseMaterial);
    }
}