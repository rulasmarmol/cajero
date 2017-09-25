package com.amk.test.cajero.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amk.test.cajero.entity.Account;
import com.amk.test.cajero.repository.AccountRepository;

@Component
@Path("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accounts; 
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAll(){
		return accounts.findAll();
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Account create(@RequestBody Account account){
		return accounts.insert(account);
	}
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody void delete(@RequestBody Account account){
	  accounts.delete(account.id);
	}
	
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Account update(@RequestBody Account account){
		return accounts.save(account);
	}
}
