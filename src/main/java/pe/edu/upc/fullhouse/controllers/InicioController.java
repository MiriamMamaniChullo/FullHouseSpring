package pe.edu.upc.fullhouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/iinicio")
public class InicioController {
	
	@GetMapping("/inicio")
	public String newInicio(Model model) {
		return "Inicio/frmInicio";
	}
	
}
