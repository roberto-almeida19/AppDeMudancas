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
		cliente.setCpf("14532095541");
		cliente.setNome("Sthefani Cris");
		cliente.setEmail("salmeida@gmail.com");
		cliente.setData_nascimento(new Date());
		cliente.setData_cadastro(new Date());
		
		Endereco endereco = new Endereco();
		endereco.setNome("anisio de abreu");
		endereco.setNumero(384);
		endereco.setCodigo(2);
		cliente.setEndereco_cliente(endereco);
		
		try {
			new DaoEndereco().criarEnderecoCliente(endereco);
			new DaoCliente().criarCliente(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
