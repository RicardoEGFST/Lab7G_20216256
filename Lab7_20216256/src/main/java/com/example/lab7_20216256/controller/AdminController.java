package com.example.lab7_20216256.controller;


import com.example.lab7_20216256.entity.Funcion;
import com.example.lab7_20216256.repository.FuncionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    final FuncionRepository funcionRepository;

    public AdminController(FuncionRepository funcionRepository) {
        this.funcionRepository = funcionRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarFunciones(Model model) {

        List<Funcion> lista = funcionRepository.findAll();
        model.addAttribute("funciones", lista);
        return "funciones/list";
    }

    @GetMapping("/new")
    public String nuevaFuncion(@ModelAttribute("funciones") Funcion funcion) {
        return "funciones/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevaFuncion(@ModelAttribute("funciones") Funcion funcion, Model model, RedirectAttributes attr) {

        if (funcion.getObra().equals("")) {
            model.addAttribute("errorCompany", "El nombre no puede ser vacío");
            return "funciones/newFrm";
        } else {
            if (funcion.getId() == 0) {
                attr.addFlashAttribute("msg", "Función creada exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Función actualizada exitosamente");
            }
            funcionRepository.save(funcion);
            return "redirect:/shipper/list";
        }
    }

    @GetMapping("/edit")
    public String editarFuncion(Model model,
                                      @RequestParam("id") int id,
                                      @ModelAttribute("funciones") Funcion funcion) {

        Optional<Funcion> optShipper = funcionRepository.findById(id);

        if (optShipper.isPresent()) {
            funcion = optShipper.get();
            model.addAttribute("funcion", funcion);
            return "funciones/newFrm";
        } else {
            return "redirect:/shipper/list";
        }
    }

}
