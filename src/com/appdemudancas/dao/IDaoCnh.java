package com.appdemudancas.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.appdemudancas.model.Cnh;

public interface IDaoCnh {

	public void criarCnh(Cnh cnh) throws SQLException, IOException;

	public Cnh buscarCnh(Cnh cnh) throws SQLException, IOException;
	
	public void alterarCnh(Cnh cnh) throws SQLException, IOException;
	
	public void removeCnh(Cnh cnh) throws SQLException;
	
}
