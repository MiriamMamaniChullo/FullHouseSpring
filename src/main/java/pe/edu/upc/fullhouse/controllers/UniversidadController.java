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

import pe.edu.upc.fullhouse.entities.Universidad;
import pe.edu.upc.fullhouse.serviceinterface.IDistrictService;
import pe.edu.upc.fullhouse.serviceinterface.IUniversidadService;

@Controller
@RequestMapping("/university")
public class UniversidadController {

	@Autowired
	private IUniversidadService universidadService;
	
	@Autowired
	private IDistrictService districtService;

	@GetMapping("/new")
	public String newUniversidad(Model model) {
		model.addAttribute("u", new Universidad());
		model.addAttribute("listaDistritos", districtService.list());
		return "uni/frmRegistro";
	}

	@PostMapping("/save")
	public String saveUniversidad(@Valid Universidad un, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "uni/frmRegistro";
		} else {
			universidadService.insert(un);
			model.addAttribute("mensaje", "se registró correctamente");
			return "redirect:/university/list";
		}

	}
	@GetMapping("/list")
	public String listUniversidad(Model model) {
		try {
			model.addAttribute("listaUniversidades", universidadService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "uni/frmLista";
	}
	@RequestMapping("/delete")
	public String deleteUniversidad(Map<String, Object> model, @RequestParam(value="id") Integer id ) {
		try {
			if(id!=null && id>0) {
				universidadService.delete(id);
				model.put("listaUniversidades", universidadService.list());
			}
			
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "uni/frmLista";
	}
	@RequestMapping("/goupdate/{id}")
	public String goUpdateUniversidad(@PathVariable int id, Model model) {
		
		Optional<Universidad>objUniv=universidadService.listId(id);
		model.addAttribute("un", objUniv.get());
		model.addAttribute("listaDistritos", districtService.list());
		return "uni/frmActualiza";
		
	}
	
}
