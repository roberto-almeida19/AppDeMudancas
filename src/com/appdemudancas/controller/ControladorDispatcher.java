package com.appdemudancas.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appdemudancas.model.Carro;
import com.appdemudancas.model.Cliente;
import com.appdemudancas.model.Motorista;
import com.appdemudancas.model.Mudanca;

@Controller
public class ControladorDispatcher {
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String index(Model model) {	
		
				
		return "ListarClientes";
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
	
	@ResponseBody
	@RequestMapping(value = "listar/carros")
	public Carro listarCarros() {
		System.out.println("ALÔ TESTE 123!");
		Carro carro = new Carro();
		carro.setAnoFabricacao(2010);
		carro.setCpfMotorista("277727272");
		return carro;
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
				
		return "CadastroCliente";
	}
	
	@RequestMapping(value= "cadastrarCliente", method=RequestMethod.POST)
	public String receberCadastroCliente( Cliente cliente,
			Model model) {
		
		CtrCliente ctrCliente = new CtrCliente();
		
		ctrCliente.cadastrarCliente(cliente);
		
		model.addAttribute("msg","Cadastro realizado");
		
		return "CadastroCliente";
	}
	
	@RequestMapping(value= "/CadastroMudanca", method=RequestMethod.GET)
	public String carregarCadastroMudanca1(Model model) {
		model.addAttribute("cadastroMudanca", new Mudanca());
		return "CadastroMudanca";
	}
	
	@RequestMapping(value= "cadastrarMudanca", method=RequestMethod.POST)
	public String cadastroMudanca(Mudanca mudanca,
			Model model) {
		
		CtrMudanca ctrMudanca = new CtrMudanca();
		
		ctrMudanca.cadastrarMudanca(mudanca);
		
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
