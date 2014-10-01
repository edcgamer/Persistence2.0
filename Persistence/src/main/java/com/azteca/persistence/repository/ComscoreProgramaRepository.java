/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.azteca.persistence.repository;

import com.azteca.persistence.entities.ComscorePrograma;
import com.azteca.persistence.entities.ComscoreSitio;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface ComscoreProgramaRepository extends PagingAndSortingRepository<ComscorePrograma, Integer>{
    public List<ComscorePrograma> findAll();
    public List<ComscorePrograma> findByNombre(String nombre);
    
}
