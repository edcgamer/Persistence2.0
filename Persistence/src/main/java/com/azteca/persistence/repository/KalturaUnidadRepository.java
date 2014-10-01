/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.KalturaFabrica;
import com.azteca.persistence.entities.KalturaUnidad;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Santa
 */
public interface KalturaUnidadRepository extends PagingAndSortingRepository<KalturaUnidad, Integer>{
    List<KalturaUnidad> findAll();
    List<KalturaUnidad> findByNombre(String nombre);
    List<KalturaUnidad> findByIdKaltura(int id);
    
    @Query("select p from KalturaUnidad  p WHERE UPPER(p.nombre) LIKE :primera")
    List<KalturaUnidad> findLikeUnidad(@Param("primera") String unidad);
}
