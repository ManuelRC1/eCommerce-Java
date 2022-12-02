package es.manu.proyectofinaldespring.controlador.Controlador;

import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ClienteService clienteService;



    @GetMapping("/register")
    public String GetregistroCliente(Model model) {
            model.addAttribute("cliente", new Cliente());
            return "register";

    }

    @PostMapping("/cliente")
    public String PostregistroCliente(Cliente cliente, BindingResult bindingResult, RedirectAttributes at) {
        if (bindingResult.hasErrors()){
            for (ObjectError error : bindingResult.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "register";
        }
        at.addFlashAttribute("msg", "Registro Guardado");
        clienteService.registro(cliente, passwordEncoder);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "login";
    }

    @PostMapping("/check")
    public String Postlogin(@RequestParam("correo") String correo, @RequestParam("contrasena") String codificado, HttpSession session) {
        Cliente cliente = clienteService.findByCorreo_electronico(correo);
        String passwdCode = cliente.getContrasena();
        if (passwordEncoder.matches(codificado, passwdCode)) {
            session.setAttribute("usuario", clienteService.findByCorreo_electronico(correo));
            return "principal";
        } else {
            return "redirect:/login";
        }
    }
}
