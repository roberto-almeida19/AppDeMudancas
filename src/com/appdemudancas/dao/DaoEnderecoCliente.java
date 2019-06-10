package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.appdemudancas.model.EnderecoCliente;

public class DaoEndereco implements IDaoEndereco {

	@Override
	public void criarEnderecoCliente(EnderecoCliente enderecoCliente) throws SQLException {
		
		Connection con = new ConnectionManager().getConnection();
		
		String query = "INSERT INTO endereco_cliente("
				+ "nome,bairro,numero,cidade,uf,complemento) "
				+ "VALUES(?,?,?,?,?,?);";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoCliente.getNome());
		pstm.setString(2, enderecoCliente.getBairro());
		pstm.setInt(3, enderecoCliente.getNumero());
		pstm.setString(4, enderecoCliente.getCidade());
		pstm.setString(5, enderecoCliente.getUf());
		pstm.setString(6, enderecoCliente.getComplemento());
		
		pstm.executeUpdate();
		
		con.close();
		

	}

	@Override
	public EnderecoCliente buscarEnderecoCliente(EnderecoCliente enderecoCliente) throws SQLException {
		
		ResultSet resultado = gerarResultSet(enderecoCliente);
		
		EnderecoCliente  auxEnderecoCliente = new EnderecoCliente();
		
		auxEnderecoCliente.setCodigo(resultado.getInt("codigo_endereco"));
		auxEnderecoCliente.setNome(resultado.getString("nome"));
		auxEnderecoCliente.setNome(resultado.getString("bairro"));
		auxEnderecoCliente.setCodigo(resultado.getInt("numero"));
		auxEnderecoCliente.setNome(resultado.getString("cidade"));
		auxEnderecoCliente.setNome(resultado.getString("uf"));
		auxEnderecoCliente.setNome(resultado.getString("complemento"));
		
		return auxEnderecoCliente;
	}

	private ResultSet gerarResultSet(EnderecoCliente enderecoCliente) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "SELECT * FROM endereco_cliente WHERE "
				+ "endereco_cliente.nome=? OR "
				+ "endereco_cliente.bairro=? OR "
				+ "endereco_cliente.numero=? OR "
				+ "endereco_cliente.cidade=? OR "
				+ "endereco_cliente.uf=? OR "
				+ "endereco_cliente.complemento=? OR "
				+ "endereco_cliente.codigo_endereco=?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoCliente.getNome());
		pstm.setString(2, enderecoCliente.getBairro());
		pstm.setInt(3, enderecoCliente.getNumero());
		pstm.setString(4, enderecoCliente.getCidade());
		pstm.setString(5, enderecoCliente.getUf());
		pstm.setString(6, enderecoCliente.getComplemento());
		pstm.setInt(7, enderecoCliente.getCodigo());
		
		ResultSet resultado = pstm.executeQuery();
		
		con.close();
		return resultado;
	}

	@Override
	public void alterarEnderecoCliente(EnderecoCliente enderecoCliente) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEnderecoCliente(EnderecoCliente enderecoCliente) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "DELETE FROM Endereco_Cliente WERE codigo_endereco = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoCliente.getCodigo());
		
		pstm.executeUpdate();
		
		con.close();
	}

}