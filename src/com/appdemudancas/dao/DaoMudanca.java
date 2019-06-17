package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdemudancas.model.Cliente;
import com.appdemudancas.model.ItemMudanca;
import com.appdemudancas.model.Motorista;
import com.appdemudancas.model.Mudanca;

public class DaoMudanca implements IDaoMudanca {

	@Override
	public void criarMudanca(Mudanca mudanca) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO mudanca(" + "data_criacao,data_mudanca,status,MotoristaCpf,ClienteCpf) "
				+ "VALUES(?,?,?,?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setDate(1, new java.sql.Date(mudanca.getDataCriacao().getTime()));
		pstm.setDate(2, new java.sql.Date(mudanca.getDataMudanca().getTime()));
		pstm.setString(3, mudanca.getStatus());
		pstm.setString(4, mudanca.getMotorista().getCpf());
		pstm.setString(5, mudanca.getCliente().getCpf());

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

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM mudanca WHERE " + "mudanca.data_criacao=? OR " + "mudanca.data_mudanca=? OR "
				+ "mudanca.status=? OR " + "mudanca.MotoristaCpf=? OR " + "mudanca.ClienteCpf=? OR "
				+ "mudanca.codigo_mudanca=?;";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setDate(1, new java.sql.Date(mudanca.getDataCriacao().getTime()));
		pstm.setDate(2, new java.sql.Date(mudanca.getDataMudanca().getTime()));
		pstm.setString(3, mudanca.getStatus());
		pstm.setString(4, mudanca.getMotorista().getCpf());
		pstm.setString(5, mudanca.getCliente().getCpf());
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
			auxMudanca.setDataCriacao(new java.util.Date(resultado.getDate("data_criacao").getTime()));
			auxMudanca.setDataMudanca(new java.util.Date(resultado.getDate("data_mudanca").getTime()));
			auxMudanca.setStatus(resultado.getString("status"));
			Motorista motorista = new Motorista();
			motorista.setCpf(resultado.getString("MotoristaCpf"));
			auxMudanca.setMotorista(motorista);
			Cliente cliente = new Cliente();
			cliente.setCpf(resultado.getString("ClienteCpf"));
			
			auxMudanca.setCliente(cliente);

			itemMudanca.setCodigo_mudanca(auxMudanca.getCodigo());
			auxMudanca.setItens(new DaoItemMudanca().buscarItemMudanca(itemMudanca));

			listaResultados.add(auxMudanca);

		}
		return listaResultados;
	}

	@Override
	public void alterarMudanca(Mudanca mudanca) throws SQLException {
		
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE mudanca SET data_criancao=?, data_mudanca=?"
				+ "status=?, EnderecoInicialCodigo=?, EnderecoFinalCodigo=?"
				+ "WHERE ClienteCpf=?;";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setDate(1, (Date) mudanca.getDataCriacao());
			pstm.setDate(2, (Date)mudanca.getDataMudanca());
			pstm.setString(3, mudanca.getStatus());
			pstm.setString(4, mudanca.getEnderecoInicial());
			pstm.setString(5, mudanca.getEnderecoFinal());
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);	
		}

	}

	@Override
	public void removeMudanca(Mudanca mudanca) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "DELETE FROM Mudanca WERE codigo_mudanca = ?";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, mudanca.getCodigo());

		pstm.executeUpdate();

		con.close();
	}
}
