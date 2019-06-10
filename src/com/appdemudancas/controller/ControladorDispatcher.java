package com.appdemudancas.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appdemudancas.model.Carro;
import com.appdemudancas.model.Cliente;
import com.appdemudancas.model.Motorista;
import com.appdemudancas.model.Mudanca;

@Controller
public class ControladorDispatcher {
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String index(Model model) {	
		
				
		return "Index";
	}
	
	@RequestMapping(value= {"/LoginMotorista"}, method=RequestMethod.GET)
	public String loginMotorista(Model model) {	
		
		model.addAttribute("motorista", new Motorista());
				
		return "LoginMotorista";
	}
	
	//motorista
	@RequestMapping(value= "/formularioMotorista", method=RequestMethod.GET)
	public String carregarFormularioMotorista(Model model) {
		
		model.addAttribute("motorista", new Motorista());
		
		return "formularioMotorista";
	}
	
	@RequestMapping(value= "/formularioMotorista", method=RequestMethod.POST)
	public String receberFormularioMotorista(			
			@ModelAttribute("motorista") Motorista motorista,
			Model model) {
		
		motorista.setData_cadastro(new Date());
		
		//CtrEnderecoMotorista ctrEnderecoMotorista = new CtrEnderecoMotorista();
		CtrCnh ctrCnh = new CtrCnh();
		CtrMotorista ctrMotorista = new CtrMotorista();
		
		//ctrEnderecoMotorista.cadastrarEnderecoMotorista(motorista.getEndereco_motorista());
		//ctrCnh.cadastrarCnh(motorista.getCnh());
		ctrMotorista.cadastrarMotorista(motorista);
		
		
		
		return "formularioMotorista";
	}
	
	@RequestMapping(value= "/ListarMotorista", method=RequestMethod.GET)
	public String carregarListarMotorista(Model model) {
		
		CtrMotorista ctrMotorista = new CtrMotorista();
		/*model.addAttribute("motoristas",
				ctrMotorista.pesquisarMotorista());
		*/
		return "ListarMotorista";
	}
	
	@RequestMapping(value= "/RemoverMotorista", method=RequestMethod.GET)
	public String removerMotorista(Motorista motorista) {
		
		CtrMotorista ctrMotorista = new CtrMotorista();
		ctrMotorista.removerMotorista(motorista);
		
		return "ListarMotorista";
	}
	
	@RequestMapping(value= "/CadastroCliente", method=RequestMethod.GET)
	public String carregarCadastroCliente(Model model) {
		
		
		model.addAttribute("cadastroCliente", new Cliente());
		
		return "CadastroCliente";
	}
	
	@RequestMapping(value= "/CadastroCliente", method=RequestMethod.POST)
	public String receberCadastroCliente(@ModelAttribute("cadastroCliente")Cliente parametroCliente,
			Model model) {
		System.out.println(parametroCliente.toString());
		
		return "CadastroCliente";
	}
	
	@RequestMapping(value= "/CadastroMudanca", method=RequestMethod.GET)
	public String carregarCadastroMudanca1(Model model) {
		model.addAttribute("cadastroMudanca", new Mudanca());
		return "CadastroMudanca";
	}
	
	@RequestMapping(value= "/CadastroMudanca", method=RequestMethod.POST)
	public String receberCadastroMudanca1(@ModelAttribute("cadastroMudanca1")Mudanca parametroMudanca,
			Model model) {
		System.out.println(parametroMudanca.toString());
		//System.out.println(parametroMudanca.getEndereco_final().getBairro());
		//System.out.println(parametroMudanca.getEndereco_inicial().getBairro());
		
		return "CadastroMudanca";
	}
	
	@RequestMapping(value= "/CadastroCarro", method=RequestMethod.GET)
	public String carregarCadastroCarro(Model model) {
		model.addAttribute("cadastroCarro", new Carro());
		return "CadastroCarro";
	}
	
	@RequestMapping(value= "/CadastroCarro", method=RequestMethod.POST)
	public String receberCadastroCarro(@ModelAttribute("cadastroCarro")Carro parametroCarro,
			Model model) {
		System.out.println(parametroCarro.toString());
		System.out.println(parametroCarro.getChassi());
		
		return "CadastroCarro";
}

}