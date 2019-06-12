package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.appdemudancas.model.Endereco;

public class DaoEndereco implements IDaoEndereco {
	
	// CLIENTES-------------------------------------

	@Override
	public void criarEnderecoCliente(Endereco enderecoCliente) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO endereco(nome,cep,numero) "
				+ "VALUES(?,?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoCliente.getNome());
		pstm.setString(2, enderecoCliente.getCep());
		pstm.setInt(3, enderecoCliente.getNumero());

		pstm.executeUpdate();

		con.close();
	}

	
	
	@Override
	public Endereco buscarEnderecoCliente(Endereco enderecoCliente) throws SQLException {

		ResultSet resultado = gerarResultSetCli(enderecoCliente);

		Endereco auxEnderecoCliente = new Endereco();

		auxEnderecoCliente.setCodigo(resultado.getInt("codigo_endereco"));
		auxEnderecoCliente.setNome(resultado.getString("nome"));
		auxEnderecoCliente.setNome(resultado.getString("cep"));
		auxEnderecoCliente.setNome(resultado.getString("numero"));

		return auxEnderecoCliente;
	}

	private ResultSet gerarResultSetCli(Endereco enderecoCliente) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM endereco WHERE "
				+ "endereco.nome=? OR "
				+ "endereco.numero=? OR "
				+ "endereco.cep=? OR"
				+ "endereco.codigo_endereco=?;";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoCliente.getCodigo());
		pstm.setString(2, enderecoCliente.getNome());
		pstm.setString(3, enderecoCliente.getCep());
		pstm.setInt(4, enderecoCliente.getNumero());

		ResultSet resultado = pstm.executeQuery();

		con.close();
		return resultado;
	}
	
	

	@Override
	public void alterarEnderecoCliente(Endereco enderecoCliente) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "UPDATE Endereco SET nome = ?, cep = ?, numero = ?"
				+ "	WHERE codigo_endereco = ?;";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, enderecoCliente.getNome());
			pstm.setString(2, enderecoCliente.getCep());
			pstm.setInt(3, enderecoCliente.getNumero());

			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}
	
	

	@Override
	public void removeEnderecoCliente(Endereco enderecoCliente) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "DELETE FROM Endereco WHERE codigo_endereco = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoCliente.getCodigo());

		pstm.executeUpdate();

		con.close();
	}
	
	
	// MOTORISTAS ------------------------------------------------

	@Override
	public void criarEnderecoMotorista(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO endereco(nome,cep,numero) "
				+ "VALUES(?,?,?);";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMotorista.getNome());
		pstm.setString(2, enderecoMotorista.getCep());
		pstm.setInt(3, enderecoMotorista.getNumero());
		
		pstm.executeUpdate();
		
		con.close();

	}

	
	
	@Override
	public Endereco buscarEnderecoMotorista(Endereco enderecoMotorista) throws SQLException {
		
		ResultSet resultado = gerarResultSetMotor(enderecoMotorista);

		Endereco auxEnderecoMotorista = new Endereco();

		auxEnderecoMotorista.setCodigo(resultado.getInt("codigo_endereco"));
		auxEnderecoMotorista.setNome(resultado.getString("nome"));
		auxEnderecoMotorista.setNome(resultado.getString("cep"));
		auxEnderecoMotorista.setNome(resultado.getString("numero"));

		return auxEnderecoMotorista;
	}

	private ResultSet gerarResultSetMotor(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM endereco WHERE "
				+ "endereco.nome=? OR "
				+ "endereco.numero=? OR "
				+ "endereco.cep=? OR"
				+ "endereco.codigo_endereco=?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoMotorista.getCodigo());
		pstm.setString(2, enderecoMotorista.getNome());
		pstm.setString(3, enderecoMotorista.getCep());
		pstm.setInt(4, enderecoMotorista.getNumero());
		
		ResultSet resultado = pstm.executeQuery();
		
		con.close();
		return resultado;
	}
	
	

	@Override
	public void alterarEnderecoMotorista(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "UPDATE Endereco SET nome = ?, cep = ?, numero = ?"
				+ "	WHERE codigo_endereco = ?;";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, enderecoMotorista.getNome());
			pstm.setString(2, enderecoMotorista.getCep());
			pstm.setInt(3, enderecoMotorista.getNumero());

			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	
	
	@Override
	public void removeEnderecoMotorista(Endereco enderecoMotorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "DELETE FROM Endereco WHERE codigo_endereco = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoMotorista.getCodigo());

		pstm.executeUpdate();

		con.close();
	}

	
	
	// MUDANÇAS --------------------------------------------------------
	
	@Override
	public void criarEnderecoMudança(Endereco enderecoMudanca) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO endereco(nome,cep,numero) "
				+ "VALUES(?,?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, enderecoMudanca.getNome());
		pstm.setString(2, enderecoMudanca.getCep());
		pstm.setInt(3, enderecoMudanca.getNumero());

		pstm.executeUpdate();

		con.close();
	}
	
	

	@Override
	public Endereco buscarEnderecoMudança(Endereco enderecoMudanca) throws SQLException {
		ResultSet resultado = gerarResultSetMudan(enderecoMudanca);

		Endereco auxEnderecoCliente = new Endereco();

		auxEnderecoCliente.setCodigo(resultado.getInt("codigo_endereco"));
		auxEnderecoCliente.setNome(resultado.getString("nome"));
		auxEnderecoCliente.setNome(resultado.getString("cep"));
		auxEnderecoCliente.setNome(resultado.getString("numero"));

		return auxEnderecoCliente;
	}

	private ResultSet gerarResultSetMudan(Endereco enderecoCliente) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM endereco WHERE "
				+ "endereco.nome=? OR "
				+ "endereco.numero=? OR "
				+ "endereco.cep=? OR"
				+ "endereco.codigo_endereco=?;";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoCliente.getCodigo());
		pstm.setString(2, enderecoCliente.getNome());
		pstm.setString(3, enderecoCliente.getCep());
		pstm.setInt(4, enderecoCliente.getNumero());

		ResultSet resultado = pstm.executeQuery();

		con.close();
		return resultado;
	}
	
	

	@Override
	public void alterarEnderecoMudança(Endereco enderecoMudanca) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "UPDATE Endereco SET nome = ?, cep = ?, numero = ?"
				+ "	WHERE codigo_endereco = ?;";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, enderecoMudanca.getNome());
			pstm.setString(2, enderecoMudanca.getCep());
			pstm.setInt(3, enderecoMudanca.getNumero());

			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}

	}
	
	

	@Override
	public void removeEnderecoMudança(Endereco enderecoMudanca) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "DELETE FROM Endereco WHERE codigo_endereco = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, enderecoMudanca.getCodigo());

		pstm.executeUpdate();

		con.close();
	}
}