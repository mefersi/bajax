package br.com.jaque.banco.bajax.main;

import br.com.jaque.banco.bajax.entities.Cliente;

public class Teste05Cliente {

	public static void main(String[] args) {
		
//		Cliente c1 = new Cliente(null, null, null, null);
//		System.out.println(c1);
		
		Cliente c2 = new Cliente("Maria Fulana", "maria1@gmail.com", "562.222.500-30", true);
		System.out.println(c2);
		
		Cliente c3 = new Cliente("Mario Fulano", "mario@gmail.com", "562.222.500-66", false);
		System.out.println(c3);
		
		//c3.setTelefone("abc");
		
		//c2.setTelefone(null);
		
		Cliente c4 = new Cliente("Mario Fulano", null, "562.222.500-66", true);
		System.out.println(c4);
		
		
	}
}