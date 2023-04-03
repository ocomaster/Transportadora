package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app.models.dao.IClienteDao;
import com.springboot.app.models.entity.Entrega;
import com.springboot.app.models.service.ClienteServiceImpl;
import com.springboot.app.models.service.IClienteService;
import com.springboot.app.models.service.IPuertoService;
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

	
	@GetMapping("/factura/form")
	public String crear(Model model) {
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("productos", productoService.findAll());
		model.addAttribute("puertos", puertoService.finAll());
		model.addAttribute("entrega", new Entrega());
		
		return "factura/form";
	}
	
	@PostMapping()
	public String crearEntrega(@ModelAttribute Entrega entrega) {
		return "redirect:/factura/entrega";
	}

	
}
