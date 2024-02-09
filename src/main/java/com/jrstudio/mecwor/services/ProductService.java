package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.entities.Tyre;
import com.jrstudio.mecwor.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> productList() {
        return productRepository.findAll();
    }
    public Optional<Product> getOneById(Long id) {
        return productRepository.findById(id);
    }
    public Optional<Tyre> getOneByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }
    public Optional<Product> getOneByPrice(float price) {
        return productRepository.findByPrice(price);
    }
    public Optional<Product> getByName(String nameProduct) {
        return productRepository.findByNameProduct(nameProduct);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
    public void delete(long id) {
        productRepository.deleteById(id);
    }
    public boolean existsById(long id) {
        return productRepository.existsById(id);
    }
    public boolean existsByBrand(String brand) { return productRepository.existsByBrand(brand); }
    public boolean existsByPrice(float price) { return productRepository.existsByPrice(price); }
    public boolean existsByName(String nameProduct) {
        return productRepository.existsByNameProduct(nameProduct);
    }
}
