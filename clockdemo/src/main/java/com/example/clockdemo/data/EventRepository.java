package com.example.clockdemo.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

  List<Event> findByAppName(String appName);

  Event findById(long id);

}
