package com.azteca.persistence.repository;

import com.azteca.persistence.entities.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santa
 */
public interface SistemaUsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>{
    List<Usuario> findAll();
    Usuario findByUsername(String username);
}
