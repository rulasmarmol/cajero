package com.amk.test.cajero.controllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amk.test.cajero.entity.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AccountControllerTest {

  private TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void accountsGetTest() {
    ResponseEntity<String> entity =
        this.restTemplate.getForEntity("http://localhost:8080/accounts", String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  @Test
  public void accountsPostTest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Account> entity =
        new HttpEntity<Account>(new Account("customerId", 0.0f, "TDD"), headers);

    ResponseEntity<Account> entityResponse =
        this.restTemplate.postForEntity("http://localhost:8080/accounts", entity, Account.class);
    System.out.println("Entity Body: " + entityResponse);
    assertEquals(HttpStatus.OK, entityResponse.getStatusCode());
  }
}
