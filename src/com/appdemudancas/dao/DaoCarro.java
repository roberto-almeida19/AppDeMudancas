package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdemudancas.model.Carro;

public class DaoCarro implements IDaoCarro {

	@Override
	public void criarCarro(Carro carro) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "INSERT INTO carro(placa, marca, modelo, chassi, cor, ano_fabricacao"
				+ "VALUES(?,?,?,?,?);";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, carro.getPlaca());
		pstm.setString(2, carro.getMarca());
		pstm.setString(3, carro.getModelo());
		pstm.setString(4, carro.getChassi());
		pstm.setString(5, carro.getCor());
		pstm.setInt(6, carro.getAnoFabricacao());
		pstm.executeUpdate();
		con.close();
	}

	@Override
	public List<Carro> buscarCarro(Carro carro) throws SQLException {
		
		ResultSet resultado = gerarResultSet(carro);
		
		List<Carro> listaResultados = resultSetParaList(resultado);
		
		return listaResultados;
	}

	private List<Carro> resultSetParaList(ResultSet resultado) throws SQLException {
		List<Carro> listaResultados = new ArrayList<>();

		while (resultado.next()) {

			Carro aux = new Carro();
			aux.setPlaca(resultado.getString("placa"));
			aux.setMarca(resultado.getString("marca"));
			aux.setModelo(resultado.getString("modelo"));
			aux.setCor(resultado.getString("cor"));
			aux.setChassi(resultado.getString("chassi"));
			aux.setAnoFabricacao(resultado.getInt("ano_fabricacao"));
			listaResultados.add(aux);
		
		}
		return listaResultados;
	}

	private ResultSet gerarResultSet(Carro carro) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "SELECT * FROM carro WHERE "
				+ "carro.chassi=? OR "
				+ "carro.placa=? OR "
				+ "carro.ano_fabricacao=? OR "
				+ "carro.marca=? OR "
				+ "carro.modelo=? OR "
				+ "carro.cor=?; ";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, carro.getPlaca());
		pstm.setString(2, carro.getMarca());
		pstm.setString(3, carro.getModelo());
		pstm.setString(4, carro.getChassi());
		pstm.setString(5, carro.getCor());
		pstm.setInt(6, carro.getAnoFabricacao());
		
		ResultSet resultado = pstm.executeQuery();
		
		con.close();
		return resultado;
	}

	@Override
	public void alterarCarro(Carro carro) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "UPDATE Carro SET placa = ?, marca= ?, modelo=?, chassi=?,"
				+ "cor=?, ano_fabricacao = ? WHERE placa = ?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		
		pstm.setString(1, carro.getPlaca());
		pstm.setString(2, carro.getMarca());
		pstm.setString(3, carro.getModelo());
		pstm.setString(4, carro.getChassi());
		pstm.setString(5, carro.getCor());
		pstm.setInt(6, carro.getAnoFabricacao());
		
		pstm.executeUpdate();
		pstm.close();
	}

	@Override
	public void removeCarro(Carro carro) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "DELETE FROM Carro WHERE placa = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, carro.getPlaca());
		
		pstm.executeUpdate();
		
		con.close();
	}

}