package com.appdemudancas.controller;

import java.sql.SQLException;

import com.appdemudancas.dao.DaoEnderecoMotorista;
import com.appdemudancas.dao.IDaoEndereco;
import com.appdemudancas.model.Endereco;

public class CtrEnderecoMotorista {

	IDaoEndereco daoEnderecoMotorista = new DaoEnderecoMotorista();

	public void cadastrarEnderecoMotorista(Endereco enderecoMotorista) {
		try {
			daoEnderecoMotorista.criarEndereco(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Endereco pesquisarEndereco(Endereco enderecoMotorista) {

		Endereco enderecoMotoristaResultado = null;

		try {
			enderecoMotoristaResultado = daoEnderecoMotorista.buscarEndereco(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return enderecoMotoristaResultado;
	}

	public void alterarEndereco(Endereco enderecoMotorista) {
		try {
			daoEnderecoMotorista.alterarEndereco(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerEndereco(Endereco enderecoMotorista) {
		try {
			daoEnderecoMotorista.removeEndereco(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
