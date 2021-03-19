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

import com.antartyca.torneos_Adrian_Mikel.models.CiudadModel;
import com.antartyca.torneos_Adrian_Mikel.services.ICiudadService;

@Controller
public class CiudadController {
	
	@Autowired
	private ICiudadService ciudadService;
	
	@RequestMapping(value = "/listCity", method = RequestMethod.GET)
	public  String listCity(Model model) {
		model.addAttribute("titulo", "Listado de ciudades");
		model.addAttribute("ciudades", ciudadService.findAll());
		return "listCity";
	}	
	
	@RequestMapping(value = "/formCity")
	public String createCity(Map<String, Object> model) {
		CiudadModel ciudad = new CiudadModel();
		model.put("ciudad", ciudad);
		model.put("titulo", "Formulario de ciudad");
		return "formCity";
	}
	
	@RequestMapping(value = "/formCity", method = RequestMethod.POST)
	public String saveCity(@Valid @ModelAttribute("ciudad") CiudadModel ciudad, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de ciudad");
			return "formCity";
		}
		
		ciudadService.save(ciudad);
		status.setComplete();
		return "redirect:listCity";
	}
	

	
	@RequestMapping(value="/formCity/{id}")
	public String editCity(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		CiudadModel ciudad = null;
		
		if(id > 0) {
			ciudad = ciudadService.findOne(id);
		} else {
			return "redirect:/listCity";
		}
		model.put("ciudad", ciudad);
		model.put("titulo", "Editar ciudad");
		return "formCity";
	}
	

	@RequestMapping(value="/deleteCity/{id}")
	public String deleteCity(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			ciudadService.delete(id);
		}
		return "redirect:/listCity";
	}
}
