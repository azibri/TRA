/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Approval;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asus
 */
public interface RepoApproval extends CrudRepository<Approval, Integer>{
    
}
