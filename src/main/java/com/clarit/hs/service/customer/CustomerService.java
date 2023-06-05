package com.clarit.hs.service.customer;

import com.clarit.hs.controller.ICustomerService;
import com.clarit.hs.service.apiresponse.APIResponse;
import com.clarit.hs.service.items.Customer;
import com.clarit.hs.service.items.IPropertyCus;

import com.clarit.hs.service.items.repo.ItemRepositoryCus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	IPropertyCus iPropertyCus;

	@Autowired
	private ItemRepositoryCus itemRepositoryCus;

	@Override
	public CollectionModel<Customer> getAll(String id) {

		List<Customer> customers = iPropertyCus.getAll(id);
		for (Customer customer : customers ){
			Link selfLink = WebMvcLinkBuilder.linkTo(ICustomerService.class).slash(customer.getId()).withSelfRel();
			customer.add(selfLink);
		}
		Link link = WebMvcLinkBuilder.linkTo(ICustomerService.class).withSelfRel();
		CollectionModel<Customer> result = CollectionModel.of(customers,link);
		return result;
	}
	@Override
	public CollectionModel<Customer> get(String name) {

		List<Customer> customers = iPropertyCus.get(name);

		for(Customer customer : customers) {
			Link selfLink = WebMvcLinkBuilder.linkTo(ICustomerService.class).slash(customer.getName()).withSelfRel();
			customer.add(selfLink);
		}
		Link link = WebMvcLinkBuilder.linkTo(ICustomerService.class).withSelfRel();
		CollectionModel<Customer> result = CollectionModel.of(customers, link);

		return result;
	}

	@Override
	public void delete(String name) {

		iPropertyCus.delete(name);
	}

	@Override
	public Customer update(Customer customer) {

		Customer customer1 = iPropertyCus.update(customer);
		Link link = WebMvcLinkBuilder.linkTo(ICustomerService.class).slash(customer1).withSelfRel();
		customer1.add(link);

		return null;
	}

	@Override
	public Customer add(Customer customer)  {

		Customer customer1 =iPropertyCus.add(customer);

			Link link = WebMvcLinkBuilder.linkTo(ICustomerService.class).slash(customer1).withSelfRel();
			customer1.add(link);
			return customer1;

	}



/*
	@Override
	public APIResponse <List<Customer>> getCustomers() {
		List<Customer> allCustomers = iPropertyCus.findAllCustomers();
		return (APIResponse<List<Customer>>) allCustomers;
	}

 */
/*
	@PostConstruct
	public void initDB(){
		List<Customer> customers = IntStream.rangeClosed(1,200)
				.mapToObj(i -> new Customer("customer" + i,new Random().nextInt(100), new Random().nextInt(50000)))
				.collect(Collectors.toList());
		itemRepositoryCus.saveAll(customers);
	}

 */


/*
	@Override
	public Customer patch(JsonPatch jsonPatch, String name) throws JsonPatchException, JsonProcessingException {

		//	Customer customer = itemRepositoryCus.findByCustomer(name);
		//	JsonNode patched = jsonPatch.apply(objectMapper.convertValue(customer, JsonNode.class));
		//	return itemRepositoryCus.save(objectMapper.treeToValue(patched, Customer.class));
		return iPropertyCus.patch(jsonPatch,name);
	}




	@Autowired
	ObjectMapper objectMapper;

	public Customer applyToPatch(JsonPatch jsonPatch,String name) throws JsonPatchException, JsonProcessingException {
		List<Customer> customer = itemRepositoryCus.findByName(name);
		JsonNode patched = jsonPatch.apply(objectMapper.convertValue(customer, JsonNode.class));
		return itemRepositoryCus.save(objectMapper.treeToValue(patched, Customer.class));

	}

 */

}
