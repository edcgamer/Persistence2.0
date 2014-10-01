/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "KALTURA_ENTRY")
public class KalturaEntry implements Serializable{
    
    @Id
    @NotNull
    @Column(name = "ENTRY_ID")
    private String entryId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAMANIO")
    private Integer tamanio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    private Integer duracion;
    
    @JoinColumn(name = "ID_KAL_PRO", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private KalturaPrograma kalturaPrograma;
    
    @ManyToMany
    @JoinTable(name = "KALTURA_ENTRY_TAG",
            joinColumns = {
                @JoinColumn(name = "ID_KAL_ENT")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_KAL_TAG")})
    
    
    private List<KalturaTag> listaTag;

    public KalturaEntry(String entryId, String nombre, Date fechaCreacion, Integer tamanio, Integer duracion, KalturaPrograma kalturaPrograma) {
        this.entryId = entryId;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.tamanio = tamanio;
        this.duracion = duracion;
        this.kalturaPrograma = kalturaPrograma;
    }

    public KalturaEntry() {
    }

    
    public List<KalturaTag> getListaTag() {
        return listaTag;
    }

    public void setListaTag(List<KalturaTag> listaTag) {
        this.listaTag = listaTag;
    }

    
    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public KalturaPrograma getKalturaPrograma() {
        return kalturaPrograma;
    }

    public void setKalturaPrograma(KalturaPrograma kalturaPrograma) {
        this.kalturaPrograma = kalturaPrograma;
    }
    
    
}
