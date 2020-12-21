/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Approval;

/**
 *
 * @author asus
 */
public interface ApprovalInterface {
    
    Iterable<Approval> findAllapproval();
    
}
