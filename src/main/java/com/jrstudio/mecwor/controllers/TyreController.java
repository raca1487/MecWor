package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.dto.TyreDTO;
import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.entities.Tyre;
import com.jrstudio.mecwor.services.TyreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/tyres")
@CrossOrigin(origins = "*")
public class TyreController {

    @Autowired
    TyreService tyreService;

    @GetMapping("/list")
    public ResponseEntity<List<Tyre>> listTyres() {
        List<Tyre> list = tyreService.tyreList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        if(!tyreService.existsById(id))
            return new ResponseEntity(new Message("Tyre NO exists"), HttpStatus.NOT_FOUND);
        Product tyre = tyreService.getOneById(id).get();
        return new ResponseEntity(tyre, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TyreDTO tyreDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {
        /*if (tyreDTO.get() <= 0)
            return new ResponseEntity(new Message("Size must be positive and cannot be zero"), HttpStatus.BAD_REQUEST);*/
        if (tyreDTO.getQuantity() == 4 | tyreDTO.getQuantity() == 2)
            return new ResponseEntity(new Message("Quantity must be two or four"), HttpStatus.BAD_REQUEST);

        Tyre tyre = new Tyre(tyreDTO.getNameProduct(), tyreDTO.getBrand(), tyreDTO.getRemarks(), tyreDTO.getPrice(), tyreDTO.getQuantity(), tyreDTO.getWidth(), tyreDTO.getSerie(), tyreDTO.getDiameter(), tyreDTO.getLoadIndex());

        // Get the user from the UserDetails object
        //Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        //booking.setUsuario(usuario);

        tyreService.save(tyre);
        return new ResponseEntity(new Message("Tyre created"), HttpStatus.OK);
    }

}
