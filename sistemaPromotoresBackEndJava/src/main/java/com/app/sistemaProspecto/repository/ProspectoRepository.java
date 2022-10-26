package com.app.sistemaProspecto.repository;

import com.app.sistemaProspecto.entity.Prospecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("clienteRepository")
public interface ProspectoRepository extends JpaRepository<Prospecto, Serializable> {

    public List<Prospecto> findByNombreProspecto(String nombreProspecto);

}
