package com.antartyca.torneos_Adrian_Mikel.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.antartyca.torneos_Adrian_Mikel.models.DepartamentoModel;
import com.antartyca.torneos_Adrian_Mikel.services.IDepartamentoService;

@Controller
public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService departamentoService;
	
	@RequestMapping(value = "/listDepartment", method = RequestMethod.GET)
	public  String listDepartment(Model model) {
		model.addAttribute("titulo", "Listado de departamentos");
		model.addAttribute("departamentos", departamentoService.findAll());
		return "listDepartment";
	}
	
	//Prueba para el postman
	@RequestMapping(value = "/listDepartmentData", method = RequestMethod.GET)
	public  @ResponseBody List<DepartamentoModel> listDepartmentData(Model model) {
		return departamentoService.findAll();
	}
	
	@RequestMapping(value = "/formDepartment")
	public String createDepartment(Map<String, Object> model) {
		DepartamentoModel departamento = new DepartamentoModel();
		model.put("departamento", departamento);
		model.put("titulo", "Formulario de departamento");
		return "formDepartment";
	}
	
	@RequestMapping(value = "/formDepartment", method = RequestMethod.POST)
	public String saveDepartment(@Valid DepartamentoModel departamento, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de departamento");
			return "formDepartment";
		}
		
		departamentoService.save(departamento);
		status.setComplete();
		return "redirect:listDepartment";
	}
	

	
	@RequestMapping(value="/formDepartment/{id}")
	public String editDepartment(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		DepartamentoModel departamento = null;
		
		if(id > 0) {
			departamento = departamentoService.findOne(id);
		} else {
			return "redirect:/listDepartment";
		}
		model.put("departamento", departamento);
		model.put("titulo", "Editar departamento");
		return "formDepartment";
	}
	

	@RequestMapping(value="/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			departamentoService.delete(id);
		}
		return "redirect:/listDepartment";
	}
}
