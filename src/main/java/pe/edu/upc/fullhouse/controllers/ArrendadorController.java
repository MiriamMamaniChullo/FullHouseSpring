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

import pe.edu.upc.fullhouse.entities.Arrendador;
import pe.edu.upc.fullhouse.serviceinterface.IArrendadorService;

@Controller
@RequestMapping("/aarrendador")
public class ArrendadorController {

	@Autowired
	private IArrendadorService arrendadorService;

	@GetMapping("/new")
	public String newArrendador(Model model) {
		model.addAttribute("a", new Arrendador());
		return "arrendador/frmRegistro";
	}

	@PostMapping("/save")
	public String saveArrendador(@Valid Arrendador ar, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "arrendador/frmRegistro";
		} else {
			arrendadorService.insert(ar);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/aarrendador/list";
		}
	}

	@GetMapping("/list")
	public String listArrendador(Model model) {
		try {
			model.addAttribute("listaArrendadores", arrendadorService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/arrendador/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteArrendador(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				arrendadorService.delete(id);
				model.put("listaArrendadores", arrendadorService.list());
			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "arrendador/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateArrendador(@PathVariable int id, Model model) {
		Optional<Arrendador> objAr = arrendadorService.listId(id);
		model.addAttribute("ar", objAr.get());
		return "arrendador/frmActualiza";
	}

	@PostMapping("/update")
	public String updateArrendador(Arrendador a) {
		arrendadorService.update(a);
		return "redirect:/aarrendador/list";
	}

	@RequestMapping("/Reporte1")
	public String MontoArrendador(Map<String, Object> model) {
		model.put("listaMontoArrendador", arrendadorService.MontoArrendador());
		return "arrendador/Reporte1";
	}

	@RequestMapping("/reporte3")
	public String arrendadorDistrito(Map<String, Object> model) {
		model.put("listaArrendadorDistrito", arrendadorService.arrendadorDistrito());
		return "arrendador/reporte3";
	}

	@RequestMapping("/reporte2")
	public String arrendadorFecha(Map<String, Object> model) {
		model.put("listaArrendadorFecha", arrendadorService.arrendadorFecha());
		return "arrendador/reporte2";
	}

}
