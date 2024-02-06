package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Customer;
import com.jrstudio.mecwor.repositories.CustomerRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
    public Optional<Customer> getOne(long id) {
        return customerRepository.findById(id);
    }
    public Optional<Customer> getByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    public void save(Customer user) {
        customerRepository.save(user);
    }
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
    public boolean existsById(long id) {
        return customerRepository.existsById(id);
    }
    public boolean existsByPhone(String phone) {
        return customerRepository.existsByPhone(phone);
    }
}