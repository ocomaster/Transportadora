package com.springboot.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.IClienteDao;
import com.springboot.app.models.entity.Entrega;
import com.springboot.app.models.service.ClienteServiceImpl;
import com.springboot.app.models.service.IClienteService;
import com.springboot.app.models.service.IEntregaService;
import com.springboot.app.models.service.IPuertoService;
import com.springboot.app.models.service.ITipoEntregaService;
import com.springboot.app.models.service.ITipoProductoService;
import com.springboot.app.models.service.IVehiculoService;

@Controller
public class EntregaController {
	
	@Autowired
	public IClienteService clienteService;
	@Autowired
	public IVehiculoService vehiculoService;
	@Autowired
	public ITipoProductoService productoService;
	@Autowired
	public IPuertoService  puertoService;
	
	@Autowired
	public ITipoEntregaService tipoEntregaService;
	
	@Autowired
	public IEntregaService entregaService;

	
	@GetMapping("/factura/form")
	public String crear(Model model) {
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("productos", productoService.findAll());
		model.addAttribute("puertos", puertoService.findAll());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		model.addAttribute("tipoEntregas", tipoEntregaService.findAll());
		Entrega entrega = new Entrega();
		model.addAttribute("entrega", entrega);
		
		
		model.addAttribute("entrega", new Entrega());
		
		return "factura/form";
	}
	
		@RequestMapping(value = "/factura/form", method = RequestMethod.POST)
		public String guardar(@Valid Entrega entrega, BindingResult result, Model model) {
			
			if(result.hasErrors()) {
				model.addAttribute("titulo", "formulario de entrega retornado");
				return "factura/form";
			}
			
			entregaService.save(entrega);
			return "redirect:/listarEntregas";
			
		}
		
		
	

	
}
