package com.appdemudancas.model;

public class ItemMudanca {
	
	private int codigo;
	private String nome;
	private double altura;
	private double largura;
	private double comprimento;
	private double peso;
	private boolean eFragil;
	private int codigoMudanca;
	
	public int getCodigoMudanca() {
		return codigoMudanca;
	}
	public void setCodigoMudanca(int codigoMudanca) {
		this.codigoMudanca = codigoMudanca;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo_mudanca(int codigo) {
		this.codigo = codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public boolean isEFragil() {
		return eFragil;
	}
	public void setEFragil(boolean e_fragil) {
		this.eFragil = e_fragil;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
