/*
 * To change this template, choose Tools | Templates
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "KALTURA_MATERIAL")
@XmlRootElement
public class KalturaMaterial implements Serializable {
    
    
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
//    @SequenceGenerator(name = "customerSequence", sequenceName = "MEDIA_KALTURA_SEQ")

    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ENTRYID_KALMAT")
    private String entryId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "KALMAT_FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "KALMAT_TAMANIO")
    private Integer tamanio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "KALMAT_DURACION")
    private Integer duration;
    
//    @JoinColumn(name = "ID_KALCUE_KALMAT", referencedColumnName = "ID_KALCUE")
//    @NotNull
//    @ManyToOne(optional = false)
//    private KalturaCuenta cuenta;
   
    
    private static final long serialVersionUID = 1L;
    
    public KalturaMaterial() {
    }

    /**
     * @return the entryId
     */
    public String getEntryId() {
        return entryId;
    }

    /**
     * @param entryId the entryId to set
     */
    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    /**
     * @return the tamano
     */
    public Integer getTamanio() {
        return tamanio;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamanio(Integer tamano) {
        this.tamanio = tamano;
    }

@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KalturaMaterial other = (KalturaMaterial) obj;
        if (this.entryId != other.entryId && (this.entryId == null || !this.entryId.equals(other.entryId))) {
            return false;
        }
        return true;
    }

 @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryId != null ? entryId.hashCode() : 0);
        return hash;
    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the cuenta
     */
//    public KalturaCuenta getCuenta() {
//        return cuenta;
//    }
//
//    /**
//     * @param cuenta the cuenta to set
//     */
//    public void setCuenta(KalturaCuenta cuenta) {
//        this.cuenta = cuenta;
//    }
   
}

