package com.amk.test.cajero.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Transaction {

  @Id
  public String id;
  public String accountId;
  public float total;
  public Date date;

  public Transaction() {}

  public Transaction(String accountId, float total, Date date) {
    super();
    this.accountId = accountId;
    this.total = total;
    this.date = date;
  }

  public String toString() {
    return String.format("Transaction=[id='%s', accountId='%s', total='%s', date='%s']",
        this.id, this.accountId, this.total, this.date);
  }
}
