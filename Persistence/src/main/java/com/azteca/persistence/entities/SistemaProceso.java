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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_PROCESO")
public class SistemaProceso implements Serializable{
    
    @Id
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CRON")
    private String cron;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.SistemaConsulta.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_PROCESO")
    private List<SistemaConsulta> listaConsulta;
    
    @OneToMany(targetEntity=com.azteca.persistence.entities.SistemaFecha.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_PROCESO")
    private List<SistemaFecha> listaFecha;
    
    @ManyToMany
    @JoinTable(name = "SISTEMA_PROCESO_CUENTA",
            joinColumns = {
                @JoinColumn(name = "ID_PROCESO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CUENTA")})
    private List<KalturaCuenta> listaCuenta;

    public List<KalturaCuenta> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<KalturaCuenta> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }


    public List<SistemaFecha> getListaFecha() {
        return listaFecha;
    }

    public void setListaFecha(List<SistemaFecha> listaFecha) {
        this.listaFecha = listaFecha;
    }
    

    public List<SistemaConsulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<SistemaConsulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
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

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
    
    
}
