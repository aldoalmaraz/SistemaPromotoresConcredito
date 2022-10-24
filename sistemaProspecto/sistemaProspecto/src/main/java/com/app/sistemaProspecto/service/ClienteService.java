package com.app.sistemaProspecto.service;

import com.app.sistemaProspecto.entity.Cliente;
import com.app.sistemaProspecto.entity.Rol;
import com.app.sistemaProspecto.repository.ClienteRepository;
import com.app.sistemaProspecto.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(path = "/buscar")
    public List<Cliente> getAllRol(){
        return clienteRepository.findAll();
    }


    @PostMapping(path = "/guardar")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        System.out.println("esto es una prueba: "+ cliente);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping(path = "/eliminar/{idcliente}")
    public void deleteCliente(@PathVariable("idcliente") Integer idcliente){
        Optional<Cliente> rol;
        rol=clienteRepository.findById(idcliente);
        if(rol.isPresent()){
            clienteRepository.delete(rol.get());
        }
    }
/*
    @GetMapping(path = "/buscar/{idcliente}")
    public List<Cliente> getRol(@PathVariable("idcliente") String nombreProspecto){
        return clienteRepository.findByNombreProspecto(nombreProspecto);
    }
*/

    @GetMapping(path = "/buscar/{idcliente}")
    public Cliente getRol(@PathVariable("idcliente") Integer id){
        return  clienteRepository.findById(id).get();
    }

}
