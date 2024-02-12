package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.dto.VehicleDTO;
import com.jrstudio.mecwor.entities.Customer;
import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.entities.Vehicle;
import com.jrstudio.mecwor.services.CustomerService;
import com.jrstudio.mecwor.services.ProductService;
import com.jrstudio.mecwor.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Vehicle>> list() {
        List<Vehicle> list = vehicleService.vehicleList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable("id") long id) {
        if(!vehicleService.existsById(id))
            return new ResponseEntity(new Message("Vehicle NO exists"), HttpStatus.NOT_FOUND);
        Vehicle vehicle = vehicleService.getOne(id).get();
        return new ResponseEntity(vehicle, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehicleDTO vehicleDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {
        if (vehicleDTO.getIdentificationVehicle() == null)
            return new ResponseEntity(new Message("Identification Vehicle is mandatory"), HttpStatus.BAD_REQUEST);
        if (vehicleDTO.getBrand() == null)
            return new ResponseEntity(new Message("Brand is mandatory"), HttpStatus.BAD_REQUEST);
        if (vehicleDTO.getModel() == null)
            return new ResponseEntity(new Message("Model is mandatory"), HttpStatus.BAD_REQUEST);
        if (vehicleDTO.getColor() == null)
            return new ResponseEntity(new Message("Color is mandatory"), HttpStatus.BAD_REQUEST);

        if (vehicleService.existsByIdentificationVehicle(vehicleDTO.getIdentificationVehicle()))
            return new ResponseEntity(new Message("Vehicle already registered"), HttpStatus.BAD_REQUEST);

        // Crear un nuevo vehículo desde el DTO
        Vehicle vehicle = new Vehicle(vehicleDTO.getIdentificationVehicle(), vehicleDTO.getBrand(), vehicleDTO.getModel(), vehicleDTO.getColor());

        // Obtener el cliente correspondiente desde la base de datos (puedes usar el ID del cliente desde el DTO)
        Optional<Customer> optionalCustomer = customerService.getOne(vehicleDTO.getCustomer().getIdCustomer());

        if (optionalCustomer.isEmpty()) {
            return new ResponseEntity(new Message("Customer not found"), HttpStatus.NOT_FOUND);
        }

        // Establecer la relación con el cliente
        Customer customer = optionalCustomer.get();
        vehicle.setCustomer(customer);

        // Guardar el vehículo
        vehicleService.save(vehicle);
        return new ResponseEntity(new Message("Vehicle registered"), HttpStatus.OK);
    }

    @Transactional
    @PatchMapping("/add-product/{idVehicle}/{idProduct}")
    public ResponseEntity<?> addProductToVehicle(@PathVariable("idVehicle") long idVehicle, @PathVariable("idProduct") long idProduct) {
        Optional<Vehicle> optionalVehicle = vehicleService.getOne(idVehicle);
        if (optionalVehicle.isEmpty()) {
            return new ResponseEntity<>(new Message("Vehicle not found"), HttpStatus.NOT_FOUND);
        }

        Vehicle vehicle = optionalVehicle.get();

        // Inicializar la lista de productos si es nula
        if (vehicle.getProducts() == null) {
            vehicle.setProducts(new ArrayList<>());
        }

        Optional<Product> optionalProduct = productService.getOneById(idProduct);
        if (optionalProduct.isEmpty()) {
            return new ResponseEntity<>(new Message("Product not found"), HttpStatus.NOT_FOUND);
        }

        Product product = optionalProduct.get();

        vehicle.addProduct(product);
        vehicleService.save(vehicle);

        return new ResponseEntity<>(new Message("Product added to vehicle"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!vehicleService.existsById(id))
            return new ResponseEntity(new Message("Vehicle NO exists"), HttpStatus.NOT_FOUND);
        vehicleService.delete(id);
        return new ResponseEntity(new Message("Vehicle deleted"), HttpStatus.OK);
    }
}
