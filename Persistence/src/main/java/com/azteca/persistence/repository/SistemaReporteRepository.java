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
public interface SistemaReporteRepository extends PagingAndSortingRepository<SistemaReporte, Integer> {

    List<SistemaReporte> findAll();

    List<SistemaReporte> findByEntryId(String entry);

    List<SistemaReporte> findByFechaCorte(Date fecha);

    List<SistemaReporte> findByEntryIdAndFechaCorte(String entry, Date fecha);

    List<SistemaReporte> findByFechaCreacionAndNombrePrograma(Date fechaCreacion, String programa);

    List<SistemaReporte> findByFechaCreacionAndNombreUnidad(Date fechaCreacion, String unidad);

    List<SistemaReporte> findByFechaCreacionAndNombreFabrica(Date fechaCreacion, String fabrica);
    
//    @Query("select s FROM SistemaReporte s where (s.entryId,s.id) in (SELECT s.entryId,max(s.id) from ( SELECT s FROM SistemaReporte s WHERE  s.nombreUnidad = :primera AND s.tiempoVisto = 0 AND s.fechaCorte BETWEEN :segunda AND :tercera group by s.entryId)")
//    @Query("WITH QUERY1 AS (SELECT s FROM SistemaReporte s WHERE s.nombreUnidad=:primera AND TIEMPO_VISTO=0 AND s.fechaCorte  BETWEEN :segunda and :tercera) SELECT s FROM QUERY1 Q WHERE Q.id = (SELECT MIN(Q2.id) FROM QUERY1 Q2 WHERE Q.entryId = Q2.entryId)")
    @Query("select  s.entryId ,s.tamanio,SUM (s.tiempoVisto)   FROM SistemaReporte s WHERE s.nombreUnidad=:primera and s.fechaCorte between :segunda and :tercera group by  s.entryId,s.tamanio HAVING SUM (s.tiempoVisto) = 0")
    List<Object[]> findReporeNovistosGlobal(@Param("primera") String unidad, @Param("segunda") Date fechaInicial, @Param("tercera") Date fechaFinal);
    
    @Query("select  s.entryId ,s.tamanio,SUM (s.tiempoVisto)    FROM SistemaReporte s WHERE s.nombreUnidad=:primera and s.nombreFabrica=:cuarta and s.fechaCorte between :segunda and :tercera group by  s.entryId,s.tamanio HAVING SUM (s.tiempoVisto) = 0")
    List<Object[]> findReporeNovistosfabrica(@Param("primera") String unidad, @Param("segunda") Date fechaInicial, @Param("tercera") Date fechaFinal,@Param("cuarta")String fabrica);
    
    @Query("select distinct  s.entryId ,s.tamanio,SUM (s.tiempoVisto) ,s.duracion,s.nombrePrograma,s.nombreFabrica,s.nombreUnidad,s.fechaCreacion    FROM SistemaReporte s WHERE s.nombreUnidad=:primera and s.nombreFabrica=:cuarta and s.nombrePrograma=:quinta and s.fechaCorte between :segunda and :tercera group by  s.entryId,s.tamanio,s.duracion,s.nombrePrograma,s.nombreFabrica,s.nombreUnidad,s.fechaCreacion  HAVING SUM (s.tiempoVisto) = 0 ")
    List<Object[]> findReporeNovistosPrograma(@Param("primera") String unidad, @Param("segunda") Date fechaInicial, @Param("tercera") Date fechaFinal,@Param("cuarta")String fabrica,@Param("quinta")String programa);
    
    @Query("select distinct  s.entryId ,s.tamanio,SUM (s.tiempoVisto)   FROM SistemaReporte s WHERE s.nombreUnidad=:primera  and s.fechaCreacion between:cuarta and :quinta and s.fechaCorte between :segunda and :tercera  group by  s.entryId,s.tamanio HAVING SUM (s.tiempoVisto) = 0")
    List<Object[]> findReporeNovistosGlobalConCreacion(@Param("primera") String unidad, @Param("segunda") Date fechaInicial, @Param("tercera") Date fechaFinal, @Param("cuarta") Date fechaInicialCrea, @Param("quinta") Date fechaFinalCrea);
    
