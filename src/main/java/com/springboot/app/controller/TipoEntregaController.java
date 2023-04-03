package com.springboot.app.controller;

import java.lang.reflect.Method;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.entity.TipoEntrega;
import com.springboot.app.models.service.ITipoEntregaService;
import com.springboot.app.models.service.TipoEntregaServiceImpl;

@Controller
public class TipoEntregaController {
	
	@Autowired
	public ITipoEntregaService tipoEntregaService;
	
	@RequestMapping(value = "/listarTipoEntregas", method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Tipos de Entregas");
		model.addAttribute("tipoEntregas", tipoEntregaService.findAll());
		
		return "listarTipoEntregas";
	}
	
	@RequestMapping(value = "/formTipoEntrega")
	public String crear(Map<String, Object>model) {
	
		TipoEntrega tipoEntrega = new TipoEntrega();
		model.put("tipoEntrega", tipoEntrega);
		model.put("titulo", "Formulario Tipo Entrega");
		
		return "formTipoEntrega";
		
	}
	
	@RequestMapping(value = "/formTipoEntrega",method = RequestMethod.POST)
	public String guardar(@Valid TipoEntrega tipoEntrega, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Tipo Entrega retornado");
			return "formTipoEntrega";
		}
		
		tipoEntregaService.save(tipoEntrega);
		return "redirect:/listarTipoEntregas";
		
	}
	
	@RequestMapping(value = "formTipoEntrega/{id}")
	public String editar(@PathVariable(value = "id")Long id, Map<String, Object> model) {
		TipoEntrega tipoEntrega = null;
		
		if (id > 0) {
			tipoEntrega=  tipoEntregaService.findOne(id);
			if (tipoEntrega == null) {
				return "redirect:/listarTipoEntregas";
			}
		}
		
		model.put("tipoEntrega", tipoEntrega);
		model.put("titulo", "Editar Tipo Entrega");
		
		return "formTipoEntrega";
	}
	
	@RequestMapping(value = "eliminarTipoEntrega/{id}")
	public String delete(@PathVariable(value = "id")Long id) {
		
		TipoEntrega tipoEntrega = tipoEntregaService.findOne(id);
		
		if (id > 0) {
			tipoEntregaService.delete(id);
		}
		return "redirect:/listarTipoEntregas";
		
	}
	
	
	
	
	
	
	
	

}
