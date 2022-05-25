package br.com.jaque.banco.bajax.main;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.ContaCorrente;
import br.com.jaque.banco.bajax.entities.ContaPoupanca;

public class Teste07Conta {

	public static void main(String[] args) {

		ContaPoupanca cp1 = new ContaPoupanca(1111, 1111111,
				new Cliente("Yuri Azul", "yuri@gmail.com", "123.456.789.10", true), true);
		cp1.deposita(100.0);
		cp1.saca(50.0);
		System.out.println(cp1.getSaldo());

		ContaCorrente cc1 = new ContaCorrente(2222, 2222222,
				new Cliente("Julia Rosa", "julia@gmail.com", "123.456.789-11", true), true, 5000.00, 6000.0, 4000.0);
		cc1.deposita(100.0);
		cc1.saca(50.0);
		System.out.println(cc1.getSaldo());

		cc1.transfere(10.0, cp1);
		System.out.println(cc1.getAtiva());

		System.out.println(cc1.saca(140.0));
		System.out.println(cc1.getSaldo());
		cc1.transfere(200.0, cp1);
		System.out.println(cc1.getSaldo());

		cc1.deposita(5300.0);
		System.out.println(cc1.getSaldo());

		System.out.println(cc1.saca(2500.0));

		System.out.println(cc1.getSaldo());

		System.out.println(cc1.transfere(4000.0, cp1));

		System.out.println(cc1.getSaldo());

		System.out.println(cc1.transfere(null, cp1));
	}
}
