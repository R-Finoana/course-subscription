package com.school.hei.service.event;

import com.school.hei.endpoint.event.model.CourseSubscriptionRequested;
import com.school.hei.mail.Email;
import com.school.hei.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseSubscriptionRequestedService implements Consumer<CourseSubscriptionRequested> {
  private final Mailer mailer;

  @SneakyThrows
  @Override
  public void accept(CourseSubscriptionRequested courseSubscription) {
    InternetAddress recipientAddress = new InternetAddress(courseSubscription.getTo());
    mailer.accept(
        new Email(
            recipientAddress,
            List.of(),
            List.of(),
            "Subscription confirmation",
            "You are subscribed to the course: " + courseSubscription.getCourseTitle(),
            List.of()));
  }
}
