/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.SistemaServicio;
import com.azteca.persistence.entities.Sistemafactura;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface SistemaFacturaRepository extends PagingAndSortingRepository<Sistemafactura, Integer>{
    List<Sistemafactura> findAll();
    List<Sistemafactura> findBySistemaServicio(SistemaServicio ss);
}
