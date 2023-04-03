package com.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.entity.Puerto;
import com.springboot.app.models.service.IPuertoService;

@Controller
public class PuertoController {
	
	@Autowired
	public IPuertoService puertoService;
	
	
	@RequestMapping(value = "/listarPuertos", method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de puertos");
		model.addAttribute("puertos", puertoService.finAll());
		
		return "listarPuertos";
		
	}
	
	@RequestMapping(value = "/formPuerto")
	public String crear(Map<String, Object> model) {
		
		Puerto puerto = new Puerto();
		model.put("puerto", puerto);
		model.put("titulo", " formulario de puerto");
		
		return "formPuerto";
		
	}
	
	@RequestMapping(value = "/formPuerto",method = RequestMethod.POST)
	public String guardar(@Valid Puerto puerto, BindingResult result,Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de puertos retornado");
			return "formPuerto";
		}
		
		puertoService.save(puerto);
		return "redirect:/listarPuertos";
	}
	
	@RequestMapping(value = "/formPuerto/{id}")
	public String editar(@PathVariable (value = "id")Long id, Map<String, Object> model) {
		Puerto puerto = null;
		
		if (id > 0) {
			puertoService.findOne(id);
			if (puerto == null) {
				return "redirect:/listarPuertos";
			}
		}
		model.put("puerto", puerto);
		model.put("titulo", "Editar Puerto");
		
		return "formPuerto";
	}
	
	@RequestMapping(value = "eliminarPuerto/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		
		Puerto puerto = puertoService.findOne(id);
		
		if (id > 0 ) {
			puertoService.delete(id);
		}
		return "redirect:/listarPuertos";
		
	}
	
	
	

}
