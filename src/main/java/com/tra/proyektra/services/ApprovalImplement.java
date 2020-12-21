/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Approval;
import com.tra.proyektra.repository.RepoApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class ApprovalImplement implements ApprovalInterface{

    @Autowired
    private RepoApproval repoApproval;
    
    @Override
    public Iterable<Approval> findAllapproval() {
        return repoApproval.findAll();
    }
    
}
