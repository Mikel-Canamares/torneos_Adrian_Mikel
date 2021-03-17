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

import com.antartyca.torneos_Adrian_Mikel.models.FederacionModel;
import com.antartyca.torneos_Adrian_Mikel.services.IFederacionService;

@Controller
public class FederacionController {
	
	
	@Autowired
	private IFederacionService federacionService;
	
	@RequestMapping(value = "/listFederation", method = RequestMethod.GET)
	public  String listFederation(Model model) {
		model.addAttribute("titulo", "Listado de federaciones");
		model.addAttribute("federaciones", federacionService.findAll());
		return "listFederation";
	}
	
	//Prueba para el postman
	@RequestMapping(value = "/listFederationData", method = RequestMethod.GET)
	public  @ResponseBody List<FederacionModel> listFederationData(Model model) {
		return federacionService.findAll();
	}
	
	@RequestMapping(value = "/formFederation")
	public String createFederation(Map<String, Object> model) {
		FederacionModel federacion = new FederacionModel();
		model.put("federacion", federacion);
		model.put("titulo", "Formulario de federacion");
		return "formFederation";
	}
	
	@RequestMapping(value = "/formFederation", method = RequestMethod.POST)
	public String saveFederation(@Valid FederacionModel federacion, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de federacion");
			return "formFederation";
		}
		
		federacionService.save(federacion);
		status.setComplete();
		return "redirect:listFederation";
	}
	

	
	@RequestMapping(value="/formFederation/{id}")
	public String editFederation(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		FederacionModel federacion = null;
		
		if(id > 0) {
			federacion = federacionService.findOne(id);
		} else {
			return "redirect:/listFederation";
		}
		model.put("federacion", federacion);
		model.put("titulo", "Editar federacion");
		return "formFederation";
	}
	

	@RequestMapping(value="/deleteFederation/{id}")
	public String deleteFederation(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			federacionService.delete(id);
		}
		return "redirect:/listFederation";
	}
}
