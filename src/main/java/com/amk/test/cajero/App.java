package com.amk.test.cajero;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amk.test.cajero.entity.Account;
import com.amk.test.cajero.entity.Customer;
import com.amk.test.cajero.entity.Transaction;
import com.amk.test.cajero.repository.AccountRepository;
import com.amk.test.cajero.repository.CustomerRepository;
import com.amk.test.cajero.repository.TransactionRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner 
{
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private AccountRepository accountRepository;
  
  @Autowired
  private TransactionRepository transactionRepository;
  
  @RequestMapping("/")
  @ResponseBody
  String home() {
      return "cajero: Hello World!";
  }

  public static void main(String[] args) throws Exception {
      SpringApplication.run(App.class, args);
  }
  
  public void run(String... args)throws Exception{
    accountRepository.deleteAll();
    customerRepository.deleteAll();
    transactionRepository.deleteAll();
    
    //save customers
    customerRepository.save(new Customer("Juan","Martinez"));
    customerRepository.save(new Customer("John","Due","john.due@mymail.com",new Date(), "H", "+527223339673"));
    
    //save accounts
    accountRepository.save(new Account(customerRepository.findByFirstName("Juan").id, 0.0f, "TDC"));
    accountRepository.save(new Account(customerRepository.findByFirstName("John").id, 0.0f, "TDD"));
    
    //save transactions
    transactionRepository.save(new Transaction(accountRepository.findByCustomerId(customerRepository.findByFirstName("Juan").id).id, 0.0f, new Date()));
    transactionRepository.save(new Transaction(accountRepository.findByCustomerId(customerRepository.findByFirstName("Juan").id).id, 50.0f, new Date()));
    transactionRepository.save(new Transaction(accountRepository.findByCustomerId(customerRepository.findByFirstName("John").id).id, 0.0f, new Date()));
    
    //fetch all customers
    System.out.println("Customers found with findAll():");
    System.out.println("-------------------------------");
    for(Customer customer: customerRepository.findAll()){
        System.out.println(customer);
    }
    System.out.println();
    
    //fetch all accounts
    System.out.println("Accounts found with findAll():");
    System.out.println("-------------------------------");
    for(Account account: accountRepository.findAll()){
        System.out.println(account);
    }
    System.out.println();    
    
    //fetch all transactions
    System.out.println("Transactions found with findAll():");
    System.out.println("-------------------------------");
    for(Transaction transaction: transactionRepository.findAll()){
        System.out.println(transaction);
    }
    System.out.println();   
    
    //fetch an individual customer
    System.out.println("-------------------------------------------");
    System.out.println("Customer found with findByFirstName('Juan')");
    System.out.println(customerRepository.findByFirstName("Juan"));
    
    System.out.println("-------------------------------------------");
    System.out.println("Customers found with findByLastName('Due')");
    for(Customer customer: customerRepository.findByLastName("Due")){
        System.out.println(customer);
    }
    
    //fetch an individual account
    System.out.println("-------------------------------------------");
    System.out.println("Account found of customer ('Juan')");
    System.out.println(accountRepository.findByCustomerId(customerRepository.findByFirstName("Juan").id));
    
    System.out.println("-------------------------------------------");
    System.out.println("Accounts found with findByAccountType('TDD')");
    for(Account account: accountRepository.findByAccountType("TDD")){
        System.out.println(account);
    }
    
    //fetch transactions
    System.out.println("-------------------------------------------");
    System.out.println("Transaction found of customer's account ('Juan')");
    for(Transaction transaction: transactionRepository.findByAccountId(accountRepository.findByCustomerId(customerRepository.findByFirstName("Juan").id).id)){
      System.out.println(transaction);
  }
    
    System.out.println("-------------------------------------------");
    System.out.println("Transactions found with findByTotal('0.0f')");
    for(Transaction transaction: transactionRepository.findByTotal(0.0f)){
        System.out.println(transaction);
    }
}    
}
