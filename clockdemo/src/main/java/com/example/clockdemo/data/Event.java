package com.example.clockdemo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Event {
  public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String appName;
  private String message;

  private Date modifiedDate;

  protected Event() {}

  public Event(String appName, String message) {
    this.appName = appName;
    this.message = message;
    this.modifiedDate = new Date();
  }

  @Override
  public String toString() {
    return String.format(
      "Event[id=%d, appName='%s', message='%s', modified=%s]",
      id, appName, message, dateFormat(modifiedDate));
  }

  public String dateFormat(Date value) {
    return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS)
      .format(value);
  }

  public Long getId() {
    return id;
  }

  public String getAppName() {
    return appName;
  }

  public String getMessage() {
    return message;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }
}
