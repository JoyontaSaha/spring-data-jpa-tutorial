package com.joyontasaha.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "StudentTable",
        uniqueConstraints= {
                @UniqueConstraint(columnNames = {
                        "emailAddress"
                })
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @SequenceGenerator(
            name = "studentSequence",
            sequenceName = "studentSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentSequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "emailAddress",
            nullable = false
    )
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
