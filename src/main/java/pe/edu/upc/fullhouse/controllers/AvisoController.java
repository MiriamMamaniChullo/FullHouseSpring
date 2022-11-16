package pe.edu.upc.fullhouse.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.fullhouse.entities.Aviso;
import pe.edu.upc.fullhouse.serviceinterface.IAvisoService;
import pe.edu.upc.fullhouse.serviceinterface.IRoomService;

@Controller
@RequestMapping("/aaviso")
public class AvisoController {

	@Autowired
	private IAvisoService avisoService;
	
	@Autowired
	private IRoomService roomService;
	
	@GetMapping("/new")
	public String newAviso(Model model) {
		model.addAttribute("a", new Aviso());
		model.addAttribute("listaHabitacion", roomService.list());
		return "Aviso/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveAvisos(@Valid Aviso av, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "Aviso/frmRegistro";
		} else {
			avisoService.insert(av);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/aaviso/list";
		}
	} 
	
	@GetMapping("/list")
	public String listAvisos(Model model) {
		try {
			model.addAttribute("listaAviso", avisoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "Aviso/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteAvisos(Map<String, Object> model, @RequestParam(value= "id") Integer id) {
		try {
			if (id != null && id > 0) {
				avisoService.delete(id);
				model.put("listaAviso", avisoService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "Aviso/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateAviso(@PathVariable int id, Model model) {
		Optional<Aviso> objAvi = avisoService.listId(id);
		model.addAttribute("av", objAvi.get());
		model.addAttribute("listaHabitacion", roomService.list());
		return "Aviso/frmActualiza";
	}
	
	@PostMapping("/update") 
	public String updateAviso(Aviso a) {
		avisoService.update(a);
		return "redirect:/aaviso/list";
	}
}

