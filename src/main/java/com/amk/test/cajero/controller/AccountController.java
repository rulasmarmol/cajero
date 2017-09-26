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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Account Controller")
@Component
@Path("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accounts; 
	
    @ApiOperation(value="getAll", nickname="getAll", produces="MediaType.APPLICATION_JSON")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAll(){
		return accounts.findAll();
	}
	
    @ApiOperation(value="create", nickname="create", produces="MediaType.APPLICATION_JSON")
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Account create(@RequestBody Account account){
		return accounts.insert(account);
	}
	
    @ApiOperation(value="delete", nickname="delete", produces="MediaType.APPLICATION_JSON")
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody void delete(@RequestBody Account account){
	  accounts.delete(account.id);
	}
	
    @ApiOperation(value="update", nickname="update", produces="MediaType.APPLICATION_JSON")
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Account update(@RequestBody Account account){
		return accounts.save(account);
	}
}
