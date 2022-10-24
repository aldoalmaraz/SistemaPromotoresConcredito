package com.app.sistemaProspecto.repository;

import com.app.sistemaProspecto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

    public List<Cliente> findByNombreProspecto(String nombreProspecto);

}
