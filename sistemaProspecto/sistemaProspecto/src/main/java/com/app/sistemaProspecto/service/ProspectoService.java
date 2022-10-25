package com.app.sistemaProspecto.service;

import com.app.sistemaProspecto.entity.Prospecto;

import java.util.List;

public interface ProspectoService  {
    public List<Prospecto> getAllprospecto();
    public Prospecto saveProspecto(Prospecto cliente);
    public Prospecto getProspecto(Integer id);
}
