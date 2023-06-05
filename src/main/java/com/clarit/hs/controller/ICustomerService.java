package com.clarit.hs.controller;

import com.clarit.hs.service.apiresponse.APIResponse;
import com.clarit.hs.service.items.Customer;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping(value = "/customers")
public interface ICustomerService {

	//Must implement pagination
	@GetMapping(produces = { "application/hal+json" })
	@RolesAllowed("admin")
	public CollectionModel<Customer> getAll( String id);

	@GetMapping(value="/{name}", produces = { "application/hal+json" })
	@RolesAllowed("customer")
	public CollectionModel<Customer> get(@PathVariable String name);


	@DeleteMapping(value="/{name}", produces = { "application/hal+json" })
	public void delete(@PathVariable String name);

	@PutMapping(value="/{name}", produces = { "application/hal+json" })
	public Customer update(@RequestBody Customer customer);

	@PostMapping(produces = { "application/hal+json" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer add(@RequestBody  Customer customer) ;
/*
	@GetMapping("/pagination")
	public APIResponse<List<Customer>> getCustomers();

 */




}
