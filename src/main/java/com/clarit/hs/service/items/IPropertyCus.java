package com.clarit.hs.service.items;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.util.List;

public interface IPropertyCus {

    public List<Customer> getAll(String id);

    public List<Customer> get(String customerName);

    public Customer add(Customer customer) ;

    public String delete(String name);

    public Customer update(Customer customer);


    //public List<Customer> findAllCustomers();


}

