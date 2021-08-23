package com.joyontasaha.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
