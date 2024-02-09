package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.dto.ProductDTO;
import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list() {
        List<Product> list = productService.productList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        if(!productService.existsById(id))
            return new ResponseEntity(new Message("Product NO exists"), HttpStatus.NOT_FOUND);
        Product product = productService.getOneById(id).get();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {
        if (productDTO.getNameProduct() == null)
            return new ResponseEntity(new Message("Name is mandatory"), HttpStatus.BAD_REQUEST);
        if (productDTO.getBrand() == null)
            return new ResponseEntity(new Message("Brand is mandatory"), HttpStatus.BAD_REQUEST);
        if (productDTO.getPrice() <= 0)
            return new ResponseEntity(new Message("Price must be positive and cannot be zero"), HttpStatus.BAD_REQUEST);

        Product product = new Product(productDTO.getNameProduct(), productDTO.getBrand(), productDTO.getRemarks(), productDTO.getPrice(), productDTO.getQuantity());

        // Get the user from the UserDetails object
        //Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        //booking.setUsuario(usuario);

        productService.save(product);
        return new ResponseEntity(new Message("Product created"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!productService.existsById(id))
            return new ResponseEntity(new Message("Product NO exists"), HttpStatus.NOT_FOUND);
        productService.delete(id);
        return new ResponseEntity(new Message("Product deleted"), HttpStatus.OK);
    }

}
