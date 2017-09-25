package com.amk.test.cajero.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;


public class ErrorMessage {

  int status;

  int code;

  String message;

  String link;

  String developerMessage;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDeveloperMessage() {
    return developerMessage;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.developerMessage = developerMessage;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public ErrorMessage(AppException ex) {
    this.code = ex.code;
    this.developerMessage = ex.developerMessage;
    this.link = ex.link;
    this.message = ex.getMessage();
    this.status = ex.status;
    System.out.println(ex);
    System.out.println(this);
  }

  public ErrorMessage(NotFoundException ex) {
    this.status = Response.Status.NOT_FOUND.getStatusCode();
    this.message = ex.getMessage();
    this.link = "https://jersey.java.net/apidocs/2.8/jersey/javax/ws/rs/NotFoundException.html";
  }

  public ErrorMessage() {}
}
