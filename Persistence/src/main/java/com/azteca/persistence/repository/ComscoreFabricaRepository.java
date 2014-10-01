/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.ComscoreFabrica;
import com.azteca.persistence.entities.ComscorePrograma;
import com.azteca.persistence.entities.ComscoreSitio;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface ComscoreFabricaRepository extends PagingAndSortingRepository<ComscoreFabrica, Integer>{
    public List<ComscoreFabrica> findAll();
    public List<ComscoreFabrica> findByNombreAndComscoreSitio(String nombre,ComscoreSitio cs);
    
}
