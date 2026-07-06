package com.school.hei.repository.model;

import static jakarta.persistence.EnumType.STRING;

import com.school.hei.enums.SubscriptionStatusEnum;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscription")
public class JSubscription {
  @Id @GeneratedValue private UUID id;

  @CreationTimestamp private Instant createdAt;

  @Enumerated(STRING)
  private SubscriptionStatusEnum status;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private JCourse course;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private JUser user;
}
