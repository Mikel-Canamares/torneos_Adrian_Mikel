package com.antartyca.torneos_Adrian_Mikel.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.antartyca.torneos_Adrian_Mikel.models.EmpleadoModel;
import com.antartyca.torneos_Adrian_Mikel.services.IEmpleadoService;


@Controller
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@RequestMapping(value = "/listEmployer", method = RequestMethod.GET)
	public  String listEmployer(Model model) {
		model.addAttribute("titulo", "Listado de empleados");
		model.addAttribute("empleados", empleadoService.findAll());
		return "listEmployer";
	}
	
	//Prueba para el postman
	@RequestMapping(value = "/listEmployerData", method = RequestMethod.GET)
	public  @ResponseBody List<EmpleadoModel> listEmployerData(Model model) {
		return empleadoService.findAll();
	}
	
	@RequestMapping(value = "/formEmployer")
	public String createEmployer(Map<String, Object> model) {
		EmpleadoModel empleado = new EmpleadoModel();
		model.put("empleado", empleado);
		model.put("titulo", "Formulario de empleado");
		return "formEmployer";
	}
	
	@RequestMapping(value = "/formEmployer", method = RequestMethod.POST)
	public String saveEmployer(@Valid @ModelAttribute("empleado") EmpleadoModel empleado, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de empleado");
			return "formEmployer";
		}
		
		empleadoService.save(empleado);
		status.setComplete();
		return "redirect:listEmployer";
	}
	

	
	@RequestMapping(value="/formEmployer/{id}")
	public String editEmployer(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		EmpleadoModel empleado = null;
		
		if(id > 0) {
			empleado = empleadoService.findOne(id);
		} else {
			return "redirect:/listEmployer";
		}
		model.put("empleado", empleado);
		model.put("titulo", "Editar empleado");
		return "formEmployer";
	}
	

	@RequestMapping(value="/deleteEmployer/{id}")
	public String deleteEmployer(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			empleadoService.delete(id);
		}
		return "redirect:/listEmployer";
	}
}
