package com.appdemudancas.controller;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.dao.DaoMudanca;
import com.appdemudancas.dao.IDaoMudanca;
import com.appdemudancas.model.Mudanca;

public class CtrMudanca {

	private IDaoMudanca daoMudanca = new DaoMudanca();

	public void cadastrarMudanca(Mudanca mudanca) {
		try {
			daoMudanca.criarMudanca(mudanca);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Mudanca> pesquisarMudanca(Mudanca mudanca) {

		List<Mudanca> listResultado = null;

		try {
			listResultado = daoMudanca.buscarMudanca(mudanca);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listResultado;
	}

	public void alterarMudanca(Mudanca mudanca) {
		try {
			daoMudanca.alterarMudanca(mudanca);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerMudanca(Mudanca mudanca) {
		try {
			daoMudanca.removeMudanca(mudanca);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
