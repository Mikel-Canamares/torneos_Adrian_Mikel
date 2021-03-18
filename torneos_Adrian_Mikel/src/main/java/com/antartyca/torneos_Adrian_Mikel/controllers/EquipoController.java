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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;
import com.antartyca.torneos_Adrian_Mikel.services.IEquipoService;

@Controller
//@SessionAttributes("equipo")
public class EquipoController {

	@RequestMapping(value = "/")
	public String homePage()
	{
		return "homePage";
	}
	
	
	@Autowired
	private IEquipoService equipoService;
	
	@RequestMapping(value = "/listTeam", method = RequestMethod.GET)
	public  String listTeam(Model model) {
		model.addAttribute("titulo", "Listado de equipos");
		model.addAttribute("equipos", equipoService.findAll());
		return "listTeam";
	}
	
	//Prueba para el postman
	@RequestMapping(value = "/listTeamData", method = RequestMethod.GET)
	public  @ResponseBody List<EquipoModel> listTeamData(Model model) {
		return equipoService.findAll();
	}
	
	@RequestMapping(value = "/formTeam")
	public String createTeam(Map<String, Object> model) {
		EquipoModel equipo = new EquipoModel();
		model.put("equipo", equipo);
		model.put("titulo", "Formulario de Equipo");
		return "formTeam";
	}
	
	@RequestMapping(value = "/formTeam", method = RequestMethod.POST)
	public String saveTeam(@Valid @ModelAttribute("equipo") EquipoModel equipo, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Equipo");
			return "formTeam";
		}
		
		equipoService.save(equipo);
		status.setComplete();
		return "redirect:listTeam";
	}
	

	
	@RequestMapping(value="/formTeam/{id}")
	public String editTeam(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		EquipoModel equipo = null;
		
		if(id > 0) {
			equipo = equipoService.findOne(id);
		} else {
			return "redirect:/listTeam";
		}
		model.put("equipo", equipo);
		model.put("titulo", "Editar Equipo");
		return "formTeam";
	}
	

	@RequestMapping(value="/deleteTeam/{id}")
	public String deleteTeam(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			equipoService.delete(id);
		}
		return "redirect:/listTeam";
	}
	
}
