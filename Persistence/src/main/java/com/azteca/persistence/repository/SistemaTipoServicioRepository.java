/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.SistemaTipoConsumo;
import com.azteca.persistence.entities.SistemaTipoServicio;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface SistemaTipoServicioRepository extends PagingAndSortingRepository<SistemaTipoServicio, Integer>{
    List<SistemaTipoServicio> findAll();
    SistemaTipoServicio findByNombre(String nombre);
//    @Query("select u from  u inner join u.area ar where ar.idArea = :idArea")
    List<SistemaTipoServicio> findByTipoConsumo(SistemaTipoConsumo tipoConsumo);
}
