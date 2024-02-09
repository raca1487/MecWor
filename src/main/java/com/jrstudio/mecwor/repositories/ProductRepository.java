package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.entities.Tyre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsById (Long id);
    boolean existsByNameProduct (String nameProduct);
    Optional<Product> findByNameProduct (String nameProduct);
    boolean existsByBrand (String brand);
    Optional<Tyre> findByBrand (String brand);
    boolean existsByPrice (double price);
    Optional<Product> findByPrice (double price);

}
