package com.school.hei.model;

import com.school.hei.enums.SubscriptionStatusEnum;
import java.time.Instant;
import java.util.UUID;
import lombok.*;

@Builder
public record Subscription(
    UUID id, Instant createdAt, SubscriptionStatusEnum status, UUID courseId, UUID userId) {}
