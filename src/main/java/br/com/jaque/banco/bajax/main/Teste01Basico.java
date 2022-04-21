package br.com.jaque.banco.bajax.main;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.ContaCorrente;

public class Teste01Basico {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Yuri", "yuri@gmail.com", "123.456.789.12", true);
		Cliente cliente2 = new Cliente("Gnosaji", "gnosaji@gmail.com", "123.456.789.12", true);
		
		ContaCorrente conta1 = new ContaCorrente(0111, 01111111, cliente1, true, 2500.00, 2000.0, 1500.0);
		System.out.println(conta1.getSaldo());
		
		ContaCorrente conta2 = new ContaCorrente(0111, 02222222, cliente2, true, 2500.00, 2000.0, 1500.0);
		
		System.out.println(conta1.setChequeEspecial(700.0));
		System.out.println(conta1.setLimiteSaque(1000.0));
		System.out.println(conta1.setLimiteTransferencia(1000.0));
		
		System.out.println(conta1.deposita(2500.0));
		System.out.println(conta1.getSaldo());
		
		System.out.println(conta1.saca(500.00));
		System.out.println(conta1.getSaldo());
		
		System.out.println(conta1.transfere(500.0, conta2));
		System.out.println(conta1.getSaldo());
		System.out.println(conta2.getSaldo());
		
		System.out.println(conta1);
		System.out.println(conta2);
		
	}
}
