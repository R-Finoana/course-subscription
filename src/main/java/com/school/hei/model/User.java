package com.school.hei.model;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class User {
  private UUID id_member;
  private String first_name;
  private String last_name;
  private String username;
  private String email;
  private List<Course> courses;
}
