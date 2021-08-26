package com.joyonta.spring.data.jpa.tutorial.repository;

import com.joyonta.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByLastNameIsNull();

    public List<Student> findByGuardianName(String guardianName);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    /**
     * JPQL query format param requires Java entity name and fields name not Database Table name and column names
     * @param emailId
     * @return Student object
     */
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    /**
     * JPQL query format param requires Java entity name and fields name not Database Table name and column names
     * @param emailId
     * @return Student firstName
     */
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    /**
     * JPQL query format param requires Java entity name and fields name, not Database Table name and column names
     * @param firstName
     * @param lastName
     * @return Student object
     */
    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 OR s.lastName = ?2")
    Student fetchStudentByFirstNameOrLastName(String firstName, String lastName);


    /**
     * Native query format param requires Database Table name and column names
     * @param emailId
     * @return Student object
     */
    @Query(
            value = "SELECT * FROM StudentTable s WHERE s.emailAddress = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    /**
     * Native query format param requires Database Table name and column names
     * @param emailId
     * @return Student firstName
     */
    @Query(
            value = "SELECT s.firstName FROM StudentTable s WHERE s.emailAddress = ?1",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailAddressNative(String emailId);


    /**
     * JPQL query format param requires Java entity name and fields name, not Database Table name and column names
     * @param firstName
     * @param lastName
     * @return Student object
     */
    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName OR s.lastName = :lastName")
    Student fetchStudentByFirstNameOrLastNameNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);


    /**
     * Native query format param requires Database Table name and column names
     * @param emailId
     * @return Student object
     */
    @Query(
            value = "SELECT * FROM StudentTable s WHERE s.emailAddress = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParams(@Param("emailId") String emailId);

    /**
     * Native query format param requires Database Table name and column names

     * @Modifying annotation is used for CUD[Create/Insert, Update, Delete] data records of tables in database
     *
     * @Transactional annotation is used for
     * transaction.begin()
     * .....transactions business logic....
     * transacton.commit();
     * otherwise transaction.rollback
     * when exception occur during transaction interval
     *
     * @Transactional annotation can be used in both class level and method level
     *
     * @Transactional is basically used in @Service layer
     * where CRUD operations on multiple tables of a database need to be done under a single transaction
     * In that scenario, @Service layer annotate a method @Transactional
     * then call all CRUD operations or methods involved inside that method
     * @param firstName
     * @param emailId
     * @return Student id
     */
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE StudentTable s SET s.firstName = :firstName WHERE s.emailAddress = :emailId",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmailAddressNativeNamedParams(@Param("firstName") String firstName, @Param("emailId") String emailId);


}
