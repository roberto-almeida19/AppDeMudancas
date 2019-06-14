package com.appdemudancas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appdemudancas.model.Carro;
@Controller
public class CtrCarro {

	
	
	@RequestMapping(value = "listar/maquinas")
	public @ResponseBody Carro listarCarros() {
		System.out.println("ALÔ TESTE 123!");
		Carro carro = new Carro();
		carro.setAnoFabricacao(2010);
		carro.setCpfMotorista("277727272");
		return carro;
	}
	
}
