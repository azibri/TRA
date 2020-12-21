/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Divisi;
import com.tra.proyektra.services.DivisiInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
public class DivisiController {
    
    @Autowired
    private DivisiInterface divisiInterface;
    
    @RequestMapping(value = "/divisi")
    public String Alldivisi(Model model) {
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        model.addAttribute("divisi", new Divisi());
        
        return "/divisi";
    }
    
    
//    @RequestMapping(value = "/addtujuandinas", method = RequestMethod.POST)
//    public String addTujuandinas(Tujuandinas tujuandinas) {
//        tujuandinasInterface.savetujuandinas(tujuandinas);
//        return "redirect:/divisi";
//    }
    
//    @RequestMapping(value = "/adddivisi", method = RequestMethod.POST)
//    public String adddivisi(Divisi divisi) {
//        
//        divisiInterface.adddivisi(divisi);
//        
//        return "redirect:/divisi";
//    }
    
    @RequestMapping(value = "/savedivisi", method = RequestMethod.POST)
    public String savedivisi(Divisi divisi) {
        
        divisiInterface.savedivisi(divisi);
        
        return "redirect:/divisi";
    }
    
    @RequestMapping(value = "/editdivisi")
    @ResponseBody
    public Optional<Divisi> findDivisi(Integer divisi_id){
        return divisiInterface.findAll(divisi_id);
    }
    
    

    @RequestMapping(value = "/deletedivisi/{id}", method = RequestMethod.GET)
    public String deletedivisi(@PathVariable(name = "id") int divisi_id) {
        
        divisiInterface.deletedivisi(divisi_id);
        return "redirect:/divisi";
    }
    
    
    
}
