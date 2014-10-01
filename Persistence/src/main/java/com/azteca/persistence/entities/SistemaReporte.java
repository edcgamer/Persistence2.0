/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "SISTEMA_REPORTE")
public class SistemaReporte implements Serializable{
    
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
    @Column(name = "ENTRY_ID")
    private String entryId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAMANIO")
    private Integer tamanio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    private Long duracion;
    
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @Column(name = "FECHA_CORTE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCorte;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO_VISTO")
    private Long tiempoVisto;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_PROGRAMA")
    private String nombrePrograma;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_FABRICA")
    private String nombreFabrica;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;

    public SistemaReporte() {
    }

    public SistemaReporte(String nombre, String entryId, Integer tamanio, Long duracion, Date fechaCreacion, Date fechaCorte, Long tiempoVisto, String nombrePrograma, String nombreFabrica, String nombreUnidad) {
        this.nombre = nombre;
        this.entryId = entryId;
        this.tamanio = tamanio;
        this.duracion = duracion;
        this.fechaCreacion = fechaCreacion;
        this.fechaCorte = fechaCorte;
        this.tiempoVisto = tiempoVisto;
        this.nombrePrograma = nombrePrograma;
        this.nombreFabrica = nombreFabrica;
        this.nombreUnidad = nombreUnidad;
    }

    public SistemaReporte(String entryId, Integer tamanio, Long tiempoVisto) {
        this.entryId = entryId;
        this.tamanio = tamanio;
        this.tiempoVisto = tiempoVisto;
    }
    
    public SistemaReporte(String entryId, Integer tamanio, Long tiempoVisto,Long duracion,String nombrePrograma,String nombreFabrica,String nombreUnidad,Date fechaCreacion) {
        this.entryId = entryId;
        this.tamanio = tamanio;
        this.tiempoVisto = tiempoVisto;
        this.duracion= duracion;
        this.nombrePrograma= nombrePrograma;
        this.nombreFabrica=nombreFabrica;
        this.nombreUnidad= nombreUnidad;
        this.fechaCreacion=fechaCreacion;
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

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Long getTiempoVisto() {
        return tiempoVisto;
    }

    public void setTiempoVisto(Long tiempoVisto) {
        this.tiempoVisto = tiempoVisto;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getNombreFabrica() {
        return nombreFabrica;
    }

    public void setNombreFabrica(String nombreFabrica) {
        this.nombreFabrica = nombreFabrica;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }
    
    
    
    
}
