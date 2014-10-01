/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.ComscoreConsumo;
import com.azteca.persistence.entities.KalturaCuenta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Santa
 */
public interface ComscoreConsumoRepository extends PagingAndSortingRepository<ComscoreConsumo, Integer>{
    List<ComscoreConsumo> findAll();

    @Query("select distinct (MAX(u.fechaCorte)) from ComscoreConsumo u")
    Date ultimaFecha();
    
    List<ComscoreConsumo> findByNombreAndFechaCorte(String nombre, Date fechaCorte);

    @Query("select u from ComscoreConsumo u where  u.fechaCorte between :tercera and  :cuarta")
    List<ComscoreConsumo> findByFechaCorteA(@Param("tercera") Date fechaInicio, @Param("cuarta") Date fechaFinal);
    
    @Query("select u from ComscoreConsumo u where  u.sitio=:primera and u.fechaCorte between :tercera and  :cuarta")
    List<ComscoreConsumo> findByFechaCorteAndSitio(@Param("primera") String unidad, @Param("tercera") Date fechaInicio, @Param("cuarta") Date fechaFinal);

    @Query("select u from ComscoreConsumo u where  u.sitio=:primera ")
    List<ComscoreConsumo> findBySitio(@Param("primera") String unidad);
    
    @Query("select u from ComscoreConsumo u where  u.sitio=:primera and u.fabrica=:segunda and u.fechaCorte between :tercera and  :cuarta")
    List<ComscoreConsumo> findByFechaCorteAndFabricaAndSitio(@Param("primera") String unidad, @Param("segunda") String fabrica, @Param("tercera") Date fechaInicio, @Param("cuarta") Date fechaFinal);

    @Query("select u from ComscoreConsumo u where  u.sitio=:primera and u.fabrica=:segunda")
    List<ComscoreConsumo> findByFabricaAndSitio(@Param("primera") String unidad,@Param("segunda") String fabrica);
      

}
