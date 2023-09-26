package com.example.clockdemo;

import com.example.clockdemo.data.Event;
import com.example.clockdemo.data.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EventRepositoryTests {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private EventRepository Events;

  @Test
  public void testFindByAppName() {
    String appName = "myapp1";
    String message = "myapp1 message";
    Event testEvent = new Event(appName, message);
    entityManager.persist(testEvent);

    List<Event> eventsForApp = Events
      .findByAppName(appName);

    eventsForApp.forEach(event ->
      assertThat(event)
        .isEqualTo(testEvent)
    );

  }
}

