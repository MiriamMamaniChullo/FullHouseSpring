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

import pe.edu.upc.fullhouse.entities.Room;
import pe.edu.upc.fullhouse.serviceinterface.IArrendadorService;
import pe.edu.upc.fullhouse.serviceinterface.IDistrictService;
import pe.edu.upc.fullhouse.serviceinterface.IRoomService;

@Controller
@RequestMapping("/rrooms")
public class RoomController {

	@Autowired
	private IRoomService roomService;
	
	@Autowired
	private IArrendadorService arrendadorService;
	
	@Autowired
	private IDistrictService districtService;
	
	@GetMapping("/new")
	public String newRoom(Model model) {
	
		model.addAttribute("r", new Room());
		model.addAttribute("listaArrendadores", arrendadorService.list());
		model.addAttribute("listaDistritos", districtService.list());
		return "Habitacion/frmRegistro";	
	}
	
	@PostMapping("/save")
	public String saveRoom(@Valid Room ro, BindingResult binRes, Model model ) {
		if(binRes.hasErrors()) {
			return "Habitacion/frmRegistro";
		} else {
			roomService.insert(ro);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/rrooms/list";
		}
		
	}
	
	@GetMapping("/list")
	public String listRoom(Model model) {
		try {
			model.addAttribute("listaHabitacion", roomService.list());
		} catch (Exception e) {
			model.addAttribute("Error", e.getMessage());
			// TODO: handle exception
		}
		return "Habitacion/frmLista";
	}
	
	
	
	@RequestMapping("/delete")
	public String deleteRoom(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id != null && id>0){
				roomService.delete(id);
				model.put("listaHabitacion", roomService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
		model.put("error", e.getMessage());
		}
		return "Habitacion/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateRoom(@PathVariable int id, Model model) {
		
		Optional<Room>objRo=roomService.listId(id);
		model.addAttribute("ro", objRo.get());
		model.addAttribute("listaArrendadores", arrendadorService.list());
		model.addAttribute("listaDistritos", districtService.list());
		return "Habitacion/frmActualiza";
	}
	
	@PostMapping("/update") 
	public String updateRoom(Room r) {
		roomService.update(r);		
		return "redirect:/rrooms/list";
	}
	
}
