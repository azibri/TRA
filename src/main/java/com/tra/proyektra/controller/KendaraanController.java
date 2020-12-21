/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Kendaraan;
import com.tra.proyektra.repository.RepoKendaraan;
import com.tra.proyektra.services.KendaraanImplement;
import com.tra.proyektra.services.KendaraanInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
public class KendaraanController {
    
    @Autowired
    private KendaraanInterface kendaraanInterface;
    
    
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String createindex(Model model) {
//       model.addAttribute("kendaraan", new Kendaraan());
//       return "kendaraan";
//    }
    
    @RequestMapping("/kendaraan")
    public String Allkendaraan(Model model) {
        List<Kendaraan> kendaraan = kendaraanInterface.findAll();
        
        model.addAttribute("listkendaraan", kendaraan);
//        model.addAttribute("kendaraan", new Kendaraan());
//        model.addAttribute("kendaraan1", kendaraanInterface.getKendaraan(kendaraan_id));
        
        return "kendaraan";
    }
   
    
//    @RequestMapping(value = "/editkendaraan/{id}")
//    public String editkendaraan(@PathVariable(name = "id") int kendaraan_id, Model model) {
//        Kendaraan kendaraan = new Kendaraan();
//
//        model.addAttribute("kendaraan", kendaraanInterface.getKendaraan(kendaraan_id));
//        System.out.println(model);
//        return "/kendaraan";
//    }
    
    @RequestMapping(value = "/editkendaraan")
    @ResponseBody
    public Optional<Kendaraan> findKendaraan(Integer kendaraan_id){
        return kendaraanInterface.findKendaraan(kendaraan_id);
    }
    
//    @RequestMapping(value = "/addkendaraan")
//    public String addkendaraan(Model model) {
//        Kendaraan kendaraan = new Kendaraan();
//        
////        model.addAttribute("kendaraan", kendaraanImplement.findAllkendaraan());
//        
//        model.addAttribute("kendaraan", kendaraan);
//        
//        return "/kendaraan";
//    }
    
    
    @PostMapping("/addkendaraan")
    public String addKendaraan(Kendaraan kendaraan) {
        
        kendaraanInterface.addKendaraan(kendaraan);
        
        return "redirect:/kendaraan";
    }
    
    
    @RequestMapping(value = "/savekendaraan", method = RequestMethod.POST)
    public String saveKendaraan(Kendaraan kendaraan) {
        
        kendaraanInterface.saveKendaraan(kendaraan);
        
        return "redirect:/kendaraan";
    }
    

    
    @RequestMapping(value = "/deletekendaraan/{id}", method = RequestMethod.GET)
    public String deletekendaraan(@PathVariable(name = "id") int kendaraan_id) {
        kendaraanInterface.deleteKendaraan(kendaraan_id);
        
        return "redirect:/kendaraan";
    }
    
    
//    @RequestMapping(value = "/editkendaraan/{id}", method = RequestMethod.GET)
//    public String editkendaraan(@PathVariable(name = "id") int kendaraan_id, Model model) {
//        Kendaraan kendaraan = kendaraanImplement.getKendaraan(kendaraan_id);
//        model.addAttribute("kendaraan1", kendaraan);
//        
////        Kendaraan s = new Kendaraan();
////        Kendaraan tmp = kendaraanImplement.getKendaraan(kendaraan_id);
//        
//        return "/kendaraan";
//    }
    
    

    
    
}
