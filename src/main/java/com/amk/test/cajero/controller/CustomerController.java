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

import com.amk.test.cajero.entity.Customer;
import com.amk.test.cajero.repository.CustomerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Customer Controller")
@Component
@Path("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customers; 
	
	@ApiOperation(value="getAll", nickname="getAll", produces="MediaType.APPLICATION_JSON")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAll(){
		return customers.findAll();
	}
	
	@ApiOperation(value="create", nickname="create", produces="MediaType.APPLICATION_JSON")
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Customer create(@RequestBody Customer customer){
		return customers.insert(customer);
	}
	
	@ApiOperation(value="delete", nickname="delete", produces="MediaType.APPLICATION_JSON")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody void delete(@RequestBody Customer customer){
		customers.delete(customer.id);
	}
	
	@ApiOperation(value="update", nickname="update", produces="MediaType.APPLICATION_JSON")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Customer update(@RequestBody Customer customer){
		return customers.save(customer);
	}
}
