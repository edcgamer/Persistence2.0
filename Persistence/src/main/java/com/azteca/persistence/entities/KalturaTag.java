/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azteca.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "KALTURA_TAG")
public class KalturaTag implements Serializable {

    @Id
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "KALTURA:ID")
    private String kaltiraId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKaltiraId() {
        return kaltiraId;
    }

    public void setKaltiraId(String kaltiraId) {
        this.kaltiraId = kaltiraId;
    }
    

}
