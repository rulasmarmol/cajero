package com.amk.test.cajero.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amk.test.cajero.entity.Account;

public interface AccountRepository extends MongoRepository<Account, String>{
  	public Account findByCustomerId(String customerId);
	public List<Account> findByAccountType(String accountType);
}
