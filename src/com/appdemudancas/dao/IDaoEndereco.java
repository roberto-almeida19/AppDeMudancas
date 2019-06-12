package com.appdemudancas.dao;

import java.sql.SQLException;

import com.appdemudancas.model.Endereco;


public interface IDaoEndereco {

	public void criarEnderecoCliente(Endereco enderecoCliente) throws SQLException;

	public Endereco buscarEnderecoCliente(Endereco enderecoCliente) throws SQLException;
	
	public void alterarEnderecoCliente(Endereco enderecoCliente) throws SQLException;
	
	public void removeEnderecoCliente(Endereco enderecoCliente) throws SQLException;
	
	
	
	public void criarEnderecoMotorista(Endereco enderecoMotorista) throws SQLException;

	public Endereco buscarEnderecoMotorista(Endereco enderecoMotorista) throws SQLException;
	
	public void alterarEnderecoMotorista(Endereco enderecoMotorista) throws SQLException;
	
	public void removeEnderecoMotorista(Endereco enderecoMotorista) throws SQLException;
	
	
	
	public void criarEnderecoMudança(Endereco enderecoMudanca) throws SQLException;

	public Endereco buscarEnderecoMudança(Endereco enderecoMudanca) throws SQLException;
	
	public void alterarEnderecoMudança(Endereco enderecoMudanca) throws SQLException;
	
	public void removeEnderecoMudança(Endereco enderecoMudanca) throws SQLException;
}
