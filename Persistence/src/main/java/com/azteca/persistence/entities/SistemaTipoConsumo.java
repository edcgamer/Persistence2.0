/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "SISTEMA_TIPO_CONSUMO")
public class SistemaTipoConsumo implements Serializable{
    
    @Id
    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;

    public SistemaTipoConsumo() {
    }

    
    public SistemaTipoConsumo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
