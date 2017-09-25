package com.amk.test.cajero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amk.test.cajero.entity.Customer;
import com.amk.test.cajero.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customers; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> getAll(){
		return customers.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Customer create(@RequestBody Customer customer){
		return customers.insert(customer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public @ResponseBody void delete(@PathVariable String id){
		customers.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Customer update(@RequestBody Customer customer){
		return customers.save(customer);
	}
}
