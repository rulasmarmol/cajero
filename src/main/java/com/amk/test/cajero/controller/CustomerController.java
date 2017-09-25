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

@Component
@Path("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customers; 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAll(){
		return customers.findAll();
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Customer create(@RequestBody Customer customer){
		return customers.insert(customer);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody void delete(@RequestBody Customer customer){
		customers.delete(customer.id);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Customer update(@RequestBody Customer customer){
		return customers.save(customer);
	}
}
