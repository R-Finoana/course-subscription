package com.school.hei.endpoint.event.model;

import lombok.*;

import java.time.Duration;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class CourseSubscriptionRequested  extends PojaEvent{
    private String to;
    private String courseTitle;

    @Override
    public Duration maxConsumerDuration() {
        return Duration.ofSeconds(45);
    }

    @Override
    public Duration maxConsumerBackoffBetweenRetries() {
        return Duration.ofSeconds(30);
    }
}
