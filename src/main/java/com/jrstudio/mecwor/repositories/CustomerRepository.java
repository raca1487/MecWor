package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsById(Long id);
    Optional<Customer> findByPhone(String phone);
    boolean existsByPhone(String phone);

}
