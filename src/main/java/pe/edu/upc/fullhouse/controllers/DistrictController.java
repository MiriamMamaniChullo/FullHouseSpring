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

import pe.edu.upc.fullhouse.entities.District;
import pe.edu.upc.fullhouse.serviceinterface.IDistrictService;

@Controller
@RequestMapping("/pdistricts")
public class DistrictController {
	
	@Autowired
	private IDistrictService districtService;
	
	@GetMapping("/new")
	public String newDistrict(Model model) {
		model.addAttribute("d", new District());
		return  "distrito/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveDistrict(@Valid District di, BindingResult binRes,Model model) {
		if(binRes.hasErrors()) {
			return "distrito/frmRegistro";
		}else {
			districtService.insert(di);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/pdistricts/list";
		}
	}
	
	@GetMapping("/list")
	public String listDistrict(Model model) {
		try {
			model.addAttribute("listaDistritos", districtService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/distrito/frmLista";
		
	}
	@RequestMapping("/delete")
	public String deleteDistrict(Map<String, Object> model, @RequestParam(value="id" )Integer id) {
		try {
			if(id != null && id > 0) {
				districtService.delete(id);
				model.put("listaDistritos", districtService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		
		return "distrito/frmLista";
	}
	
	//va a llevar el objeto y lo va a mostrar en el formulario
	@RequestMapping("/goupdate/{id}")
	public String goUpdateDistrict(@PathVariable int id, Model model) {
		Optional<District>objDis=districtService.listId(id);
		model.addAttribute("di", objDis.get());
		return "distrito/frmActualiza";
	}
	
	
	//guardar los cambios
	@PostMapping("/update")
	public String updateDistrict(District d) {
		districtService.update(d);
		return"redirect:/pdistricts/list";
	}
}
