package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdemudancas.model.ItemMudanca;
import com.appdemudancas.model.Mudanca;

public class DaoMudanca implements IDaoMudanca {

	@Override
	public void criarMudanca(Mudanca mudanca) throws SQLException {

		Connection con = new ConnectionManager().getConnection();
		
		String query = "INSERT INTO mudanca("
				+ "data_criacao,data_mudanca,status,MotoristaCpf,ClienteCpf) "
				+ "VALUES(?,?,?,?,?);";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setDate(1, new java.sql.Date(
				mudanca.getData_criacao().getTime()));
		pstm.setDate(2, new java.sql.Date(
				mudanca.getData_mudanca().getTime()));
		pstm.setString(3, mudanca.getStatus());
		pstm.setString(4, mudanca.getMotorista_cpf());
		pstm.setString(5, mudanca.getCliente_cpf());
		
		pstm.executeUpdate();
		
		con.close();

	}

	@Override
	public List<Mudanca> buscarMudanca(Mudanca mudanca) throws SQLException {
		
		ResultSet resultado = gerarResultSet(mudanca);
		
		List<Mudanca> listaResultados = resultSetParaList(resultado);
		
		return listaResultados;
	}

	private ResultSet gerarResultSet(Mudanca mudanca) throws SQLException {
		
		Connection con = new ConnectionManager().getConnection();
		
		String query = "SELECT * FROM mudanca WHERE "
				+ "mudanca.data_criacao=? OR "
				+ "mudanca.data_mudanca=? OR "
				+ "mudanca.status=? OR "
				+ "mudanca.MotoristaCpf=? OR "
				+ "mudanca.ClienteCpf=? OR "
				+ "mudanca.codigo_mudanca=?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setDate(1, new java.sql.Date(
				mudanca.getData_criacao().getTime()));
		pstm.setDate(2, new java.sql.Date(
				mudanca.getData_mudanca().getTime()));
		pstm.setString(3, mudanca.getStatus());
		pstm.setString(4, mudanca.getMotorista_cpf());
		pstm.setString(5, mudanca.getCliente_cpf());
		pstm.setInt(6, mudanca.getCodigo());
		
		ResultSet resultado = pstm.executeQuery();
		
		con.close();
		return resultado;
	}

	private List<Mudanca> resultSetParaList(ResultSet resultado) throws SQLException {
		
		List<Mudanca> listaResultados = new ArrayList<>();

		while (resultado.next()) {

			Mudanca auxMudanca = new Mudanca();
			ItemMudanca itemMudanca = new ItemMudanca();
			
			auxMudanca.setCodigo(resultado.getInt("codigo_mudanca"));
			auxMudanca.setData_criacao(
					new java.util.Date(
							resultado.getDate("data_criacao").getTime()));
			auxMudanca.setData_mudanca(
					new java.util.Date(
							resultado.getDate("data_mudanca").getTime()));
			auxMudanca.setStatus(resultado.getString("status"));
			auxMudanca.setMotorista_cpf(resultado.getString("MotoristaCpf"));
			auxMudanca.setCliente_cpf(resultado.getString("ClienteCpf"));
			

			itemMudanca.setCodigo_mudanca(auxMudanca.getCodigo());
			auxMudanca.setItens(new DaoItemMudanca().buscarItemMudanca(itemMudanca));
			
			listaResultados.add(auxMudanca);
		
		}
		return listaResultados;
	}

	@Override
	public void alterarMudanca(Mudanca mudanca) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMudanca(Mudanca mudanca) throws SQLException {
		Connection con = new ConnectionManager().getConnection();
		
		String query = "DELETE FROM Mudanca WERE codigo_mudanca = ?";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, mudanca.getCodigo());
		
		pstm.executeUpdate();
		
		con.close();
	}
}
