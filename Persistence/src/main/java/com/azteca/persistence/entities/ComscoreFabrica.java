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
@Table(name = "COMSCORE_FABRICA")
public class ComscoreFabrica implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "CM_FABRICA_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @JoinColumn(name = "ID_COMSCORE_SITIO", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private ComscoreSitio comscoreSitio;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.ComscoreFabrica.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_COMSCORE_FABRICA")
    private List<ComscorePrograma> listaComscoreProgramas;

    public ComscoreFabrica() {
    }

    public List<ComscorePrograma> getListaComscoreProgramas() {
        return listaComscoreProgramas;
    }

    public void setListaComscoreProgramas(List<ComscorePrograma> listaComscoreProgramas) {
        this.listaComscoreProgramas = listaComscoreProgramas;
    }

    
    public ComscoreFabrica(String nombre, ComscoreSitio comscoreSitio) {
        this.nombre = nombre;
        this.comscoreSitio = comscoreSitio;
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

    public ComscoreSitio getComscoreSitio() {
        return comscoreSitio;
    }

    public void setComscoreSitio(ComscoreSitio comscoreSitio) {
        this.comscoreSitio = comscoreSitio;
    }


    
}
