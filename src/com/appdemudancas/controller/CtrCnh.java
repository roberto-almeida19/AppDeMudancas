package com.appdemudancas.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.appdemudancas.dao.DaoCnh;
import com.appdemudancas.dao.IDaoCnh;
import com.appdemudancas.model.Cnh;

public class CtrCnh {

	IDaoCnh daoCnh = new DaoCnh();

	public void cadastrarCnh(Cnh cnh) {
		try {
			daoCnh.criarCnh(cnh);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cnh pesquisarCnh(Cnh cnh) throws IOException {

		Cnh cnhResultado = null;

		try {
			cnhResultado = daoCnh.buscarCnh(cnh);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return cnhResultado;
	}

	public void alterarCnh(Cnh cnh) {
		try {
			daoCnh.alterarCnh(cnh);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removerCnh(Cnh cnh) {
		try {
			daoCnh.removeCnh(cnh);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
