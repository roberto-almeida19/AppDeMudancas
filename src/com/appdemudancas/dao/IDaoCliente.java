package com.appdemudancas.dao;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.model.Cliente;

public interface IDaoCliente {
	
	public void criarCliente(Cliente cliente) throws SQLException;

	public List<Cliente> buscarCliente(Cliente cliente) throws SQLException;
	
	public void alterarCliente(Cliente cliente) throws SQLException;
	
	public void removeCliente(Cliente cliente) throws SQLException;
}
