package com.appdemudancas.controller;

import java.sql.SQLException;

import com.appdemudancas.dao.DaoEndereco;
import com.appdemudancas.dao.IDaoEndereco;
import com.appdemudancas.model.Endereco;

public class CtrEnderecoMotorista {

	IDaoEndereco daoEnderecoMotorista = new DaoEndereco();

	public void cadastrarEnderecoMotorista(Endereco enderecoMotorista) {
		try {
			daoEnderecoMotorista.criarEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Endereco pesquisarEndereco(Endereco enderecoMotorista) {

		Endereco enderecoMotoristaResultado = null;

		try {
			enderecoMotoristaResultado = daoEnderecoMotorista.buscarEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return enderecoMotoristaResultado;
	}

	public void alterarEndereco(Endereco enderecoMotorista) {
		try {
			daoEnderecoMotorista.alterarEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerEndereco(Endereco enderecoMotorista) {
		try {
			daoEnderecoMotorista.removeEnderecoMotorista(enderecoMotorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
