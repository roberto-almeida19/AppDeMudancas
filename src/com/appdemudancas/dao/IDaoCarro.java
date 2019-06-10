package com.appdemudancas.dao;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.model.Carro;

public interface IDaoCarro {

	public void criarCarro(Carro carro) throws SQLException;

	public List<Carro> buscarCarro(Carro carro) throws SQLException;
	
	public void alterarCarro(Carro carro) throws SQLException;
	
	public void removeCarro(Carro carro) throws SQLException;

}
