package com.amk.test.cajero.entity;

import org.springframework.data.annotation.Id;

public class Account {

  @Id
  public String id;
  public String customerId;
  public float balance;
  public String accountType;

  public Account() {}

  public Account(String customerId, float balance, String accountType) {
    super();
    this.customerId = customerId;
    this.balance = balance;
    this.accountType = accountType;
  }

  public String toString() {
    return String.format("Account=[id='%s', customerId='%s', balance='%s', accountType='%s']",
        this.id, this.customerId, this.balance, this.accountType);
  }
}
