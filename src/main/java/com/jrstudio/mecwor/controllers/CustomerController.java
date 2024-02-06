package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.entities.Customer;
import com.jrstudio.mecwor.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> list() {
        List<Customer> list = customerService.customerList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") long id) {
        if(!customerService.existsById(id))
            return new ResponseEntity(new Message("Customer NO exists"), HttpStatus.NOT_FOUND);
        Customer customer = customerService.getOne(id).get();
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody com.jrstudio.mecwor.dto.CustomerDTO customerDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {
        if (customerDTO.getName() == null)
            return new ResponseEntity(new Message("Name is mandatory"), HttpStatus.BAD_REQUEST);
        if (customerDTO.getSurname1() == null)
            return new ResponseEntity(new Message("Surname is mandatory"), HttpStatus.BAD_REQUEST);
        if (customerDTO.getPhone() == null)
            return new ResponseEntity(new Message("Phone is mandatory"), HttpStatus.BAD_REQUEST);
        if (customerDTO.getMail() == null)
            return new ResponseEntity(new Message("Email is mandatory"), HttpStatus.BAD_REQUEST);

        if (customerService.existsByPhone(customerDTO.getPhone()))
            return new ResponseEntity(new Message("Phone already registered"), HttpStatus.BAD_REQUEST);

        Customer customer = new Customer(customerDTO.getName(), customerDTO.getSurname1(), customerDTO.getSurname2(), customerDTO.getPhone(), customerDTO.getMail());

        // Get the user from the UserDetails object
        //Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        //booking.setUsuario(usuario);

        customerService.save(customer);
        return new ResponseEntity(new Message("Customer created"), HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO){
        if(StringUtils.isBlank(bookingDTO.getDate()))
            return new ResponseEntity(new Message("Reservation date is mandatory"), HttpStatus.BAD_REQUEST);

        if(bookingService.existsByDate(bookingDTO.getDate()))
            return new ResponseEntity(new Message("Date is booked"), HttpStatus.BAD_REQUEST);
        Booking booking = new Booking(bookingDTO.getDate());
        bookingService.save(booking);
        return new ResponseEntity(new Message("Booking created"), HttpStatus.OK);
    }*/


    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!customerService.existsById(id))
            return new ResponseEntity(new Message("Customer NO exists"), HttpStatus.NOT_FOUND);
        customerService.delete(id);
        return new ResponseEntity(new Message("Customer deleted"), HttpStatus.OK);
    }

}
