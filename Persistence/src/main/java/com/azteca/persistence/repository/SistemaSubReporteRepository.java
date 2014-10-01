/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azteca.persistence.repository;

import com.azteca.persistence.entities.SistemaReporte;
import com.azteca.persistence.entities.SistemaSubReporte;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Santa
 */
public interface SistemaSubReporteRepository extends PagingAndSortingRepository<SistemaSubReporte, Integer> {

    List<SistemaSubReporte> findAll();

    List<SistemaSubReporte> findByNombre(String entry);

    List<SistemaSubReporte> findByTipoAndNoVistos(String tipo,int novistos);
    
    @Query("select distinct (MAX(u.fechaCorte)) from SistemaSubReporte u")
    Date ultimaFecha();
    
    @Query("select distinct u.fechaCorte from SistemaSubReporte u where (u.fechaCorte between :primera and  :segunda) ")
    List<SistemaSubReporte> findCortesByFecha(@Param("primera") Date fechaInicial, @Param("segunda") Date fechaFinal);
    
    @Query("select u from SistemaSubReporte u where u.tipo=:primera and u.cuenta=:segunda  and u.noVistos=:tercera")
    List<SistemaSubReporte> findReportNivelUnidad(@Param("primera") String tipo, @Param("segunda") String cuenta, @Param("tercera") int novistos);

    @Query("select u from SistemaSubReporte u where u.tipo=:primera and u.cuenta=:segunda and u.unidad=:tercera and u.noVistos=:cuarta")
    List<SistemaSubReporte> findReportNivelFabrica(@Param("primera") String tipo, @Param("segunda") String cuenta, @Param("tercera") String unidad, @Param("cuarta") int novistos);
    
    @Query("select u from SistemaSubReporte u where u.tipo=:primera and u.cuenta=:segunda and u.fabrica=:tercera and u.noVistos=:cuarta")
    List<SistemaSubReporte> findReportNivelPrograma(@Param("primera") String tipo, @Param("segunda") String cuenta, @Param("tercera") String fabrica, @Param("cuarta") int novistos);
    
    @Query("select u from SistemaSubReporte u where u.fechaCorte between :primera and  :segunda and u.tipo=:tercera and u.noVistos=:cuarta")
    List<SistemaSubReporte> findReportByFechaCorte(@Param("primera") Date lastname, @Param("segunda") Date firstname, @Param("tercera") String tipo, @Param("cuarta") int novistos);

    @Query("select u from SistemaSubReporte u where u.fechaCorte between :primera and :segunda and u.tipo=:tercera and u.cuenta=:cuarta and u.noVistos=:quinta")
    List<SistemaSubReporte> findReportByFechaCorteNivelUnidad(@Param("primera") Date lastname, @Param("segunda") Date firstname, @Param("tercera") String tipo, @Param("cuarta") String unidad, @Param("quinta") int novistos);

    @Query("select u from SistemaSubReporte u where u.fechaCorte between :primera and  :segunda and u.tipo=:tercera and u.cuenta=:cuarta and u.unidad=:quinta and u.noVistos=:sexta")
    List<SistemaSubReporte> findReportByFechaCorteNivelfabrica(@Param("primera") Date lastname, @Param("segunda") Date firstname, @Param("tercera") String tipo, @Param("cuarta") String cuenta, @Param("quinta") String Unidad, @Param("sexta") int novistos);

    @Query("select u from SistemaSubReporte u where u.fechaCorte between :primera and  :segunda and u.tipo=:tercera and u.cuenta=:cuarta and u.fabrica=:quinta and u.noVistos=:sexta")
    List<SistemaSubReporte> findReportByFechaCorteNivelPrograma(@Param("primera") Date lastname, @Param("segunda") Date firstname, @Param("tercera") String tipo, @Param("cuarta") String cuenta, @Param("quinta") String fabrica, @Param("sexta") int novistos);
}
