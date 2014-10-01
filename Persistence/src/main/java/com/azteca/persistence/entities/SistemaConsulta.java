/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_CONSULTA")
public class SistemaConsulta implements Serializable{
    
    @Id
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Id
    @NotNull
    @Column(name = "TIPO")
    private Integer tipo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private SistemaProceso sistemaProceso;
    
    

    
    
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SistemaProceso getSistemaProceso() {
        return sistemaProceso;
    }

    public void setSistemaProceso(SistemaProceso sistemaProceso) {
        this.sistemaProceso = sistemaProceso;
    }
    
    
}
