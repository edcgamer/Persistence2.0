/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_FECHA")
public class SistemaFecha implements Serializable{
    @Id
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private SistemaProceso sistemaProceso;
    
    @Basic(optional = false)
    @Column(name = "FECHA_FINAL")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFinal;
    
    
    
    @Basic(optional = false)
    @Column(name = "TIEMPO")
    private Integer tiempo;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public SistemaProceso getSistemaProceso() {
        return sistemaProceso;
    }

    public void setSistemaProceso(SistemaProceso sistemaProceso) {
        this.sistemaProceso = sistemaProceso;
    }

    
   
    
}
