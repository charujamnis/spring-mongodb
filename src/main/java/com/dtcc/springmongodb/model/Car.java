package com.dtcc.springmongodb.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Document(collection = "cars")
@PropertySource({"application.properties"})
public class Car {
  @Id
  private String id;

  @NotEmpty(message = "Please enter car make.")
  @Size(min = 2, max = 20, message="Make length should be greater than 1")
  private String make;

  @NotEmpty(message = "Please enter car model.")
  private String model;

  @NotEmpty(message = "Please enter description.")
  private String description;

  @NotNull(message="Please enter year")
  private Integer year;

  public Car() {}


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Car{" +
            "id='" + id + '\'' +
            ", make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", description='" + description + '\'' +
            ", year=" + year +
            '}';
  }
}