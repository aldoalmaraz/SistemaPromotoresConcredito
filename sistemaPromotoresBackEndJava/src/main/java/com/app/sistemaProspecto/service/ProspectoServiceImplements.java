package com.app.sistemaProspecto.service;

import com.app.sistemaProspecto.entity.Prospecto;
import com.app.sistemaProspecto.repository.ProspectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("servicioProspecto")
public class ProspectoServiceImplements implements ProspectoService{
    @Autowired
    private ProspectoRepository prospectoRepository;

    @Override
    public List<Prospecto> getAllprospecto() {
        return prospectoRepository.findAll();
    }

    @Override
    public Prospecto saveProspecto(Prospecto cliente) {
        return prospectoRepository.save(cliente);
    }

    @Override
    public Prospecto getProspecto(Integer id) {
        return  prospectoRepository.findById(id).get();
    }
}
