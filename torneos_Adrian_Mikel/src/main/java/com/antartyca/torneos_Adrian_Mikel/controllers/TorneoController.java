package com.antartyca.torneos_Adrian_Mikel.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;
import com.antartyca.torneos_Adrian_Mikel.models.TorneoModel;
import com.antartyca.torneos_Adrian_Mikel.services.IEquipoService;
import com.antartyca.torneos_Adrian_Mikel.services.ITorneoService;



@Controller
public class TorneoController {
	
	private static final Logger log = LoggerFactory.getLogger(TorneoController.class);

	@Autowired
	private ITorneoService torneoService;
	
	@Autowired
	private IEquipoService equipoService;
	
	@RequestMapping(value = "/listTournament", method = RequestMethod.GET)
	public  String listTournament(Model model) {
		model.addAttribute("titulo", "Listado de torneos");
		model.addAttribute("torneos", torneoService.findAll());
//		String nombres = " ";
//		List<EquipoModel> equipos = equipoService.findAll();
//		for (EquipoModel equipo : equipos) {
//			nombres = nombres + equipo.getNombre();
//		}
//		model.addAttribute("equipos", nombres);
		
		String nombres = "";
		
		return "listTournament";
	}
	

	
	@RequestMapping(value = "/formTournament")
	public String createTournament(Map<String, Object> model) {
		TorneoModel torneo = new TorneoModel();
		model.put("torneo", torneo);
		model.put("titulo", "Formulario de Torneo");
		return "formTournament";
	}
	
	@RequestMapping(value = "/formTournament", method = RequestMethod.POST)
	public String saveTournament(@Valid @ModelAttribute("torneo") TorneoModel torneo, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Torneo");
			return "formTournament";
		}
		
		torneoService.save(torneo);
		status.setComplete();
		return "redirect:listTournament";
	}
	

	
	@RequestMapping(value="/formTournament/{id}")
	public String editTournament(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		TorneoModel torneo = null;
		
		if(id > 0) {
			torneo = torneoService.findOne(id);
		} else {
			return "redirect:/listTournament";
		}
		model.put("torneo", torneo);
		model.put("titulo", "Editar Torneo");
		return "formTournament";
	}
	

	@RequestMapping(value="/deleteTournament/{id}")
	public String deleteTournament(@PathVariable(value="id") Integer id) {
		
		if(id > 0) {
			torneoService.delete(id);
		}
		return "redirect:/listTournament";
	}
	
	@RequestMapping(value="/formTournamentTeam/{id}")
	public String editTournamentTeam(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		
		TorneoModel torneo = null;
		
		if(id > 0) {
			torneo = torneoService.findOne(id);
		} else {
			return "redirect:/listTournament";
		}
		model.put("titulo", "Editar equipos del torneo");
		model.put("torneo", torneo);
		model.put("equipos", equipoService.findAll());
		return "formTournamentTeam";
	}
	
	
	@RequestMapping(value = "/addTeamTournament/{tournamentId}/team")
    public String addTeamTournament(@PathVariable("tournamentId") Integer tournamentId,
                                   @RequestParam("teamId") Integer teamId){

		EquipoModel equipo = equipoService.findOne(teamId);
        TorneoModel torneo = torneoService.findOne(tournamentId);
        
        if (torneo!=null){
            torneo.getEquipos().add(equipo);
            torneoService.save(torneo);
        }
        return "redirect:/listTournament";
    }
	
	
	
	
}
