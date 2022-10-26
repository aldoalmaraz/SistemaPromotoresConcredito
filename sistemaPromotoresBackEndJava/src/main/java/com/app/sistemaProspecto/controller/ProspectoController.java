package com.app.sistemaProspecto.controller;

import com.app.sistemaProspecto.entity.Prospecto;
import com.app.sistemaProspecto.repository.ProspectoRepository;
import com.app.sistemaProspecto.service.ProspectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ProspectoController {

    @Autowired
    @Qualifier("servicioProspecto")
    private ProspectoService prospectoService;

    @GetMapping(path = "/buscar")
    public List<Prospecto> getAllRol(){
        return prospectoService.getAllprospecto();
    }


    @PostMapping(path = "/guardar")
    public Prospecto saveCliente(@RequestBody Prospecto prospecto){
        return prospectoService.saveProspecto(prospecto);
    }


    @GetMapping(path = "/buscar/{idcliente}")
    public Prospecto getRol(@PathVariable("idcliente") Integer id){
        return  prospectoService.getProspecto(id);
    }

}
