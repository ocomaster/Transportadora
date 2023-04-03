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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	public IClienteService clienteService;
	
	
	
	//Funcion que envia a la vista Listar para listar los clientes
	@RequestMapping(value = {"/listarClientes", "/"}, method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		
		return "listarClientes";
		
	}
	
	@RequestMapping(value = "/formCliente")
	public String crear(Map<String, Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "formCliente";
		}
	
	@RequestMapping(value = "/formCliente", method =RequestMethod.POST)
	public String guardar(@Valid Cliente cliente,BindingResult result, Model model) {
		
		//If condicion de retorno en caso de detectar alguna inconsistencia con las validaciones con la ayuda de BindingResult
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente retornado");
			return "formCliente";
		}
		
		clienteService.save(cliente);
		return "redirect:/listarClientes";
		
		}
	@RequestMapping(value = "formCliente/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = null;
		
		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				return "redirect:/listarClientes";
			}
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		
		return "formCliente";
		
	}
	
	
	@RequestMapping(value = "eliminarCliente/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		
		Cliente cliente = clienteService.findOne(id);
		
		if (id > 0 ) {
			clienteService.delete(id);
		}
		return "redirect:/listarClientes";
	}
	
	
	
	
}
