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
@Table(name = "cliente")
public class Prospecto implements Serializable {
    private static final long serialVersionUID=3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcliente")
    private Integer idcliente;

    @Column(name="nombreprospecto")
    private String nombreProspecto;

    @Column(name="primerapellido")
    private String primerApellido;

    @Column(name="segundoapellido")
    private String segundoApellido;

    @Column(name="calle")
    private String calle;

    @Column(name="numero")
    private String numero;

    @Column(name="colonia")
    private String colonia;

    @Column(name="codigopostal")
    private String codigopostal;

    @Column(name="telefono")
    private String telefono;

    @Column(name="rfc")
    private String rfc;

    @Lob
    @Column(name="documentos")
    private String documentos;

    @Column(name="statusprospecto")
    private String statusProspecto;

    @Column(name="observacion")
    private String observacion;


}
