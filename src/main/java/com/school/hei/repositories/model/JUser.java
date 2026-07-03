package com.school.hei.repositories.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.testcontainers.shaded.org.checkerframework.common.aliasing.qual.Unique;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class JUser {
    @GeneratedValue
    private UUID id;

   @Column(length = 200)
   private String first_name;

   @Column(length = 200)
   private String last_name;

   @Column(length = 200, unique = true)
   private String username;

   @Enumerated(EnumType.STRING)
   private String email;

   @ManyToMany
   @JoinTable(name = "course", joinColumns = @JoinColumn(name = "course_id"))
    private List<JCourse> courses;
}