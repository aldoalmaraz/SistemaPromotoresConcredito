package com.app.sistemaProspecto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "rol")

public class Rol implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="idrol")
    private Integer idrol;

    @Column(name="nombre")
    private String nombre;



}
