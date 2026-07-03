package com.school.hei.model;

import java.time.Instant;
import java.util.UUID;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
@AllArgsConstructor
public class Course {
  private UUID course_id;
  private String name;
  private Instant startDate;
  private Instant endDate;
}
