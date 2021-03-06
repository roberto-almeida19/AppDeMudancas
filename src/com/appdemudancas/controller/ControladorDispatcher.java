package com.appdemudancas.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appdemudancas.model.Carro;
import com.appdemudancas.model.Cliente;
import com.appdemudancas.model.Endereco;
import com.appdemudancas.model.Motorista;
import com.appdemudancas.model.Mudanca;

@Controller
public class ControladorDispatcher {
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String index(Model model) {	
		return "Login";
	}
	@ResponseBody
	@RequestMapping(value= {"/loginMotorista"}, method=RequestMethod.GET)
	public String loginMotorista(String login, String pass) {	
		System.out.println(login+"  - "+pass);
		if ("admin".equals(login) && "1234".equals(pass)) {
			return "OK";
		}
		else return "NOK";
	}
	
	
	
	//motorista
	@RequestMapping(value= "/formularioMotorista", method=RequestMethod.GET)
	public String carregarFormularioMotorista(Model model) {
		
		
		return "indexMotorista";
	}
	
	@RequestMapping(value= "/formularioMotorista", method=RequestMethod.POST)
	public String receberFormularioMotorista(			
			@ModelAttribute("motorista") Motorista motorista,
			Model model) {
		
		motorista.setDataCadastro(new Date());
		
		//CtrEnderecoMotorista ctrEnderecoMotorista = new CtrEnderecoMotorista();
		CtrCnh ctrCnh = new CtrCnh();
		CtrMotorista ctrMotorista = new CtrMotorista();
		
		//ctrEnderecoMotorista.cadastrarEnderecoMotorista(motorista.getEndereco_motorista());
		//ctrCnh.cadastrarCnh(motorista.getCnh());
		ctrMotorista.cadastrarMotorista(motorista);
		
		
		
		return "formularioMotorista";
	}
	
	@ResponseBody
	@RequestMapping(value = "listar/clientes")
	public Cliente listarCarros() {
		Cliente cliente = new Cliente();
		cliente.setNome("Roberto Almeida");
		cliente.setCpf("47429468869");
		return cliente;
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
	
	@RequestMapping(value= "/CadastroMotorista", method=RequestMethod.GET)
	public String carregarCadastroMotorista() {
		return "CadastroMotorista";
	}
	
	
	
	
	
	@RequestMapping(value= "/CadastroCliente", method=RequestMethod.GET)
	public String carregarCadastroCliente() {
		return "CadastroCliente";
	}
	
	@RequestMapping(value= "cadastrarCliente", method=RequestMethod.POST)
	public String receberCadastroCliente( Cliente cliente,	Endereco endereco) {
		cliente.setEnderecoCliente(endereco);
		System.out.println(cliente.toString());
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
		System.out.println(parametroCarro.getPlaca());
		
		return "CadastroCarro";
}

}
