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
public interface KalturaFabricaRepository extends PagingAndSortingRepository<KalturaFabrica, Integer>{
    List<KalturaFabrica> findAll();
    List<KalturaFabrica> findByNombre(String nombre);
    List<KalturaFabrica> findByIdKaltura(Integer id);
    List<KalturaFabrica> findByNombreAndKalturaUnidad(String nombre ,KalturaUnidad ku);
    
    @Query("select p from KalturaFabrica p WHERE UPPER(p.nombre) LIKE :primera")
    List<KalturaFabrica> findLikeFabrica(@Param("primera") String fabrica);
    
    @Query("select count(k)  from KalturaEntry k JOIN  "
            + "k.kalturaPrograma p JOIN  "
            + "p.kalturaFabrica f  WHERE f.id=:primera")
    long findEntrysByFabrica(@Param("primera")int fabrica);
    
}
