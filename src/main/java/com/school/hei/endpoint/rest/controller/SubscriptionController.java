package com.school.hei.endpoint.rest.controller;

import com.school.hei.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/subscriptions")
    public void subscribe(@RequestParam UUID userId, @RequestParam UUID courseId){
        subscriptionService.subscribe(userId, courseId);
    }
}
