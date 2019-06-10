package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.appdemudancas.model.EnderecoMudanca;

public class DaoEnderecoMudanca implements IDaoEnderecoMudanca {

	@Override
	public void criarEnderecoMudanca(EnderecoMudanca enderecoMudanca) throws SQLException {

		Connection con = new ConnectionManager().getConnection();
		
		String query = "INSERT INTO endereco_mudanca("
				+ "nome,bairro,numero,cidade,uf,complemento) "
				+ "VALUES(?,?,?,?,?,?);";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMudanca.getNome());
		pstm.setString(2, enderecoMudanca.getBairro());
		pstm.setInt(3, enderecoMudanca.getNumero());
		pstm.setString(4, enderecoMudanca.getCidade());
		pstm.setString(5, enderecoMudanca.getUf());
		pstm.setString(6, enderecoMudanca.getComplemento());
		
		pstm.executeUpdate();
		
		con.close();

	}

	@Override
	public EnderecoMudanca buscarEnderecoMudanca(EnderecoMudanca enderecoMudanca) throws SQLException {

		ResultSet resultado = gerarResultSet(enderecoMudanca);
		
		EnderecoMudanca  auxEnderecoMudanca = new EnderecoMudanca();
		
		auxEnderecoMudanca.setCodigo(resultado.getInt("codigo_endereco"));
		auxEnderecoMudanca.setNome(resultado.getString("nome"));
		auxEnderecoMudanca.setNome(resultado.getString("bairro"));
		auxEnderecoMudanca.setCodigo(resultado.getInt("numero"));
		auxEnderecoMudanca.setNome(resultado.getString("cidade"));
		auxEnderecoMudanca.setNome(resultado.getString("uf"));
		auxEnderecoMudanca.setNome(resultado.getString("complemento"));
		
		
		
		return auxEnderecoMudanca;
		
	}

	private ResultSet gerarResultSet(EnderecoMudanca enderecoMudanca) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "SELECT * FROM endereco_mudanca WHERE "
				+ "endereco_mudanca.nome=? OR "
				+ "endereco_mudanca.bairro=? OR "
				+ "endereco_mudanca.numero=? OR "
				+ "endereco_mudanca.cidade=? OR "
				+ "endereco_mudanca.uf=? OR "
				+ "endereco_mudanca.complemento=? OR "
				+ "endereco_mudanca.codigo_endereco=?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMudanca.getNome());
		pstm.setString(2, enderecoMudanca.getBairro());
		pstm.setInt(3, enderecoMudanca.getNumero());
		pstm.setString(4, enderecoMudanca.getCidade());
		pstm.setString(5, enderecoMudanca.getUf());
		pstm.setString(6, enderecoMudanca.getComplemento());
		pstm.setInt(7, enderecoMudanca.getCodigo());
		
		ResultSet resultado = pstm.executeQuery();
		
		con.close();
		return resultado;
	}

	@Override
	public void alterarEnderecoMudanca(EnderecoMudanca enderecoMudanca) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEnderecoMudanca(EnderecoMudanca enderecoMudanca) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "DELETE FROM Endereco_Mudanca WERE codigo_endereco = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoMudanca.getCodigo());
		
		pstm.executeUpdate();
		
		con.close();
	}
}