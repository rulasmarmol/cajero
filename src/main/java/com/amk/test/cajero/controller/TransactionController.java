package com.amk.test.cajero.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amk.test.cajero.entity.Transaction;
import com.amk.test.cajero.repository.TransactionRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  @Autowired
  private TransactionRepository transactions;
  
  @ExceptionHandler
  void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
      response.sendError(HttpStatus.BAD_REQUEST.value(), "Insufficient Balance");
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Transaction> getAll() {
    return transactions.findAll();
  }

  @RequestMapping(method=RequestMethod.POST)
	public Transaction create(@RequestBody Transaction transaction){
      if(transaction.total>=0){
        return transactions.insert(transaction);
      }else{
        float balance = 0.0f;
        for(Transaction nTransaction: transactions.findByAccountId(transaction.accountId)){
          balance = balance + nTransaction.total;
        }
        if((balance + transaction.total)>=0){
          return transactions.insert(transaction);
        }else{
          throw new IllegalArgumentException("There are no enought balance for the transaction: " + balance); 
        }
      }
  }
}
