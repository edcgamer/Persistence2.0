/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "COMSCORE_CONSUMOS")
public class ComscoreConsumo implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "CM_CONSUMOS_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAFICO")
    private Double trafico;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "STORAGE")
    private Double tamanio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CORTE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCorte;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SITIO")
    private String sitio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FABRICA")
    private String fabrica;
    
    
    public ComscoreConsumo() {
    }

    public ComscoreConsumo(String nombre, Double trafico, Double tamanio, Date fechaCorte, String sitio, String fabrica) {
        this.nombre = nombre;
        this.trafico = trafico;
        this.tamanio = tamanio;
        this.fechaCorte = fechaCorte;
        this.sitio = sitio;
        this.fabrica = fabrica;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTrafico() {
        return trafico;
    }

    public void setTrafico(Double trafico) {
        this.trafico = trafico;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }

  
    
}
