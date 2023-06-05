package com.clarit.hs.service.items;


import org.springframework.data.annotation.AccessType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;
import java.util.List;


@Document("customers")
public class Customer extends RepresentationModel<Customer> implements Serializable{


	private String id;
	private String name;
	private String email;
	private String phone;
	private String address;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@AccessType(AccessType.Type.PROPERTY)
	public void setLinks(List<Link> links) {
		super.removeLinks();
		super.add(links);
	}
}
