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
@Table(name = "SISTEMA_SUBREPORTE")
public class SistemaSubReporte implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "SUBREPORTE_SEQ")
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "CUENTA")
    private String cuenta;
    
    @Basic(optional = false)
    @Size(min = 1, max = 55)
    @Column(name = "UNIDAD")
    private String unidad;
    
    @Basic(optional = false)
    @Size(min = 1, max = 55)
    @Column(name = "FABRICA")
    private String fabrica;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAMANIO")
    private double tamanio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "TIEMPO_VISTO")
    private Long tiempoVisto;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    private long duracion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_ENTRYS")
    private long totalEntrys;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "TIPO")
    private String tipo;
    
    @Column(name = "NO_VISTOS")
    private int noVistos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CORTE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCorte;

    public SistemaSubReporte() {
    }

    public int getNoVistos() {
        return noVistos;
    }

    public void setNoVistos(int noVistos) {
        this.noVistos = noVistos;
    }

    
    
    public SistemaSubReporte(String nombre, double tamanio, Long tiempoVisto, long duracion, String tipo, Date fechaCorte,String cuenta,long totalEntrys,int novistos) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tiempoVisto = tiempoVisto;
        this.duracion = duracion;
        this.tipo = tipo;
        this.fechaCorte = fechaCorte;
        this.cuenta= cuenta;
        this.totalEntrys=totalEntrys;
        this.noVistos=novistos;
    }
    
    public SistemaSubReporte(String nombre, double tamanio, Long tiempoVisto, long duracion, String tipo, Date fechaCorte,String cuenta,long totalEntrys,String unidad,int novistos) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tiempoVisto = tiempoVisto;
        this.duracion = duracion;
        this.tipo = tipo;
        this.fechaCorte = fechaCorte;
        this.cuenta= cuenta;
        this.totalEntrys=totalEntrys;
        this.unidad= unidad;
        this.noVistos=novistos;
    }
    
    public SistemaSubReporte(String nombre, double tamanio, Long tiempoVisto, long duracion, String tipo, Date fechaCorte,String cuenta,long totalEntrys,String unidad,String fabrica,int novistos) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tiempoVisto = tiempoVisto;
        this.duracion = duracion;
        this.tipo = tipo;
        this.fechaCorte = fechaCorte;
        this.cuenta= cuenta;
        this.totalEntrys=totalEntrys;
        this.unidad= unidad;
        this.fabrica=fabrica;
        this.noVistos=novistos;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }
    
    

    public long getTotalEntrys() {
        return totalEntrys;
    }

    public void setTotalEntrys(long totaEntrys) {
        this.totalEntrys = totaEntrys;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public Long getTiempoVisto() {
        return tiempoVisto;
    }

    public void setTiempoVisto(Long tiempoVisto) {
        this.tiempoVisto = tiempoVisto;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }
    
    
    
    
    
}
