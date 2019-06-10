package com.appdemudancas.model;

import java.util.Date;
import java.util.List;

public class Cliente {

	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	private String senha;
	private Date data_nascimento;
	private Date data_cadastro;
	private Endereco endereco;
	private List<Mudanca> mudanca;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco_cliente(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Mudanca> getMudanca() {
		return mudanca;
	}
	public void setMudanca(List<Mudanca> mudanca) {
		this.mudanca = mudanca;
	}
	
	
	
	
}