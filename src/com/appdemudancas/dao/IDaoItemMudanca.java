package com.appdemudancas.dao;

import java.sql.SQLException;
import java.util.List;

import com.appdemudancas.model.ItemMudanca;

public interface IDaoItemMudanca {
	
	public void criarItemMudanca(ItemMudanca itemMudanca) throws SQLException;

	public List<ItemMudanca> buscarItemMudanca(ItemMudanca itemMudanca) throws SQLException;
	
	public void alterarItemMudanca(ItemMudanca itemMudanca) throws SQLException;
	
	public void removeItemMudanca(ItemMudanca itemMudanca) throws SQLException;

}
