/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azteca.persistence.repository;

import com.azteca.persistence.entities.KalturaMaterial;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface KalturaMaterialRepository extends PagingAndSortingRepository<KalturaMaterial, Integer>{
    List<KalturaMaterial> findAll();
    List<KalturaMaterial> findByEntryId(String entryId);
}
