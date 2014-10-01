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
@Table(name = "KALTURA_PROGRAMA")
public class KalturaPrograma implements Serializable{
    
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
    
    @JoinColumn(name = "ID_KAL_FAB", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private KalturaFabrica kalturaFabrica;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.KalturaEntry.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_KAL_PRO")
    private List<KalturaEntry> listraEntry;

    public KalturaPrograma() {
    }

    public KalturaPrograma(String nombre, Integer idKaltura, KalturaFabrica kalturaFabrica) {
        this.nombre = nombre;
        this.idKaltura = idKaltura;
        this.kalturaFabrica = kalturaFabrica;
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

    public KalturaFabrica getKalturaFabrica() {
        return kalturaFabrica;
    }

    public void setKalturaFabrica(KalturaFabrica kalturaFabrica) {
        this.kalturaFabrica = kalturaFabrica;
    }

    public List<KalturaEntry> getListraEntry() {
        return listraEntry;
    }

    public void setListraEntry(List<KalturaEntry> listraEntry) {
        this.listraEntry = listraEntry;
    }
    
    
}
