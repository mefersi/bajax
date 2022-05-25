package br.com.jaque.banco.bajax.main;

import java.util.ArrayList;
import java.util.List;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.Conta;
import br.com.jaque.banco.bajax.entities.ContaCorrente;
import br.com.jaque.banco.bajax.services.ContaService;

public class Teste03ContaCorrenteService {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Yuri", "yuri@gmail.com", "123.456.789.10", true);
		Cliente cliente2 = new Cliente("Gnosaji", "gnosaji@gmail.com", "123.456.789.11", true);
		Cliente cliente3 = new Cliente("Julia", "julia@gmail.com", "123.456.789.12", true);

		ContaCorrente conta1 = new ContaCorrente(1111111, 1111111, cliente1, true, 2500.00, 2000.0, 1500.0);
		ContaCorrente conta2 = new ContaCorrente(1111111, 2222222, cliente2, false, 2500.00, 2000.0, 1500.0);
		ContaCorrente conta3 = new ContaCorrente(1111111, 3333333, cliente3, true, 2500.00, 2000.0, 1500.0);

		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(conta1);
		listaContas.add(conta2);
		listaContas.add(conta3);

		ContaService contaService = new ContaService(listaContas);

		System.out.println(contaService.pesquisaConta(1111111, 1111111));

		Cliente cliente4 = new Cliente("Regina", "regina@gmail.com", "123.456.789.13", true);
		ContaCorrente conta4 = new ContaCorrente(1111111, 4444444, cliente4, true, 2500.00, 2000.0, 1500.0);

		System.out.println(contaService.adicionaConta(conta4));
		listaContas.forEach(c -> System.out.println(c));

		System.out.println(contaService.removeConta(1111111, 3333333));
		listaContas.forEach(c -> System.out.println(c));

		System.out.println(contaService.verificaConta(1111111, 2222222));

		System.out.println(contaService.verificaConta(1111111, 1111111));
	}
}
