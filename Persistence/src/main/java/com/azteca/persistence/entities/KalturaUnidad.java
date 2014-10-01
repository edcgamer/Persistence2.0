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
@Table(name = "KALTURA_UNIDAD")
public class KalturaUnidad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "UNIDAD_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_KALTURA")
    private Integer idKaltura;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.KalturaFabrica.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_KAL_UNI")
    private List<KalturaFabrica> listaFabricas;
    
    @JoinColumn(name = "ID_KAL_CUE", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private KalturaCuenta kalturaCuenta;

    public KalturaUnidad() {
    }

    public KalturaUnidad(String nombre, Integer idKaltura, KalturaCuenta kalturaCuenta) {
        this.nombre = nombre;
        this.idKaltura = idKaltura;
        this.kalturaCuenta = kalturaCuenta;
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

    public Integer getIdKaltura() {
        return idKaltura;
    }

    public void setIdKaltura(Integer idKaltura) {
        this.idKaltura = idKaltura;
    }

    public List<KalturaFabrica> getListaFabricas() {
        return listaFabricas;
    }

    public void setListaFabricas(List<KalturaFabrica> listaFabricas) {
        this.listaFabricas = listaFabricas;
    }

    public KalturaCuenta getKalturaCuenta() {
        return kalturaCuenta;
    }

    public void setKalturaCuenta(KalturaCuenta kalturaCuenta) {
        this.kalturaCuenta = kalturaCuenta;
    }


    public KalturaCuenta getCuenta() {
        return kalturaCuenta;
    }

    public void setCuenta(KalturaCuenta cuenta) {
        this.kalturaCuenta = cuenta;
    }
    
    
}
