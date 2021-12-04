package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @Setter(AccessLevel.NONE) @Transient private Integer age;

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
