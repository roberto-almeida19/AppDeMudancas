package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdemudancas.model.ItemMudanca;

public class DaoItemMudanca implements IDaoItemMudanca {

	@Override
	public void criarItemMudanca(ItemMudanca itemMudanca) throws SQLException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO item_da_mudanca("
				+ "codigo,nome,altura,largura,comprimento,peso,e_fragil,MudancaCodigo_mudanca) "
				+ "VALUES(?,?,?,?,?,?,?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, itemMudanca.getCodigo());
		pstm.setString(2, itemMudanca.getNome());
		pstm.setDouble(3, itemMudanca.getAltura());
		pstm.setDouble(4, itemMudanca.getLargura());
		pstm.setDouble(5, itemMudanca.getComprimento());
		pstm.setDouble(6, itemMudanca.getPeso());
		pstm.setString(7, itemMudanca.isE_fragil() ? "s" : "n");
		pstm.setInt(7, itemMudanca.getCodigoMudanca());

		pstm.executeUpdate();

		con.close();

	}

	@Override
	public List<ItemMudanca> buscarItemMudanca(ItemMudanca itemMudanca) throws SQLException {

		ResultSet resultado = gerarResultSet(itemMudanca);

		List<ItemMudanca> listaResultados = resultSetParaList(resultado);

		return listaResultados;
	}

	private List<ItemMudanca> resultSetParaList(ResultSet resultado) throws SQLException {
		List<ItemMudanca> listaResultados = new ArrayList<>();

		while (resultado.next()) {

			ItemMudanca auxItemMudanca = new ItemMudanca();
			auxItemMudanca.setCodigo(resultado.getInt("codigo_item"));
			auxItemMudanca.setNome(resultado.getString("nome"));
			auxItemMudanca.setAltura(resultado.getDouble("altura"));
			auxItemMudanca.setLargura(resultado.getDouble("largura"));
			auxItemMudanca.setComprimento(resultado.getDouble("comprimento"));
			auxItemMudanca.setPeso(resultado.getDouble("peso"));
			auxItemMudanca.setE_fragil("s".equals(resultado.getString("altura")) ? true : false);
			auxItemMudanca.setCodigo_mudanca(resultado.getInt("MudancaCodigo_mudanca"));

			listaResultados.add(auxItemMudanca);

		}
		return listaResultados;
	}

	private ResultSet gerarResultSet(ItemMudanca itemMudanca) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "SELECT * FROM item_da_mudanca WHERE " + "item_da_mudanca.nome=? OR "
				+ "item_da_mudanca.altura=? OR " + "item_da_mudanca.largura=? OR " + "item_da_mudanca.comprimento=? OR "
				+ "item_da_mudanca.peso=? OR " + "item_da_mudanca.e_fragil=? OR"
				+ "item_da_mudanca.MudancaCodigo_mudanca=? OR" + "item_da_mudanca.codigo_item=?;";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, itemMudanca.getNome());
		pstm.setDouble(2, itemMudanca.getAltura());
		pstm.setDouble(3, itemMudanca.getLargura());
		pstm.setDouble(4, itemMudanca.getComprimento());
		pstm.setDouble(5, itemMudanca.getPeso());
		pstm.setString(6, itemMudanca.isE_fragil() ? "s" : "n");
		pstm.setInt(7, itemMudanca.getCodigoMudanca());
		pstm.setInt(8, itemMudanca.getCodigo());

		ResultSet resultado = pstm.executeQuery();

		con.close();
		return resultado;
	}

	@Override
	public void alterarItemMudanca(ItemMudanca itemMudanca) throws SQLException {
		
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE item_da_mudanca SET nome=?, altura=?"
				+ "largura=?, comprimento=?, peso=?, e_fragil=?"
				+ "WHERE mudancaCodigo_mudanca=?;";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, itemMudanca.getNome());
			pstm.setDouble(2, itemMudanca.getAltura());
			pstm.setDouble(3, itemMudanca.getLargura());
			pstm.setDouble(4, itemMudanca.getComprimento());
			pstm.setDouble(5, itemMudanca.getPeso());
			pstm.setBoolean(6, itemMudanca.isE_fragil());
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);	
		}

	}

	@Override
	public void removeItemMudanca(ItemMudanca itemMudanca) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "DELETE FROM Item_Da_Mudanca WERE codigo_item = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, itemMudanca.getCodigo());

		pstm.executeUpdate();

		con.close();
	}

}