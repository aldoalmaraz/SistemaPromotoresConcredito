package com.app.sistemaProspecto.controller;

import com.app.sistemaProspecto.entity.Rol;
import com.app.sistemaProspecto.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rol")
@CrossOrigin

public class RolController {
    @Autowired
    private RolRepository rolRepository;

    @GetMapping(path = "/buscar")
    public List<Rol> getAllRol(){
return rolRepository.findAll();

    }

    @PostMapping(path = "/guardar")
    public Rol saveRol(@RequestBody Rol rol){
return rolRepository.save(rol);
    }

    @DeleteMapping(path = "/eliminar/{idrol}")
    public void deleteRol(@PathVariable("idrol") Integer idrol){
        Optional<Rol> rol;
        rol=rolRepository.findById(idrol);
        if(rol.isPresent()){
            rolRepository.delete(rol.get());
        }

    }

}
