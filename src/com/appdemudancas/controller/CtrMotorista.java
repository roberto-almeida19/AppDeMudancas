package com.appdemudancas.controller;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.dao.DaoMotorista;
import com.appdemudancas.dao.IDaoMotorista;
import com.appdemudancas.model.Motorista;

public class CtrMotorista {

	IDaoMotorista daoMotorista = new DaoMotorista();

	public void cadastrarMotorista(Motorista motorista) {
		try {
			daoMotorista.criarMotorista(motorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Motorista> pesquisarMotorista(Motorista motorista) {

		List<Motorista> listResultado = null;

		try {
			listResultado = daoMotorista.buscarMotorista(motorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listResultado;
	}

	public List<Motorista> pesquisarTodosMotorista() {
		List<Motorista> listResultado = null;

		try {
			listResultado = daoMotorista.buscarTodosMotorista();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listResultado;
	}

	public void alterarMotorista(Motorista motorista) {
		try {
			daoMotorista.alterarMotorista(motorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerMotorista(Motorista motorista) {
		try {
			daoMotorista.removeMotorista(motorista);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
