package com.appdemudancas.model;

import java.util.Date;
import java.util.List;

public class Cliente {

	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	private String senha;
	private Date dataNascimento;
	private Date dataCadastro;
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date data_nascimento) {
		this.dataNascimento = data_nascimento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date data_cadastro) {
		this.dataCadastro = data_cadastro;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEnderecoCliente(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Mudanca> getMudanca() {
		return mudanca;
	}
	public void setMudanca(List<Mudanca> mudanca) {
		this.mudanca = mudanca;
	}
	
	
	
	
}
