package com.amk.test.cajero.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amk.test.cajero.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{
  	public List<Transaction> findByAccountId(String accountId);
	public List<Transaction> findByTotal(float total);
}
