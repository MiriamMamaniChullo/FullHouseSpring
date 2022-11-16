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

import pe.edu.upc.fullhouse.entities.Interes;
import pe.edu.upc.fullhouse.serviceinterface.IAvisoService;
import pe.edu.upc.fullhouse.serviceinterface.IDistrictService;
import pe.edu.upc.fullhouse.serviceinterface.IInteresService;
import pe.edu.upc.fullhouse.serviceinterface.IStudentService;

@Controller
@RequestMapping("/iinteres")
public class InteresController {

	@Autowired
	private IInteresService interesService;

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IAvisoService avisoService;
	
	@Autowired
	private IDistrictService distritoService;

	@GetMapping("/new")
	public String newInteres(Model model) {
		model.addAttribute("i", new Interes());
		model.addAttribute("listaEstudiantes", studentService.list());
		model.addAttribute("listaAviso", avisoService.list());
		model.addAttribute("listaDistritos", distritoService.list());
		return "interes/frmRegistro";
	}

	@PostMapping("/save")
	public String saveInteres(@Valid Interes in, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "interes/frmRegistro";
		} else {
			interesService.insert(in);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/iinteres/list";
		}
	}

	@GetMapping("/list")
	public String listInteres(Model model) {
		try {
			model.addAttribute("listaInteres", interesService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/interes/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteInteres(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				interesService.delete(id);
				model.put("listaInteres", interesService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "interes/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateInteres(@PathVariable int id, Model model) {
		Optional<Interes> objInt = interesService.listId(id);
		model.addAttribute("in", objInt.get());
		model.addAttribute("listaEstudiantes", studentService.list());
		model.addAttribute("listaAviso", avisoService.list());
		model.addAttribute("listaDistritos", distritoService.list());
		return "interes/frmActualiza";
	}

	@PostMapping("/update")
	public String updateInteres(Interes i) {
		interesService.update(i);
		return "redirect:/iinteres/list";
	}
	
	@RequestMapping("/reporteInteres")
	public String interesCategory(Map<String,Object> model) {
		model.put("listaIntereses", interesService.interesCategory() );
		return "interes/reportes";
	}
}
