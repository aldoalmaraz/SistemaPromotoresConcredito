package com.app.sistemaProspecto.repository;

import com.app.sistemaProspecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
public List<Usuario> findByNombreAndPass(String nombre,String pass);


}
