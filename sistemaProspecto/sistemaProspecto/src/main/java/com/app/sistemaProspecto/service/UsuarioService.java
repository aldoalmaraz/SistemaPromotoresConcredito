package com.app.sistemaProspecto.service;

import com.app.sistemaProspecto.entity.Rol;
import com.app.sistemaProspecto.entity.Usuario;
import com.app.sistemaProspecto.repository.RolRepository;
import com.app.sistemaProspecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(path = "/buscar")
    public List<Usuario> getAllRol(){
        return usuarioRepository.findAll();

    }

    @PostMapping(path = "/guardar")
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(path = "/eliminar/{idusuario}")
    public void deleteRol(@PathVariable("idusuario") Integer idusuario){
        Optional<Usuario> usuario;
        usuario=usuarioRepository.findById(idusuario);
        if(usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
        }
}

@PostMapping(path = "/login")
        public Usuario login(@RequestBody Usuario usuario){

            List<Usuario> usuarios=usuarioRepository.findByNombreAndPass(usuario.getNombre(),usuario.getPass());
            if (!usuarios.isEmpty()){
                return usuarios.get(0);
            }
            return null;

    }
}


