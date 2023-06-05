package com.clarit.hs.service.items;

import com.clarit.hs.service.items.repo.ItemRepositoryCus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyCus implements IPropertyCus{

@Autowired
private RedisTemplate redisTemplate;

private static final String KEY = "CUSTOMER";
    @Autowired
    ItemRepositoryCus itemRepositoryCus;


    @Override
    public List<Customer> getAll(String id){
        return getAllCustomers();
    }

    @Override
    public Customer add(Customer customer) {
        return addCustomer(customer);
    }

    @Override
    public Customer update(Customer customer){

        return updateCustomer(customer);
    }



/*
    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customer = itemRepositoryCus.findAll();
        return customer;
    }

 */


    @Override
    public List<Customer> get(String customerName){
        Customer customer;
        customer = (Customer) redisTemplate.opsForHash().get(KEY,customerName);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
     //  List<Customer> customer = itemRepositoryCus.findByName(customerName);
        return customers;
    }

    @Override
    public String delete(String name){
        redisTemplate.opsForHash().delete(KEY,name);
        itemRepositoryCus.delete( itemRepositoryCus.deleteByName(name));
        return "Deleted Successfully ....";
    }

    private List<Customer> getAllCustomers(){
       // return redisTemplate.opsForHash().values(KEY);
        List<Customer> customers = redisTemplate.opsForHash().values(KEY);
        return customers;
    }

    private Customer addCustomer(Customer customer){

            redisTemplate.opsForHash().put(KEY,customer.getName().toString(),customer);

        return itemRepositoryCus.save(customer);
    }
    private Customer updateCustomer(Customer customer){
        redisTemplate.opsForHash().put(KEY,customer.getName().toString(),customer);
        return itemRepositoryCus.save(customer);
    }

/*
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Customer patch(JsonPatch jsonPatch, String name)  {

        Customer customer = itemRepositoryCus.findByCustomer(name);
        Customer customer1 = applyPatchToCustomer(jsonPatch, customer);
        return itemRepositoryCus.save(customer1);
    }


    @SneakyThrows
    private Customer applyPatchToCustomer(JsonPatch jsonPatch, Customer customer)  {

        JsonNode df = jsonPatch.apply(objectMapper.convertValue(customer, JsonNode.class));

        return objectMapper.treeToValue(df,Customer.class);
    }

 */


}







