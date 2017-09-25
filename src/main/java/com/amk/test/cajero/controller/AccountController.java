package com.amk.test.cajero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amk.test.cajero.entity.Account;
import com.amk.test.cajero.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accounts; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Account> getAll(){
		return accounts.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Account create(@RequestBody Account account){
		return accounts.insert(account);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public @ResponseBody void delete(@PathVariable String id){
	  accounts.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Account update(@RequestBody Account account){
		return accounts.save(account);
	}
}
