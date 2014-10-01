/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azteca.persistence.repository;

import com.azteca.persistence.entities.KalturaCuenta;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface KalturaCuentaRepository  extends PagingAndSortingRepository<KalturaCuenta, Integer>{
    List<KalturaCuenta> findAll();
    List<KalturaCuenta> findByNombre(String nombre);
    List<KalturaCuenta> findBypartner(Integer partner);
}
