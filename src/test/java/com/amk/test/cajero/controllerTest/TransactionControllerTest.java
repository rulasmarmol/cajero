package com.amk.test.cajero.controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

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

import com.amk.test.cajero.entity.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TransactionControllerTest {

  private TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void transactionsGetTest() {
    ResponseEntity<String> entity =
        this.restTemplate.getForEntity("http://localhost:8080/transactions", String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  @Test
  public void transactionsPostTest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Transaction> entity =
        new HttpEntity<Transaction>(new Transaction("accountId", 0.0f, new Date()), headers);

    ResponseEntity<Transaction> entityResponse =
        this.restTemplate.postForEntity("http://localhost:8080/transactions", entity, Transaction.class);
    assertEquals(HttpStatus.OK, entityResponse.getStatusCode());
  }
}
