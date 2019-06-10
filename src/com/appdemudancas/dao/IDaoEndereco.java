package com.appdemudancas.dao;

import java.sql.SQLException;

import com.appdemudancas.model.Endereco;


public interface IDaoEndereco {

	public void criarEndereco(Endereco endereco) throws SQLException;

	public Endereco buscarEndereco(Endereco endereco) throws SQLException;
	
	public void alterarEndereco(Endereco endereco) throws SQLException;
	
	public void removeEndereco(Endereco endereco) throws SQLException;
	
}
