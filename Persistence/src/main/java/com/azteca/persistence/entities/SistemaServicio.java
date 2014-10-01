/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_SERVICIO")
public class SistemaServicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "SERVICIO_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO_UNITARIO")
    private double costoUnitario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "UNIDAD")
    private String unidad;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    
    
    @JoinColumn(name = "TIPO_SERVICIO", referencedColumnName = "ID")
    @NotNull
//    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @ManyToOne
    private SistemaTipoServicio sistemaServicio;

    public SistemaServicio() {
    }

    public SistemaServicio(Integer id, double costoUnitario, String unidad, SistemaTipoServicio sistemaServicio) {
        this.id = id;
        this.costoUnitario = costoUnitario;
        this.unidad = unidad;
        this.sistemaServicio = sistemaServicio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public SistemaTipoServicio getSistemaServicio() {
        return sistemaServicio;
    }

    public void setSistemaServicio(SistemaTipoServicio sistemaServicio) {
        this.sistemaServicio = sistemaServicio;
    }
    
    
}
