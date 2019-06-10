package com.appdemudancas.model;

import java.util.Date;
import java.util.List;

public class Mudanca {
	
	private int codigo;
	private String status;
	private Date data_criacao;
	private Date data_mudanca;
	private String endereco_inicial;
	private String endereco_final;
	private List<ItemMudanca> itens;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	public Date getData_mudanca() {
		return data_mudanca;
	}
	public void setData_mudanca(Date data_mudanca) {
		this.data_mudanca = data_mudanca;
	}
	public String getEndereco_inicial() {
		return endereco_inicial;
	}
	public void setEndereco_inicial(String endereco_inicial) {
		this.endereco_inicial = endereco_inicial;
	}
	public String getEndereco_final() {
		return endereco_final;
	}
	public void setEndereco_final(String endereco_final) {
		this.endereco_final = endereco_final;
	}
	public List<ItemMudanca> getItens() {
		return itens;
	}
	public void setItens(List<ItemMudanca> itens) {
		this.itens = itens;
	}
	
	
		

}
