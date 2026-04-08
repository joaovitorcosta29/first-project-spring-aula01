/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aulaum.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class UsuarioController {
    @GetMapping("/perfil")
    public String perfil(Model model){
        model.addAttribute("nome", "João Vitor Costa");
        model.addAttribute("curso", "Técnico em Desenvolvimento de Sistemas");// primeiro varivel e o segundo é valor
        model.addAttribute("Linguagem", "Java");
        return "perfil";
    }
}