    @Query("select distinct  s.entryId ,s.tamanio,SUM (s.tiempoVisto)   FROM SistemaReporte s WHERE s.nombreUnidad=:primera and s.nombreFabrica=:cuarta and s.fechaCreacion between:quinta and :sexta and s.fechaCorte between :segunda and :tercera group by  s.entryId,s.tamanio HAVING SUM (s.tiempoVisto) = 0")
    List<Object[]> findReporeNovistosfabricaConCreacion(@Param("primera") String unidad, @Param("segunda") Date fechaInicial, @Param("tercera") Date fechaFinal,@Param("cuarta")String fabrica, @Param("quinta") Date fechaInicialCrea, @Param("sexta") Date fechaFinalCrea);
    
    @Query("select distinct  s.entryId ,s.tamanio,SUM (s.tiempoVisto) ,s.duracion,s.nombrePrograma,s.nombreFabrica,s.nombreUnidad,s.fechaCreacion  FROM SistemaReporte s WHERE s.nombreUnidad=:primera and s.nombreFabrica=:cuarta and s.nombrePrograma=:quinta and s.fechaCreacion between :sexta and :septima and s.fechaCorte between :segunda and :tercera group by  s.entryId,s.tamanio,s.duracion,s.nombrePrograma,s.nombreFabrica,s.nombreUnidad,s.fechaCreacion  HAVING SUM (s.tiempoVisto) = 0")
    List<Object[]> findReporeNovistosProgramaConCreacion(@Param("primera") String unidad, @Param("segunda") Date fechaInicial, @Param("tercera") Date fechaFinal,@Param("cuarta")String fabrica,@Param("quinta")String programa, @Param("sexta") Date fechaInicialCrea, @Param("septima") Date fechaFinalCrea);
    
    @Query("select u from SistemaReporte u where (((u.fechaCorte between :primera and  :segunda) and u.nombreUnidad=:tercera) and u.nombreFabrica=:cuarta)and u.nombrePrograma=:quinta ")
    List<SistemaReporte> findReportByFechaCorteNivelPrograma(@Param("primera") Date fechaInicial, @Param("segunda") Date fechaFinal, @Param("tercera") String unidad, @Param("cuarta") String cuenta, @Param("quinta") String programa);
    
    @Query("select u from SistemaReporte u where (((u.fechaCorte between :primera and  :segunda) and u.nombreUnidad=:tercera) and u.nombreFabrica=:cuarta)and u.nombrePrograma=:quinta and  u.tiempoVisto=0")
    List<SistemaReporte> findReportByFechaCorteNivelPrograma2(@Param("primera") Date fechaInicial, @Param("segunda") Date fechaFinal, @Param("tercera") String unidad, @Param("cuarta") String cuenta, @Param("quinta") String programa);

    @Query("select u from SistemaReporte u where ( ( u.nombreUnidad=:tercera) and u.nombreFabrica=:cuarta)and u.nombrePrograma=:quinta")
    List<SistemaReporte> findReportByNivelPrograma(@Param("tercera") String unidad, @Param("cuarta") String cuenta, @Param("quinta") String programa);

    @Query("select u from SistemaReporte u where ( ( u.nombreUnidad=:tercera) and u.nombreFabrica=:cuarta)and u.nombrePrograma=:quinta and u.tiempoVisto=0")
    List<SistemaReporte> findReportByNivelPrograma2(@Param("tercera") String unidad, @Param("cuarta") String cuenta, @Param("quinta") String programa);
    
    @Query("select u from SistemaReporte u where ((((u.fechaCorte=:primera) and u.nombreUnidad=:segunda) and u.nombreFabrica=:tercera)and u.nombrePrograma=:cuarta)")
    List<SistemaReporte> findReportByFechaCorteNivelProgramaSque(@Param("primera") Date fechaInicial, @Param("segunda") String unidad, @Param("tercera") String fabrica, @Param("cuarta") String programa);

    @Query("select distinct u.fechaCorte from SistemaReporte u where (u.fechaCorte between :primera and  :segunda) ")
    List<SistemaReporte> findCortesByFecha(@Param("primera") Date fechaInicial, @Param("segunda") Date fechaFinal);

    @Query("select distinct u.fechaCorte from SistemaSubReporte u")
    List<SistemaSubReporte> findCortes();

}
