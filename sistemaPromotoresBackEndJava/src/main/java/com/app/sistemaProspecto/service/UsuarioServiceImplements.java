package com.app.sistemaProspecto.service;

import com.app.sistemaProspecto.entity.Prospecto;
import com.app.sistemaProspecto.entity.Usuario;
import com.app.sistemaProspecto.repository.ProspectoRepository;
import com.app.sistemaProspecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("servicioUsuario")
public class UsuarioServiceImplements implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllusuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getLogin(Usuario usuario) {
        List<Usuario> usuarios=usuarioRepository.findByNombreAndPass(usuario.getNombre(),usuario.getPass());
        if (!usuarios.isEmpty()){
            return usuarios.get(0);
        }
        return null;

    }
}
