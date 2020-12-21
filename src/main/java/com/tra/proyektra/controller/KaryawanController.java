/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.repository.RepoKaryawan;
import com.tra.proyektra.services.DivisiInterface;
import com.tra.proyektra.services.KaryawanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author asus
 */
@Controller
public class KaryawanController {

    @Autowired
    private KaryawanInterface karyawanInterface;
    
    @Autowired
    private DivisiInterface divisiInterface;


    @RequestMapping(value = "/karyawan")
    public String allkaryawan(Model model) {
        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        
        return "/karyawan";
    }

    @RequestMapping(value = "/addkaryawan")
    public String addkaryawan(Model model) {
        Karyawan karyawan = new Karyawan();
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        
        model.addAttribute("karyawan", karyawan);
        return "/karyawanadd";
    }

    @RequestMapping(value = "/savekaryawan", method = RequestMethod.POST)
    public String savekaryawan(Karyawan karyawan) {
        karyawanInterface.savekaryawan(karyawan);
        return "redirect:/karyawan";
    }
    
    @RequestMapping(value = "/editkaryawan/{id}")
    public ModelAndView editkaryawan(@PathVariable(name = "id") int karyawan_id, Model model) {
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        ModelAndView edit = new ModelAndView("karyawanedit");
        Karyawan karyawan = karyawanInterface.getKaryawan(karyawan_id);
        edit.addObject("karyawan", karyawan);
        
        return edit;
    }
    
    @RequestMapping(value = "/deletekaryawan/{id}", method = RequestMethod.GET)
    public String deletekaryawan(@PathVariable(name = "id") int karyawan_id) {
        
        karyawanInterface.deletekaryawan(karyawan_id);
        return "redirect:/karyawan";
    }
    

}
