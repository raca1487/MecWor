package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.ElectronicDTO;
import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.entities.Electronic;
import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.services.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/electronics")
@CrossOrigin(origins = "*")
public class ElectronicController {

    @Autowired
    ElectronicService electronicService;

    @GetMapping("/list")
    public ResponseEntity<List<Electronic>> listElectronic() {
        List<Electronic> list = electronicService.electronicList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        if(!electronicService.existsById(id))
            return new ResponseEntity(new Message("Electronic NO exists"), HttpStatus.NOT_FOUND);
        Product electronic = electronicService.getOneById(id).get();
        return new ResponseEntity(electronic, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ElectronicDTO electronicDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {
        if (electronicDTO.getPowerSupply() == null)
            return new ResponseEntity(new Message("Power Supply is mandatory"), HttpStatus.BAD_REQUEST);

        Electronic electronic = new Electronic(electronicDTO.getNameProduct(), electronicDTO.getBrand(), electronicDTO.getRemarks(), electronicDTO.getPrice(), electronicDTO.getQuantity(), electronicDTO.getPowerSupply());

        // Get the user from the UserDetails object
        //Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        //booking.setUsuario(usuario);

        electronicService.save(electronic);
        return new ResponseEntity(new Message("Electronic created"), HttpStatus.OK);
    }

}
