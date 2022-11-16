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

import pe.edu.upc.fullhouse.entities.Student;
import pe.edu.upc.fullhouse.serviceinterface.IStudentService;
import pe.edu.upc.fullhouse.serviceinterface.IUniversidadService;

@Controller
@RequestMapping("/sstudents")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IUniversidadService universidadService;
	
	@GetMapping("/new")
	public String newStudent(Model model) {
		model.addAttribute("s", new Student());
		model.addAttribute("listaUniversidades", universidadService.list());
		return "student/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveStudent(@Valid Student st, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "student/frmRegistro";
		}else {
			studentService.insert(st);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/sstudents/list";
		}
	}
	
	@GetMapping("/list")
	public String listStudent(Model model) {
		try {
			model.addAttribute("listaEstudiantes", studentService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/student/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id != null && id > 0) {
				studentService.delete(id);
				model.put("listaEstudiantes", studentService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "student/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateStudent(@PathVariable int id, Model model) {
		Optional<Student>objStu=studentService.listId(id);
		model.addAttribute("st", objStu.get());
		model.addAttribute("listaUniversidades", universidadService.list());
		return "student/frmActualiza";
	}
	
	@PostMapping("/update")
	public String updateStudent(Student s) {
		studentService.update(s);
		return "redirect:/sstudents/list";
	}
}
