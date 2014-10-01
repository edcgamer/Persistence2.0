/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.Reporte;
import com.azteca.persistence.entities.SistemaFecha;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface SistemaFechaRepository extends PagingAndSortingRepository<SistemaFecha, Integer>{
    List<SistemaFecha> findAll();
}
