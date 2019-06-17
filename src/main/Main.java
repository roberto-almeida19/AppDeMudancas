package main;

import java.sql.SQLException;
import java.util.Date;

import com.appdemudancas.dao.DaoCliente;
import com.appdemudancas.dao.DaoEndereco;
import com.appdemudancas.model.Cliente;
import com.appdemudancas.model.Endereco;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("12398876543");
		cliente.setNome("gdsds");
		cliente.setTelefone("675634");
		cliente.setEmail("vikjyhgg@gmail.com");
		cliente.setSenha("1234");
		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(new Date());
	
		
		Endereco endereco = new Endereco();
		endereco.setNome("av aguia de haia");
		endereco.setNumero(6000);
		endereco.setCodigo(23);
		cliente.setEnderecoCliente(endereco);
		
		try {
			new DaoEndereco().criarEnderecoCliente(endereco);
			new DaoCliente().criarCliente(cliente);
			System.out.println("operacao realizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
