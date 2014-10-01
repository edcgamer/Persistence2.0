/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.azteca.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author aLex
 */
public class Intervalo implements Serializable{

    private Date fechaInicio;
    private Date fechaFin;

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Long getFinL() {
        return fechaFin.getTime();
    }
    
    public Long getInicioL() {
        return fechaInicio.getTime();
    }
    public Intervalo() {
    }

    public Intervalo(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String cad = "";
        String cad2 = "";
        try {
            if (fechaInicio == null) {
                cad = "*";
            } else {
                cad = dateFormat.format(fechaInicio).replaceFirst(" ", "T")+"Z";
            }

            if (fechaFin == null) {
                cad2 = "*";
            } else {
                cad2 = dateFormat.format(fechaFin).replaceFirst(" ", "T")+"Z";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "["+cad + " TO " + cad2+"]";
    }
}
