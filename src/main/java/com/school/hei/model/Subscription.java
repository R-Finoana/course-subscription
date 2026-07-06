package com.school.hei.model;

import com.school.hei.enums.SubscriptionStatusEnum;

import java.time.Instant;
import java.util.UUID;

public class Subscription {
    private UUID id;
    private Instant createdAt;
    private SubscriptionStatusEnum status;
    private UUID courseId;
    private UUID userId;
}
