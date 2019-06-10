package com.appdemudancas.dao;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.model.Mudanca;

public interface IDaoMudanca {

	public void criarMudanca(Mudanca mudanca) throws SQLException;

	public List<Mudanca> buscarMudanca(Mudanca mudanca) throws SQLException;
	
	public void alterarMudanca(Mudanca mudanca) throws SQLException;
	
	public void removeMudanca(Mudanca mudanca) throws SQLException;
	
}
