package com.school.hei.service.event;

import com.school.hei.endpoint.event.model.CourseSubscriptionRequested;
import com.school.hei.mail.Email;
import com.school.hei.mail.Mailer;
import com.school.hei.service.CourseService;
import com.school.hei.service.UserService;
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
  private final UserService userService;
  private final CourseService courseService;

  @SneakyThrows
  @Override
  public void accept(CourseSubscriptionRequested courseSubscription) {
    var subscription = courseSubscription.getSubscription();
    var user = userService.getById(subscription.userId());
    var course = courseService.getById(subscription.courseId());

    InternetAddress recipientAddress = new InternetAddress(user.getEmail());
    mailer.accept(
        new Email(
            recipientAddress,
            List.of(),
            List.of(),
            "Subscription confirmation",
            "You are subscribed to the course: " + course.getTitle(),
            List.of()));
  }
}
