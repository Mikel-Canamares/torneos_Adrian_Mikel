package com.antartyca.torneos_Adrian_Mikel.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.antartyca.torneos_Adrian_Mikel.models.JugadorModel;
import com.antartyca.torneos_Adrian_Mikel.services.IJugadorService;


@Controller
@SessionAttributes("jugador")
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	
	@RequestMapping(value = "/listPlayer", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de jugadores");
		model.addAttribute("jugadores", jugadorService.findAll());
		return "listPlayer";
	}
	
	@RequestMapping(value = "/formPlayer")
	public String crear(Map<String, Object> model) {
		JugadorModel jugador = new JugadorModel();
		model.put("jugador", jugador);
		model.put("titulo", "Formulario de Jugador");
		return "formPlayer";
	}
	
	
	@RequestMapping(value = "/formPlayer", method = RequestMethod.POST)
	public String guardar(@Valid JugadorModel jugador, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Jugador");
			return "formPlayer";
		}
		
		jugadorService.save(jugador);
		status.setComplete();
		return "redirect:listPlayer";
	}
	
	
	
	@RequestMapping(value="/formPlayer/{id_jugador}")
	public String editar(@PathVariable(value="id_jugador") Integer id, Map<String, Object> model) {
		
		JugadorModel jugador = null;
		
		if(id > 0) {
			jugador = jugadorService.findOne(id);
		} else {
			return "redirect:/listPlayer";
		}
		model.put("jugador", jugador);
		model.put("titulo", "Editar Jugador");
		model.put("boton", "Editar jugador");
		return "formPlayer";
	}
	

	@RequestMapping(value="/deletePlayer/{id}")
	public String eliminar(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			jugadorService.delete(id);
		}
		return "redirect:/listPlayer";
	}
	
}
