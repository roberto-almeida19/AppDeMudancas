package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdemudancas.model.Carro;
import com.appdemudancas.model.Motorista;
import com.appdemudancas.model.Mudanca;

public class DaoMotorista implements IDaoMotorista {

	@Override
	public void criarMotorista(Motorista motorista) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO motorista(cpf,nome,telefone," + "data_nascimento,email,senha,data_cadastro,"
				+ "cnhNumero_cnh,quantidade_ajudantes,pontuacao" + "endereco_clienteCodigo_endereco) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, motorista.getCpf());
		pstm.setString(2, motorista.getNome());
		pstm.setString(3, motorista.getTelefone());
		pstm.setDate(4, new java.sql.Date(motorista.getData_nascimento().getTime()));
		pstm.setString(5, motorista.getEmail());
		pstm.setString(6, motorista.getSenha());
		pstm.setDate(7, new java.sql.Date(motorista.getData_cadastro().getTime()));
		pstm.setString(8, motorista.getCnh().getNumero());
		pstm.setInt(9, motorista.getQuantidadeAjudantes());
		pstm.setDouble(10, motorista.getPontuacao());
		pstm.setInt(11, motorista.getEndereco().getCodigo());

		pstm.executeUpdate();

		con.close();

	}

	@Override
	public List<Motorista> buscarMotorista(Motorista motorista) throws SQLException {

		ResultSet resultado = gerarResultSet(motorista);

		List<Motorista> listaResultados = resultSetParaList(resultado);

		return listaResultados;

	}

	private List<Motorista> resultSetParaList(ResultSet resultado) throws SQLException {
		List<Motorista> listaResultados = new ArrayList<>();

		while (resultado.next()) {

			Motorista auxMotorista = new Motorista();
			Carro auxCarro = new Carro();
			Mudanca auxMudanca = new Mudanca();

			auxMotorista.setCpf(resultado.getString("cpf"));
			auxMotorista.setNome(resultado.getString("nome"));
			auxMotorista.setTelefone(resultado.getString("telefone"));
			auxMotorista.setData_nascimento(new java.util.Date(resultado.getDate("data_nascimento").getTime()));
			auxMotorista.setEmail(resultado.getString("email"));
			auxMotorista.setSenha(resultado.getString("senha"));
			auxMotorista.setData_cadastro(new java.util.Date(resultado.getDate("data_cadastro").getTime()));
			auxMotorista.setQuantidadeAjudantes(resultado.getInt("quantidade_ajudantes"));

			auxMotorista.setEndereco(
					new DaoEndereco().buscarEnderecoMotorista(auxMotorista.getEndereco()));

			auxMotorista.setPontuacao(resultado.getDouble("pontuacao"));
			Motorista motorista = new Motorista();
			motorista.setCpf(auxMotorista.getCpf());
			auxCarro.setCpfMotorista(auxMotorista.getCpf());
			auxMudanca.setMotorista(motorista);

			auxMotorista.setCarros(new DaoCarro().buscarCarro(auxCarro));
			auxMotorista.setMudanca(new DaoMudanca().buscarMudanca(auxMudanca));

			listaResultados.add(auxMotorista);

		}
		return listaResultados;
	}

	private ResultSet gerarResultSet(Motorista motorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM motorista WHERE " + "motorista.cpf=? OR " + "motorista.nome=? OR "
				+ "motorista.telefone=? OR " + "motorista.data_nascimento=? OR " + "motorista.email=? OR "
				+ "motorista.data_cadastro=? OR " + "motorista.cnhNumero_cnh=? OR "
				+ "motorista.quantidade_ajudantes=? OR " + "motorista.pontuacao=? OR "
				+ "motorista.endereco_clienteCodigo_endereco=?;";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, motorista.getCpf());
		pstm.setString(2, motorista.getNome());
		pstm.setString(3, motorista.getTelefone());
		pstm.setDate(4, new java.sql.Date(motorista.getData_nascimento().getTime()));
		pstm.setString(5, motorista.getEmail());
		pstm.setDate(6, new java.sql.Date(motorista.getData_cadastro().getTime()));
		pstm.setString(7, motorista.getCnh().getNumero());
		pstm.setInt(8, motorista.getQuantidadeAjudantes());
		pstm.setDouble(9, motorista.getPontuacao());
		pstm.setInt(10, motorista.getEndereco().getCodigo());

		ResultSet resultado = pstm.executeQuery();

		con.close();
		return resultado;
	}

	@Override
	public void alterarMotorista(Motorista motorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "UPDATE motorista SET quantidadeAjudantes = ?, pontuacao = ?,"
				+ "nome = ?, telefone = ?, cpf = ? email = ?, senha = ?"
				+ "data_nascimento = ?, data_cadastro = ?, endereco_motorista = ?"
				+ "WHERE cpf = ?";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, motorista.getQuantidadeAjudantes());
			pstm.setDouble(2, motorista.getPontuacao());
			pstm.setString(3, motorista.getNome());
			pstm.setString(4, motorista.getTelefone());
			pstm.setString(5, motorista.getCpf());
			pstm.setString(6, motorista.getEmail());
			pstm.setString(7, motorista.getSenha());
			pstm.setDate(8, (Date) motorista.getData_nascimento());
			pstm.setDate(9, (Date) motorista.getData_cadastro());
			pstm.setInt(10, motorista.getEndereco().getCodigo()); // mudar para tipo de endereco
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}

	}

	@Override
	public void removeMotorista(Motorista motorista) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "DELETE FROM Motorista WERE cpf = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, motorista.getCpf());

		pstm.executeUpdate();

		con.close();
	}

}
