package com.appdemudancas.model;

import java.util.Date;
import java.util.List;

public class Mudanca {
	
	private int codigo;
	private Cliente cliente;
	private String status;
	private Date dataCriacao;
	private Date dataMudanca;
	private String enderecoInicial;
	private String enderecoFinal;
	private List<ItemMudanca> itens;
	private Motorista motorista;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
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
		return dataCriacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.dataCriacao = data_criacao;
	}
	public Date getData_mudanca() {
		return dataMudanca;
	}
	public void setData_mudanca(Date data_mudanca) {
		this.dataMudanca = data_mudanca;
	}
	public String getEndereco_inicial() {
		return enderecoInicial;
	}
	public void setEndereco_inicial(String endereco_inicial) {
		this.enderecoInicial = endereco_inicial;
	}
	public String getEndereco_final() {
		return enderecoFinal;
	}
	public void setEndereco_final(String endereco_final) {
		this.enderecoFinal = endereco_final;
	}
	public List<ItemMudanca> getItens() {
		return itens;
	}
	public void setItens(List<ItemMudanca> itens) {
		this.itens = itens;
	}
}
