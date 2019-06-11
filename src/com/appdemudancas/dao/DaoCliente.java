package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdemudancas.model.Cliente;
import com.appdemudancas.model.Mudanca;

public class DaoCliente implements IDaoCliente {

	@Override
	public void criarCliente(Cliente cliente) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();
		String query = "INSERT INTO cliente("
				+ "cpf,nome,telefone,data_nascimento,email,"
				+ "senha,data_cadastro,"
				+ "enderecoCodigo_endereco) "
				+ "VALUES(?,?,?,?,?,?,?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cliente.getCpf());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getTelefone());
		pstm.setDate(4, new java.sql.Date(	cliente.getData_nascimento().getTime()));
		pstm.setString(5, cliente.getEmail());
		pstm.setString(6, cliente.getSenha());
		pstm.setDate(7, new java.sql.Date(
				cliente.getData_cadastro().getTime()));
		pstm.setInt(8, cliente.getEndereco().getCodigo());

		pstm.executeUpdate();

		con.close();

	}

	@Override
	public List<Cliente> buscarCliente(Cliente cliente) throws SQLException {

		ResultSet resultado = gerarResultSet(cliente);
		
		List<Cliente> listaResultados = resultSetParaList(resultado);
		
		return listaResultados;
	}

	private List<Cliente> resultSetParaList(ResultSet resultado) throws SQLException {
		List<Cliente> listaResultados = new ArrayList<>();

		while (resultado.next()) {

			Cliente auxCliente = new Cliente();
			Mudanca auxMudanca = new Mudanca();
			
			auxCliente.setCpf(resultado.getString("cpf"));
			
			auxCliente.setNome(resultado.getString("nome"));
			
			auxCliente.setTelefone(resultado.getString("telefone"));
			
			auxCliente.setData_nascimento(
					new java.util.Date(
							resultado.getDate("data_nascimento").getTime()));
			
			auxCliente.setEmail(resultado.getString("email"));
			
			auxCliente.setSenha(resultado.getString("senha"));
			
			auxCliente.setData_cadastro(
					new java.util.Date(
							resultado.getDate("data_cadastro").getTime()));
			
			auxCliente.getEndereco().setCodigo(
					resultado.getInt("endereco_clienteCodigo_endereco"));
			//TODO Refazer o model
			auxMudanca.setCliente(auxCliente);
			
			auxCliente.setMudanca(new DaoMudanca().buscarMudanca(auxMudanca));
			
			
			listaResultados.add(auxCliente);

		}
		return listaResultados;
	}

	private ResultSet gerarResultSet(Cliente cliente) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM cliente WHERE " 
				+ "cliente.cpf=? OR " 
				+ "cliente.nome=? OR "
				+ "cliente.telefone=? OR " 
				+ "cliente.data_nascimento=? OR " 
				+ "cliente.email=? OR "
				+ "cliente.data_cadastro=? OR " 				
				+ "cliente.endereco_clienteCodigo_endereco=?;";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cliente.getCpf());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getTelefone());
		pstm.setDate(4, 
				new java.sql.Date(cliente.getData_nascimento().getTime()));
		pstm.setString(5, cliente.getEmail());
		pstm.setDate(6, 
				new java.sql.Date(cliente.getData_cadastro().getTime()));
		pstm.setInt(7, cliente.getEndereco().getCodigo());

		
		ResultSet resultado = pstm.executeQuery();

		con.close();
		return resultado;
	}

	@Override
	public void alterarCliente(Cliente cliente) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE Cliente SET cpf = ?, nome = ?, telefone = ?, data_nascimento = ?, email = ?, data_cadastro = ?"
						+ "WHERE cpf = ?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cliente.getCpf());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getTelefone());
		pstm.setDate(4, (Date) cliente.getData_nascimento());
		pstm.setString(5, cliente.getEmail());
		pstm.setDate(6, (Date) cliente.getData_cadastro());
	}

	@Override
	public void removeCliente(Cliente cliente) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "DELETE FROM tabela WERE cpf = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cliente.getCpf());
		
		pstm.executeUpdate();
		
		con.close();
	}

}