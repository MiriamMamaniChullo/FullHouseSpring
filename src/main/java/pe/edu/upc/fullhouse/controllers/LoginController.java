package pe.edu.upc.fullhouse.controllers;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {

		if (principal != null) {
			return "redirect:/iinicio/inicio";
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en las credenciales: acceda nuevamente");
		}

		if (logout != null) {
			model.addAttribute("success", "Se ha cerrado su sesion");
		}

		return "login";
	}
}

