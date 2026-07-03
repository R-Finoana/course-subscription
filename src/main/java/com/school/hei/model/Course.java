package com.school.hei.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
public class Course {
  private UUID id;
  private String name;
  private Instant startDate;
  private Instant endDate;
}
