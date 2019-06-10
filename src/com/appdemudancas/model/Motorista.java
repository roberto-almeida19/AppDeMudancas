package com.appdemudancas.model;

import java.util.Date;
import java.util.List;

public class Motorista {
	
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	private int quantidadeAjudantes;
	private double pontuacao;
	private Date data_nascimento;
	private Date data_cadastro;
	private List<Carro> carros;
	private List<Mudanca> mudanca;
	
	
	public double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getQuantidadeAjudantes() {
		return quantidadeAjudantes;
	}
	public void setQuantidadeAjudantes(int quantidadeAjudantes) {
		this.quantidadeAjudantes = quantidadeAjudantes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	public List<Mudanca> getMudanca() {
		return mudanca;
	}
	public void setMudanca(List<Mudanca> mudanca) {
		this.mudanca = mudanca;
	}	
	
	
	
	
	
	
	
}
