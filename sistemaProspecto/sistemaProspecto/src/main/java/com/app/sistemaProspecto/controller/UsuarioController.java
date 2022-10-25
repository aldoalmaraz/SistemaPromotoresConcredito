package com.app.sistemaProspecto.controller;

import com.app.sistemaProspecto.entity.Usuario;
import com.app.sistemaProspecto.repository.UsuarioRepository;
import com.app.sistemaProspecto.service.ProspectoService;
import com.app.sistemaProspecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    @Qualifier("servicioUsuario")
    private UsuarioService usuarioService;

    @GetMapping(path = "/buscar")
    public List<Usuario> getAllRol(){
        return usuarioService.getAllusuario();

    }

    @PostMapping(path = "/guardar")
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }


@PostMapping(path = "/login")
        public Usuario login(@RequestBody Usuario usuario){
           return usuarioService.getLogin(usuario);

    }
}


