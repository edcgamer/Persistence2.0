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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "COMSCORE_PROGRAMA")
public class ComscorePrograma implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "CM_PROGRAMA_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @JoinColumn(name = "ID_COMSCORE_FABRICA", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private ComscoreFabrica comscoreFabrica;
    


    public ComscorePrograma() {
    }

    public ComscorePrograma(String nombre, ComscoreFabrica comscoreFabrica) {
        this.nombre = nombre;
        this.comscoreFabrica = comscoreFabrica;
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

    public ComscoreFabrica getComscoreFabrica() {
        return comscoreFabrica;
    }

    public void setComscoreFabrica(ComscoreFabrica comscoreFabrica) {
        this.comscoreFabrica = comscoreFabrica;
    }
    
    
    
}
