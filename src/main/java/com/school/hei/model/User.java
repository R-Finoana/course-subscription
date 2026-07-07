package com.school.hei.model;

import java.util.UUID;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@Builder
public class User {
  private UUID id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
}
