package com.ejemplo.thymeleaf.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Controlador de interfaz de usuario
// - Recibe la solicitud del usuario
// - Invoca servicios de lógica de negocio
// - Obtiene / Construye el modelo que se intercambia con la Vista
// - Selecciona la vista a mostar

@Controller
public class FormularioController {

    // Modelo -- usado para intercambiar datos con la vista
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UsuarioModel {

        String nombre;
        String email;
        String direccion;

    }
   
    @GetMapping("/formulario")
    public String muestraFormulario(ModelMap model) {

        // invoca servicios de lógica de negocio
        // N/A

        // construye el modelo
        UsuarioModel usuario = new UsuarioModel();
        model.addAttribute("usuario", usuario);

        // selecciona la vista a mostrar        
        return "/formulario/index";
    }

    @PostMapping("/formulario/grabar")
    public ModelAndView procesaFormulario(ModelMap model, UsuarioModel usuario) {

        // obtiene la información del formulario
        System.out.println("nombre : " + usuario.getNombre());
        System.out.println("email  : " + usuario.getEmail());
        System.out.println("direccion : " + usuario.getDireccion());

        // invoca servicios de lógica de negocio
        // N/A

        // construye el modelo
        // N/A

        // selecciona la vista a mostrar  
        // --> redirige en lugar de mostrar
        return new ModelAndView("redirect:/formulario", model);
    }


}
