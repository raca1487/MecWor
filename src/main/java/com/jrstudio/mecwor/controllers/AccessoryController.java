package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.AccessoryDTO;
import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.entities.Accessory;
import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.services.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/accessories")
@CrossOrigin(origins = "*")
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Accessory>> listAccessories() {
        List<Accessory> list = accessoryService.accessoryList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        if(!accessoryService.existsById(id))
            return new ResponseEntity(new Message("Accessory NO exists"), HttpStatus.NOT_FOUND);
        Product accessory = accessoryService.getOneById(id).get();
        return new ResponseEntity(accessory, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AccessoryDTO accessoryDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {

        Accessory accessory = new Accessory(accessoryDTO.getNameProduct(), accessoryDTO.getBrand(), accessoryDTO.getRemarks(), accessoryDTO.getPrice(), accessoryDTO.getQuantity(), accessoryDTO.getCompatibilty(), accessoryDTO.getSize(), accessoryDTO.getVoltage());

        // Get the user from the UserDetails object
        //Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        //booking.setUsuario(usuario);

        accessoryService.save(accessory);
        return new ResponseEntity(new Message("Accessory created"), HttpStatus.OK);
    }
}
