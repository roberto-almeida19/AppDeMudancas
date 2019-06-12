package com.appdemudancas.controller;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.dao.DaoCliente;
import com.appdemudancas.dao.IDaoCliente;
import com.appdemudancas.model.Cliente;

public class CtrCliente {
	
	private IDaoCliente daoCliente = new DaoCliente();
	
	public void cadastrarCliente(Cliente cliente) {
		try {
			daoCliente.criarCliente(cliente);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Cliente> pesquisarCliente(Cliente cliente) {

		List<Cliente> listResultado = null;

		try {
			listResultado = daoCliente.buscarCliente(cliente);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listResultado;
	}


	public void alterarCliente(Cliente cliente) {
		try {
			daoCliente.alterarCliente(cliente);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerCliente(Cliente cliente) {
		try {
			daoCliente.removeCliente(cliente);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
