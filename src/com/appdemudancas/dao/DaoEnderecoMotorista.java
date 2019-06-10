package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.appdemudancas.model.Endereco;

public class DaoEnderecoMotorista implements IDaoEndereco {

	@Override
	public void criarEndereco(Endereco enderecoMotorista) throws SQLException {
		
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "INSERT INTO endereco_motorista("
				+ "nome,bairro,numero,cidade,uf,complemento) "
				+ "VALUES(?,?,?,?,?,?);";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMotorista.getNome());
		pstm.setString(2, enderecoMotorista.getBairro());
		pstm.setInt(3, enderecoMotorista.getNumero());
		pstm.setString(4, enderecoMotorista.getCidade());
		pstm.setString(5, enderecoMotorista.getUf());
		pstm.setString(6, enderecoMotorista.getComplemento());
		
		pstm.executeUpdate();
		
		con.close();

	}

	@Override
	public Endereco buscarEndereco(Endereco enderecoMotorista) throws SQLException {
		
		ResultSet resultado = gerarResultSet(enderecoMotorista);
		
		Endereco auxEnderecoMotorista = new Endereco();
		
		auxEnderecoMotorista.setCodigo(resultado.getInt("codigo_endereco"));
		auxEnderecoMotorista.setNome(resultado.getString("nome"));
		auxEnderecoMotorista.setNome(resultado.getString("bairro"));
		auxEnderecoMotorista.setCodigo(resultado.getInt("numero"));
		auxEnderecoMotorista.setNome(resultado.getString("cidade"));
		auxEnderecoMotorista.setNome(resultado.getString("uf"));
		auxEnderecoMotorista.setNome(resultado.getString("complemento"));
		
		
		
		return auxEnderecoMotorista;
	}

	private ResultSet gerarResultSet(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "SELECT * FROM endereco_motorista WHERE "
				+ "endereco_motorista.nome=? OR "
				+ "endereco_motorista.bairro=? OR "
				+ "endereco_motorista.numero=? OR "
				+ "endereco_motorista.cidade=? OR "
				+ "endereco_motorista.uf=? OR "
				+ "endereco_motorista.complemento=? OR "
				+ "endereco_motorista.codigo_endereco=?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMotorista.getNome());
		pstm.setString(2, enderecoMotorista.getBairro());
		pstm.setInt(3, enderecoMotorista.getNumero());
		pstm.setString(4, enderecoMotorista.getCidade());
		pstm.setString(5, enderecoMotorista.getUf());
		pstm.setString(6, enderecoMotorista.getComplemento());
		pstm.setInt(7, enderecoMotorista.getCodigo());
		
		ResultSet resultado = pstm.executeQuery();
		
		con.close();
		return resultado;
	}

	@Override
	public void alterarEndereco(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE Enderoco_Motorista SET nome = ?, bairro = ?, numero = ?, cidade = ?, uf = ?, complemento = ?, codigo = ?"
				+ "	WHERE codigo = ?;";
		
		try{
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMotorista.getNome());
		pstm.setString(2, enderecoMotorista.getBairro());
		pstm.setInt(3, enderecoMotorista.getNumero());
		pstm.setString(4, enderecoMotorista.getCidade());
		pstm.setString(5, enderecoMotorista.getUf());
		pstm.setString(6, enderecoMotorista.getComplemento());
		pstm.setInt(7, enderecoMotorista.getCodigo());
		
		pstm.executeUpdate();
		pstm.close();
		}catch (SQLException ex){
			throw new SQLException(ex);
		}
	}

	@Override
	public void removeEndereco(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "DELETE FROM Endereco_Motorista WERE codigo_endereco = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoMotorista.getCodigo());
		
		pstm.executeUpdate();
		
		con.close();
	}

}
