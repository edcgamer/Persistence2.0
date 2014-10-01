/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "REPORTE")
public class Reporte {
    
      private static final long serialVersionUID = 1L;
    
    
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence", sequenceName = "reportes_seq")
    @NotNull
    @Column(name = "REPORT_ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ENTRY_ID")
    private String entry;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MINUTES")
    private String minutes;

    public Reporte() {
    }
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TAMANIO")
    private Integer tamanio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARTNER_ID")
    private Integer partner;

    public Reporte(String entry, String minutes, Integer size, Integer partner) {
        this.entry = entry;
        this.minutes = minutes;
        this.tamanio = size;
        this.partner = partner;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the entry
     */
    public String getEntry() {
        return entry;
    }

    /**
     * @param entry the entry to set
     */
    public void setEntry(String entry) {
        this.entry = entry;
    }

    /**
     * @return the minutes
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

   

    /**
     * @return the partner
     */
    public Integer getPartner() {
        return partner;
    }

    /**
     * @param partner the partner to set
     */
    public void setPartner(Integer partner) {
        this.partner = partner;
    }

    /**
     * @return the tamanio
     */
    public Integer getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }
    

}
