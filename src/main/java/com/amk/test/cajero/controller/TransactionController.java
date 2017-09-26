package com.amk.test.cajero.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import com.amk.test.cajero.entity.Transaction;
import com.amk.test.cajero.exception.AppException;
import com.amk.test.cajero.repository.TransactionRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Transaction Controller")
@Component
@Path("/transactions")
public class TransactionController {

  @Autowired
  private TransactionRepository transactions;
  
  @ExceptionHandler
  void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
      response.sendError(HttpStatus.BAD_REQUEST.value(), "Insufficient Balance");
  }

  @ApiOperation(value="getAll", nickname="getAll", produces="MediaType.APPLICATION_JSON")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Transaction> getAll() {
    return transactions.findAll();
  }

  @ApiOperation(value="create", nickname="create", produces="MediaType.APPLICATION_JSON")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
	public Transaction create(@RequestBody Transaction transaction) throws AppException{
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
          throw new AppException(400,400,"There are no enought balance for the transaction: " + balance, "Bussines Rule", "micajero.com/help/errors/400"); 
        }
      }
  }
}
