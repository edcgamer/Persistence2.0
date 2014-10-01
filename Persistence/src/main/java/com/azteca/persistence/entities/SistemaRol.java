/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static org.hibernate.type.TypeFactory.serializable;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_ROL")
public class SistemaRol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @ManyToMany
    @JoinTable(name = "SISTEMA_ROL_MODULO",
            joinColumns = {
                @JoinColumn(name = "ID_ROL")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_MODULO")})
    private List<SistemaModulo> listaModulos;

    public List<SistemaModulo> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(List<SistemaModulo> listaModulos) {
        this.listaModulos = listaModulos;
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
    
    
}
