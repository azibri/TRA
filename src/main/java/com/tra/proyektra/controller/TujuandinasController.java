/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Tujuandinas;
import com.tra.proyektra.services.TujuandinasInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author asus
 */
@Controller
public class TujuandinasController {
    
    @Autowired
    private TujuandinasInterface tujuandinasInterface;
    
    
//    @RequestMapping(value = "/tujuandinas")
//    public String alltujuandinas(Model model) {
//        List<Tujuandinas> tujuandinas = tujuandinasInterface.findAll();
//        
//        model.addAttribute("listtujuandinas", tujuandinas);
////        model.addAttribute("listtujuandinas", tujuandinasInterface.findAllTujuandinas());
//        model.addAttribute("tujuandinas", new Tujuandinas());
//        return "/tujuandinas";
//    }
    
    @RequestMapping(value = "/tujuandinas")
    public String alltujuandinas(Model model) {
        model.addAttribute("listtujuandinas", tujuandinasInterface.findAllTujuandinas());
        model.addAttribute("tujuandinas", new Tujuandinas());
        return "/tujuandinas";
    }
    
//    @RequestMapping(value = "/addtujuandinas")
//    public String addtujuandinas(Model model) {
//        Tujuandinas tujuandinas = new Tujuandinas();
//        
//        model.addAttribute("tujuandinas", tujuandinas);
//        return "/tujuandinasadd";
//    }
    
    @RequestMapping(value = "/addtujuandinas", method = RequestMethod.POST)
    public String addTujuandinas(Tujuandinas tujuandinas) {
        tujuandinasInterface.savetujuandinas(tujuandinas);
        return "redirect:/tujuandinas";
    }
    
    
    @RequestMapping(value = "/savetujuandinas", method = RequestMethod.POST)
    public String saveKendaraan(Tujuandinas tujuandinas) {
        
        tujuandinasInterface.savetujuandinas(tujuandinas);
        
        return "redirect:/tujuandinas";
    }
    
    
//    @RequestMapping(value = "/edittujuandinas/{id}")
//    public ModelAndView edittujuandinas(@PathVariable(name = "id") int tujuandinas_id) {
//        ModelAndView edit = new ModelAndView("tujuandinasedit");
//        Tujuandinas tujuandinas = tujuandinasInterface.getTujuandinas(tujuandinas_id);
//        edit.addObject("tujuandinas", tujuandinas);
//        
//        return edit;
//    }
    
//    @RequestMapping(value = "/edittujuandinas")
//    @ResponseBody
//    public Tujuandinas getTujuandinas(Integer tujuandinas_id){
//        return tujuandinasInterface.getTujuandinas(tujuandinas_id);
//    }
    
    @RequestMapping(value = "/edittujuandinas")
    @ResponseBody
    public Optional<Tujuandinas> findTujuandinas(Integer tujuandinas_id){
        return tujuandinasInterface.findTugasdinas(tujuandinas_id);
    }
    
    

    @RequestMapping(value = "/deletetujuandinas/{id}", method = RequestMethod.GET)
    public String deletetujuandinas(@PathVariable(name = "id") int tujuandinas_id) {
        
        tujuandinasInterface.deletetujuandinas(tujuandinas_id);
        return "redirect:/tujuandinas";
    }
    
    
    
}
