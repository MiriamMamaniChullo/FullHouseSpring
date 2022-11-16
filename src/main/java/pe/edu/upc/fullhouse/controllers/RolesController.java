package pe.edu.upc.fullhouse.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.fullhouse.entities.Roles;
import pe.edu.upc.fullhouse.serviceinterface.IRolesService;
import pe.edu.upc.fullhouse.serviceinterface.IUsuariosService;

@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private IRolesService rService;
	@Autowired
	private IUsuariosService uService;

	@GetMapping("/nuevo")
	public String newRole(Model model) {
		model.addAttribute("r", new Roles());
		model.addAttribute("listaUsuarios", uService.list());
		return "role/role";		
	}

	@PostMapping("/guardar")
	public String registrarRole(@Valid Roles objTel, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "role/role";
		} else {
			rService.insert(objTel);
			model.addAttribute("mensaje", "Se guardó correctamente");
			// status.setComplete();
			return "redirect:/roles/listar";
		}
	}

	@GetMapping("/listar")
	public String listarRoles(Model model) {
		try {
			model.addAttribute("listaRoles", rService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/role/listaRole";
	}

}
