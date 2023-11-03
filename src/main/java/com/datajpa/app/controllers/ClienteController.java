package com.datajpa.app.controllers;

import com.datajpa.app.models.entity.Cliente;
import com.datajpa.app.models.entity.service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @RequestMapping(value = "/listar", method= RequestMethod.GET)
    public String listar (Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }
//metodo muestra el formulario
    @RequestMapping(value="/form")
    public String crear(Map<String, Object> model){

        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }


    @GetMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model){
        if(id > 0){
            Cliente cliente = clienteService.findOne(id);
            model.addAttribute("cliente", cliente);
        } else {
            model.addAttribute("cliente", new Cliente());
        }
        model.addAttribute("titulo", "Editar Cliente");
        return "form";
    }

    public String editar(Map<String, Object> model){

        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }




    //metodo guarda

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status){ //recibe el objeto cliente que viene con los datos del formuario
        if(result.hasErrors()){
            model.addAttribute("titulo","Formulario de Cliente");
            return "form";
        }else {
            clienteService.save(cliente); //guarda con el metodo sabe del DAO
            status.setComplete();
            return "redirect:listar";
        }
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id")Long id){

        if(id > 0){
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }

    

}
