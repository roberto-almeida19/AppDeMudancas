package com.appdemudancas.controller;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.dao.DaoEnderecoMotorista;
import com.appdemudancas.dao.IDaoEnderecoMotorista;
import com.appdemudancas.model.EnderecoMotorista;

public class CtrEnderecoMotorista {

	IDaoEnderecoMotorista daoEnderecoMotorista = new DaoEnderecoMotorista();

	public void cadastrarEnderecoMotorista(EnderecoMotorista enderecoMotorista) {
		try {
			daoEnderecoMotorista.criarEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public EnderecoMotorista pesquisarEnderecoMotorista(EnderecoMotorista enderecoMotorista) {

		EnderecoMotorista enderecoMotoristaResultado = null;

		try {
			enderecoMotoristaResultado = daoEnderecoMotorista.buscarEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return enderecoMotoristaResultado;
	}

	public void alterarEnderecoMotorista(EnderecoMotorista enderecoMotorista) {
		try {
			daoEnderecoMotorista.alterarEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerEnderecoMotorista(EnderecoMotorista enderecoMotorista) {
		try {
			daoEnderecoMotorista.removeEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
