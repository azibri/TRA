/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.entities.Perjalanan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asus
 */
public interface RepoPerjalanan extends CrudRepository<Perjalanan, Integer> {

    
    public void save(Pengajuan z);


    
}
