package br.com.jaque.banco.bajax.main;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.Endereco;

public class Teste06Endereco {

	public static void main(String[] args) {

		Cliente c2 = new Cliente("Maria Fulana", "maria@gmail.com", "562.222.500-30", true);
		System.out.println(c2);

		c2.setEndereco(new Endereco("Rua 12 de novembro", "100", "Carvalhos", "01548906", "São Paulo", "SP", "Brasil"));
		System.out.println(c2.getEndereco());
	}
}