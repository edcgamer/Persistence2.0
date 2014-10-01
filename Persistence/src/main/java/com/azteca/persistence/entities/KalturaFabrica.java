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
@Table(name = "KALTURA_FABRICA")
public class KalturaFabrica implements Serializable{
    
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
    @Column(name = "ID_KALTURA")
    private Integer idKaltura;
    
    @JoinColumn(name = "ID_KAL_UNI", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private KalturaUnidad kalturaUnidad;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.KalturaPrograma.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_KAL_FAB")
    private List<KalturaPrograma> listaProgramas;

    public KalturaFabrica() {
    }

    public KalturaFabrica(String nombre, Integer idKaltura, KalturaUnidad kalturaUnidad) {
        this.nombre = nombre;
        this.idKaltura = idKaltura;
        this.kalturaUnidad = kalturaUnidad;
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

    public KalturaUnidad getKalturaUnidad() {
        return kalturaUnidad;
    }

    public void setKalturaUnidad(KalturaUnidad kalturaUnidad) {
        this.kalturaUnidad = kalturaUnidad;
    }

    public List<KalturaPrograma> getListaProgramas() {
        return listaProgramas;
    }

    public void setListaProgramas(List<KalturaPrograma> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }
    
    
    
}
