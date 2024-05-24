package com.ejemplo.thymeleaf.suma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumaController {

    // ruta /suma?a=10&b=20
    //
    @GetMapping("/suma")
    public String suma(
        Model model,
        @RequestParam(defaultValue = "0") Integer a,
        @RequestParam(defaultValue = "0") Integer b   
    ) {

        // llama a la logica de negocio
        int resultado = a + b;

        // Agregar el resultado al modelo compartido con la vista
        model.addAttribute("resultado", resultado);

        // muestra el template /suma/index.html
        return "/suma/index";
    }

}
