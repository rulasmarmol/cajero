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

import com.amk.test.cajero.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerControllerTest {

  private TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void customersGetTest() {
    ResponseEntity<String> entity =
        this.restTemplate.getForEntity("http://localhost:8080/customers", String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  @Test
  public void customersPostTest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Customer> entity =
        new HttpEntity<Customer>(new Customer("Carlos", "Marmolejo"), headers);

    ResponseEntity<Customer> entityResponse =
        this.restTemplate.postForEntity("http://localhost:8080/customers", entity, Customer.class);
    assertEquals(HttpStatus.OK, entityResponse.getStatusCode());
  }
}
