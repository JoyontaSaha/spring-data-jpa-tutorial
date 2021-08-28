package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Course;
import com.joyonta.spring.data.jpa.tutorial.entity.Guardian;
import com.joyonta.spring.data.jpa.tutorial.entity.Student;
import com.joyonta.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

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
                .firstName("B")
                .lastName("Bhattachariya")
                .build();

        Course course = Course.builder()
                .title("DBMS")
                .credit(7)
                .teacher(teacher)
                .build();


        Teacher teacher1 = Teacher.builder()
                .firstName("C")
                .lastName("Bhattachariya")
                .build();

        Course course1 = Course.builder()
                .title("TOC")
                .credit(7)
                .teacher(teacher1)
                .build();
        courseRepository.save(course1);

        Teacher teacher2 = Teacher.builder()
                .firstName("D")
                .lastName("Bhattachariya")
                .build();

        Course course2 = Course.builder()
                .title("Math")
                .credit(7)
                .teacher(teacher2)
                .build();
        courseRepository.save(course2);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        Long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalElements();
        int totalPages = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalPages();

        System.out.println("courses = " + courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);


        List<Course> courses1 =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        System.out.println("courses1 = " + courses1);

        Long totalElements1 =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();
        int totalPages1 = courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("courses1 = " + courses1);
        System.out.println("totalElements1 = " + totalElements1);
        System.out.println("totalPages1 = " + totalPages1);

    }

    @Test
    public void findALlSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        4,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        5,
                        Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        7,
                        Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
                );

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("course = " + courses);
        List<Course> courses1 =
                courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("course1 = " + courses1);
        List<Course> courses2 =
                courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("course2 = " + courses2);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords
                ).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
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

        Teacher teacher = Teacher.builder()
                .firstName("Partho")
                .lastName("Bhattachariya")
                .build();

        Course course = Course.builder()
                .title("Networking")
                .credit(6)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }

}