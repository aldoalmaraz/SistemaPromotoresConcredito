package com.app.sistemaProspecto.service;

import com.app.sistemaProspecto.entity.Prospecto;
import com.app.sistemaProspecto.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> getAllusuario();
    public Usuario saveUsuario(Usuario usuario);
    public Usuario getLogin(Usuario usuario);
}
