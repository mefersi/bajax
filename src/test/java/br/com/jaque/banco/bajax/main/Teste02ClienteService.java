package br.com.jaque.banco.bajax.main;

import java.util.ArrayList;
import java.util.List;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.services.ClienteService;

public class Teste02ClienteService {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Yuri", "yuri@gmail.com", "123.456.789.10", true);
		Cliente cliente2 = new Cliente("Gnosaji", "gnosaji@gmail.com", "123.456.789.11", false);
		Cliente cliente3 = new Cliente("Julia", "julia@gmail.com", "123.456.789.12", true);

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);

		ClienteService clienteService = new ClienteService(listaClientes);

		System.out.println(clienteService.pesquisaCliente("123.456.789.14"));
		System.out.println();
		
		Cliente cliente4 = new Cliente("Regina", "regina@gmail.com", "123.456.789.13", true);
		System.out.println(clienteService.adicionaCliente(cliente4));
		listaClientes.forEach(c -> System.out.println(c));
		System.out.println();
		
		System.out.println(clienteService.removeCliente("123.456.789.12"));
		listaClientes.forEach(c -> System.out.println(c));
		System.out.println();
		
		System.out.println(clienteService.verificaCliente("123.456.789.10"));
		System.out.println();
		
		System.out.println(clienteService.verificaCliente("123.456.789.11"));
		
	}
}
