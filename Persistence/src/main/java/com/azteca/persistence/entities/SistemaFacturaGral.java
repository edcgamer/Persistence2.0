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
@Table(name = "SISTEMA_FACTURA_GRAL")
public class SistemaFacturaGral implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.Sistemafactura.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_FACTURA_GRAL")
    private List<Sistemafactura> listaFacturas;

    public SistemaFacturaGral() {
    }

    public SistemaFacturaGral(String nombre) {
        this.nombre = nombre;
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

    public List<Sistemafactura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Sistemafactura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    
    

}
