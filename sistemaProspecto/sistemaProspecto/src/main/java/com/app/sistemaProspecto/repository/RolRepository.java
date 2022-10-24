package com.app.sistemaProspecto.repository;

import com.app.sistemaProspecto.entity.Rol;
import com.app.sistemaProspecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable> {
    

}
