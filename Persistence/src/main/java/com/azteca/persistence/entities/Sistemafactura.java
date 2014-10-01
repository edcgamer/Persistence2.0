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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_FACTURA")
public class Sistemafactura implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @JoinColumn(name = "SISTEMA_SERVICIO", referencedColumnName = "ID")
    @NotNull
//    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @ManyToOne
    private SistemaServicio sistemaServicio;

    @JoinColumn(name = "ID_FACTURA_GRAL", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private SistemaFacturaGral sistemaFacturaGral;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBTOTAL")
    private String subTotal;

    public Sistemafactura() {
    }

    public Sistemafactura(Date fechaInicio, Date fechaFin, SistemaServicio sistemaServicio) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sistemaServicio = sistemaServicio;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public SistemaServicio getSistemaServicio() {
        return sistemaServicio;
    }

    public void setSistemaServicio(SistemaServicio sistemaServicio) {
        this.sistemaServicio = sistemaServicio;
    }

    public SistemaFacturaGral getSistemaFacturaGral() {
        return sistemaFacturaGral;
    }

    public void setSistemaFacturaGral(SistemaFacturaGral sistemaFacturaGral) {
        this.sistemaFacturaGral = sistemaFacturaGral;
    }

}
