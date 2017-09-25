package com.amk.test.cajero.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Customer {

  @Id
  public String id;
  public String firstName;
  public String lastName;
  public String email;
  public Date birthdate;
  public String gender;
  public String telephoneNumber;

  public Customer() {}

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }


  public Customer(String firstName, String lastName, String email, Date birthdate, String gender,
      String telephoneNumber) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.birthdate = birthdate;
    this.gender = gender;
    this.telephoneNumber = telephoneNumber;
  }

  public String toString() {
    return String.format("Customer=[id='%s', firstName='%s', lastName='%s', email='%s', birthdate='%s', gender='%s', telephoneNumber='%s']", this.id,
        this.firstName, this.lastName, this.email, this.birthdate, this.gender, this.telephoneNumber);
  }
}
