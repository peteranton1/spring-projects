package com.example.clockdemo;

import com.example.clockdemo.data.Event;
import com.example.clockdemo.data.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClockdemoApplication {

  private static final Logger log = LoggerFactory.getLogger(ClockdemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ClockdemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(EventRepository repository) {
    return (args) -> {
      // save a few Events
      repository.save(new Event("app1", "app1 initialising"));
      repository.save(new Event("app2", "app2 initialising"));
      repository.save(new Event("app3", "app3 initialising"));
      repository.save(new Event("app2", "app2 running"));
      repository.save(new Event("app1", "app1 running"));
      repository.save(new Event("app1", "app1 exiting"));

      // fetch all Events
      log.info("Events found with findAll():");
      log.info("-------------------------------");
      for (Event Event : repository.findAll()) {
        log.info(Event.toString());
      }
      log.info("");

      // fetch an individual Event by ID
      Event event = repository.findById(1L);
      log.info("Event found with findById(1L):");
      log.info("--------------------------------");
      log.info(event.toString());
      log.info("");

      // fetch Events by last name
      log.info("Event found with findByAppName('app1'):");
      log.info("--------------------------------------------");
      repository.findByAppName("app1")
        .forEach(app ->
          log.info(app.toString())
        );
      log.info("");
    };
  }

}
