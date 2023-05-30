package com.bolsadeideas.spring.boot.app.controllers;

import com.bolsadeideas.spring.boot.app.dao.IClienteDao;
import com.bolsadeideas.spring.boot.app.models.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("titulo", "Listado de cliente");
        model.addAttribute("clientes", clienteDao.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String crear(Model model) {
        Cliente cliente = new Cliente();

        model.addAttribute("cliente",cliente);
        model.addAttribute("titulo", "Formulario de cliente");
        return "form";
    }

    @PostMapping("/form")
        public String guardar(Cliente cliente){
            clienteDao.save(cliente);
            return "redirect:list";
        }
}
