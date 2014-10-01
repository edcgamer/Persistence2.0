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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "COMSCORE_SITIO")
public class ComscoreSitio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "PROGRAMA_SEQ")
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
    @Size(min = 1, max = 45)
    @Column(name = "REFERENCIA")
    private String referencia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USUARIO")
    private String usuario;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.ComscoreFabrica.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_COMSCORE_SITIO")
    private List<ComscoreFabrica> listaComscoreFabricas;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @LazyCollection(LazyCollectionOption.TRUE)
    @Size(min = 1, max = 10)
    @Column(name = "PW")
    private byte[] contrasena;

    public List<ComscoreFabrica> getListaComscoreFabricas() {
        return listaComscoreFabricas;
    }

    public void setListaComscoreFabricas(List<ComscoreFabrica> listaComscoreFabricas) {
        this.listaComscoreFabricas = listaComscoreFabricas;
    }

    
    public ComscoreSitio() {
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    public ComscoreSitio(String nombre,String referencia) {
        this.nombre = nombre;
        this.referencia= referencia;
    }

    public byte[] getContrasena() {
        return contrasena;
    }

    public void setContrasena(byte[] contrasena) {
        this.contrasena = contrasena;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

}
