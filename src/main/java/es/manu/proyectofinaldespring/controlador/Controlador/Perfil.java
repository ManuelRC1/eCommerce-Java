package es.manu.proyectofinaldespring.controlador.Controlador;


import es.manu.proyectofinaldespring.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Perfil {

    @Autowired
    ClienteService clienteServicio;

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
