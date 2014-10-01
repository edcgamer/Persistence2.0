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
@Table(name = "SISTEMA_TIPO_SERVICIO")
public class SistemaTipoServicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "TIPO_SERVICIO_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROVEDOR")
    private String provedor;
    
    @JoinColumn(name = "TIPO_CONSUMO", referencedColumnName = "NOMBRE")
//    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @ManyToOne
    private SistemaTipoConsumo tipoConsumo;

    public SistemaTipoServicio(Integer id, String nombre, String provedor, SistemaTipoConsumo tipoConsumo) {
        this.id = id;
        this.nombre = nombre;
        this.provedor = provedor;
        this.tipoConsumo = tipoConsumo;
    }

    public SistemaTipoServicio(String nombre, String provedor, SistemaTipoConsumo tipoConsumo) {
        this.nombre = nombre;
        this.provedor = provedor;
        this.tipoConsumo = tipoConsumo;
    }
    
    

    public SistemaTipoServicio() {
        this.tipoConsumo= new SistemaTipoConsumo();
        this.tipoConsumo.setNombre("");
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

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public SistemaTipoConsumo getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(SistemaTipoConsumo tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }
    
    
}
