package pe.edu.upc.fullhouse.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.fullhouse.entities.Usuarios;
import pe.edu.upc.fullhouse.serviceinterface.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuariosService uService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/nuevo")
	public String newUser(Model model) {
		model.addAttribute("u", new Usuarios());
		return "user/usuario";
	}

	@PostMapping("/guardar")
	public String registrarUser(@Valid Usuarios objTel, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "user/usuario";
		} else {
			String p = objTel.getPassword();
			String pE = passwordEncoder.encode(p);
			Usuarios us = new Usuarios();
			us.setUsername(objTel.getUsername());
			us.setEnabled(objTel.getEnabled());
			us.setPassword(pE);

			uService.insert(us);
			model.addAttribute("mensaje", "Se guardó correctamente");
			// status.setComplete();
			return "redirect:/usuarios/listar";
		}
	}

	@GetMapping("/listar")
	public String listarUsuarios(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/user/listaUsuario";
	}

}
