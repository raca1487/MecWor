package com.jrstudio.mecwor.controllers;

import com.jrstudio.mecwor.dto.FluidDTO;
import com.jrstudio.mecwor.dto.Message;
import com.jrstudio.mecwor.entities.Fluid;
import com.jrstudio.mecwor.entities.Product;
import com.jrstudio.mecwor.services.FluidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/fluids")
@CrossOrigin(origins = "*")
public class FluidController {

    @Autowired
    FluidService fluidService;

    @GetMapping("/list")
    public ResponseEntity<List<Fluid>> listFluids() {
        List<Fluid> list = fluidService.fluidList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        if(!fluidService.existsById(id))
            return new ResponseEntity(new Message("Fluid NO exists"), HttpStatus.NOT_FOUND);
        Product fluid = fluidService.getOneById(id).get();
        return new ResponseEntity(fluid, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody FluidDTO fluidDTO/*, @AuthenticationPrincipal UserDetails userDetails*/) {
        if (fluidDTO.getViscosity() == null)
            return new ResponseEntity(new Message("Viscosity is mandatory"), HttpStatus.BAD_REQUEST);
        if (fluidDTO.getQuantityFluid() == null)
            return new ResponseEntity(new Message("Fluid Quantity is mandatory"), HttpStatus.BAD_REQUEST);

        Fluid fluid = new Fluid(fluidDTO.getNameProduct(), fluidDTO.getBrand(), fluidDTO.getRemarks(), fluidDTO.getPrice(), fluidDTO.getQuantity(), fluidDTO.getViscosity(), fluidDTO.getQuantityFluid());

        // Get the user from the UserDetails object
        //Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        //booking.setUsuario(usuario);

        fluidService.save(fluid);
        return new ResponseEntity(new Message("Fluid created"), HttpStatus.OK);
    }

}
