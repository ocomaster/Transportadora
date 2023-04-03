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

import com.springboot.app.models.dao.ITipoProductoDao;
import com.springboot.app.models.entity.TipoProducto;
import com.springboot.app.models.service.ITipoProductoService;

@Controller
public class TipoProductoController {

	@Autowired
	public ITipoProductoService productoService;
	
	@RequestMapping(value = {"/listarTipoProducto"}, method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "listado Tipo de Productos");
		model.addAttribute("tipoProducto", productoService.findAll());
		
		return "listarTipoProducto";
	}
	
	
	@RequestMapping(value = "/formTipoProducto")
	public String crear(Map<String, Object> model) {
		
		TipoProducto tipoProducto = new TipoProducto();
		model.put("tipoProducto",tipoProducto);
		model.put("titulo","Formulario producto");
		
		return "formTipoProducto";		
	}
	
	@RequestMapping(value = "/formTipoProducto", method = RequestMethod.POST)
	public String guardar(@Valid TipoProducto tipoProducto, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "formulario tipo producto retornado");
			return "formTipoProducto";
		}
		
		productoService.save(tipoProducto);
		return "redirect:/listarTipoProducto";
	}
	
	@RequestMapping(value = "formTipoProducto/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		TipoProducto tipoProducto = null;
		
		if (id > 0) {
			tipoProducto = productoService.findOne(id);
			if (tipoProducto == null) {
				return "redirect:/listarTipoProducto";
			}
		}
		
		model.put("tipoProducto" , tipoProducto);
		model.put("titulo", "Editar Tipo Producto");
		
		return "formTipoProducto";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "eliminarTipoProducto/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		TipoProducto tipoProducto = productoService.findOne(id);
		
		if (id > 0) {
			productoService.delete(id);
		}
		
		return "redirect:/listarTipoProducto";
	}
	
	
}
