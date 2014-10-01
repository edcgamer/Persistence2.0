/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.KalturaFabrica;
import com.azteca.persistence.entities.KalturaPrograma;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Santa
 */
public interface KalturaProgramaRepository extends PagingAndSortingRepository<KalturaPrograma, Integer>{
    List<KalturaPrograma> findAll();
    List<KalturaPrograma> findByNombre(String nombre);
    List<KalturaPrograma> findByIdKaltura(int id);
    List<KalturaPrograma> findByNombreAndKalturaFabrica(String nombre,KalturaFabrica kf);
    
    @Query("select p from KalturaPrograma p WHERE UPPER(p.nombre) LIKE :primera")
    List<KalturaPrograma> findLikePrograma(@Param("primera") String programa);
}
