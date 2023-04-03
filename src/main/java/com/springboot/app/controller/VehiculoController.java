package com.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.IVehiculoDao;
import com.springboot.app.models.entity.Vehiculo;
import com.springboot.app.models.service.ITipoEntregaService;
import com.springboot.app.models.service.IVehiculoService;

@Controller
public class VehiculoController {

	@Autowired
	public IVehiculoService vehiculoService;
	
	@Autowired
	public ITipoEntregaService tipoEntregaService;

	@GetMapping("/listarVehiculos")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de vehiculos");
		model.addAttribute("tipoEntregas", tipoEntregaService.findAll());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		
		return "listarVehiculos";
		
	}
	
	@RequestMapping(value = "/formVehiculo")
	public String crear(Map<String, Object> model) {
		
		Vehiculo vehiculo = new Vehiculo();
		model.put("vehiculo", vehiculo);
		model.put("titulo", "Formulario de vehiculo");
		model.put("tipoEntregas", tipoEntregaService.findAll());
		
		return "formVehiculo";	
	}
	
	@RequestMapping(value = "/formVehiculo", method = RequestMethod.POST)
	public String guardar(@Valid Vehiculo vehiculo, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de vehiculo retornado");
			return  "formVehiculo";
		}
		
		vehiculoService.save(vehiculo);
		return "redirect:/listarVehiculos";
	}
	
	@RequestMapping(value = "/formVehiculo/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object>model) {
		Vehiculo vehiculo = null;
		
		if (id > 0) {
			vehiculo = vehiculoService.findOne(id);
			if (vehiculo == null) {
				return "redirect:/listarVehiculos";
			}
		}
		model.put("vehiculo", vehiculo);
		model.put("titulo", "Editar Vehiculo");
		
		return "formVehiculo";		
	}
	
	@RequestMapping(value = "eliminarVehiculo/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		
		Vehiculo vehiculo = vehiculoService.findOne(id);
		
		if (id > 0) {
			vehiculoService.delete(id);
		}
		return  "redirect:/listarVehiculos";
		
	}
	
	

	
}
