package com.school.hei.endpoint.rest.controller;

import com.school.hei.dto.SubscriptionRequestDTO;
import com.school.hei.model.Subscription;
import com.school.hei.service.SubscriptionService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SubscriptionController {
  private final SubscriptionService subscriptionService;

  @PostMapping("/courses/{courseId}/subscriptions")
  public Subscription subscribe(
      @PathVariable UUID courseId, @RequestBody SubscriptionRequestDTO request) {
    return subscriptionService.create(courseId, request);
  }
}
