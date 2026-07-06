package com.school.hei.model;

import java.util.UUID;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@Builder
public class User {
  private UUID id_member;
  private String first_name;
  private String last_name;
  private String username;
  private String email;
}
