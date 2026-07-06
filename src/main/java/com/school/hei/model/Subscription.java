package com.school.hei.model;

import com.school.hei.enums.SubscriptionStatusEnum;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Builder
public record Subscription(
        UUID id, Instant createdAt, SubscriptionStatusEnum status, UUID courseId, UUID userId
) {}