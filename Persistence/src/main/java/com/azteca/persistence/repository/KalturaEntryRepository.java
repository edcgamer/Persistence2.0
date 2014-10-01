/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.KalturaEntry;
import com.azteca.persistence.entities.KalturaPrograma;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Santa
 */
public interface KalturaEntryRepository extends PagingAndSortingRepository<KalturaEntry, Integer>{
    List<KalturaEntry> findAll();
    List<KalturaEntry> findByNombre(String nombre);
    List<KalturaEntry> findByEntryId(String nombre);
    @Query("select u from  KalturaEntry u where (u.fechaCreacion between :primera and  :segunda) AND u.kalturaPrograma=:tercera ")
    List<KalturaEntry> findCortesByFecha(@Param("primera") Date fechaInicial, @Param("segunda") Date fechaFinal,@Param("tercera")KalturaPrograma kp );
}
