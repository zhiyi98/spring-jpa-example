package com.example.zhiyi.web;

import com.example.zhiyi.dao.CustomerRepository;
import com.example.zhiyi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	CustomerRepository customerrepository;
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String HelloHome() {
		return "Hi, here is to test the oracle connection";
	}
	
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	public Iterable<Customer> HelloCustomer() {
	return customerrepository.findAll();
	}

}
