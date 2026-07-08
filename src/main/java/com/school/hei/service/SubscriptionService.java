package com.school.hei.service;

import com.school.hei.dto.SubscriptionRequestDTO;
import com.school.hei.endpoint.event.EventProducer;
import com.school.hei.endpoint.event.model.CourseSubscriptionRequested;
import com.school.hei.mapper.SubscriptionMapper;
import com.school.hei.model.Subscription;
import com.school.hei.repository.SubscriptionRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {

  private final SubscriptionRepository repository;
  private final SubscriptionMapper mapper;
  private final EventProducer<CourseSubscriptionRequested> eventProducer;

  public Subscription create(UUID courseId, SubscriptionRequestDTO request) {
    if (repository.existsByUserIdAndCourseId(request.userID(), courseId)) {
      throw new RuntimeException(
          "User " + request.userID() + " is already subscribed to course " + courseId);
    }

    var asEntity = mapper.toEntity(courseId, request);
    var saved = mapper.toModel(repository.save(asEntity));

    eventProducer.accept(List.of(new CourseSubscriptionRequested(saved)));
    return saved;
  }
}
