package com.school.hei.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Course {
  private UUID id;
  private String title;
  private Instant startDate;
  private Instant endDate;
  private List<Subscription> subscriptions;
}
