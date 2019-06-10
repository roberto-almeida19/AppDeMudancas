package com.appdemudancas.dao;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.model.Motorista;

public interface IDaoMotorista {
	
	public void criarMotorista(Motorista motorista) throws SQLException;

	public List<Motorista> buscarMotorista(Motorista motorista) throws SQLException;
	
	public void alterarMotorista(Motorista motorista) throws SQLException;
	
	public void removeMotorista(Motorista motorista) throws SQLException;

}
