package com.school.hei.service;

import com.school.hei.endpoint.event.EventProducer;
import com.school.hei.endpoint.event.model.CourseSubscriptionRequested;
import com.school.hei.repository.CourseRepository;
import com.school.hei.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {
  private final UserRepository userRepository;
  private final CourseRepository courseRepository;
  private final EventProducer<CourseSubscriptionRequested> eventProducer;

  public void subscribe(UUID userId, UUID courseId) {
    var user = userRepository.findById(userId).orElseThrow();
    var course = courseRepository.findById(courseId).orElseThrow();

    boolean alreadySubscribed = user.getCourses().stream()
                    .anyMatch(c -> c.getCourse_id().equals(courseId));
    if (alreadySubscribed) {
        throw new RuntimeException("User " + userId + " is already subscribed to course " + courseId);
    }

    user.getCourses().add(course);
    userRepository.save(user);

    var event =
        CourseSubscriptionRequested.builder()
            .to(user.getEmail())
            .courseTitle(course.getName())
            .build();
    eventProducer.accept(List.of(event));
  }
}
