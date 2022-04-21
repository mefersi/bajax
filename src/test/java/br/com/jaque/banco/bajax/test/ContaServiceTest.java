package br.com.jaque.banco.bajax.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.Conta;
import br.com.jaque.banco.bajax.entities.ContaCorrente;
import br.com.jaque.banco.bajax.entities.ContaPoupanca;
import br.com.jaque.banco.bajax.entities.DadosInvalidosException;
import br.com.jaque.banco.bajax.services.ContaService;

public class ContaServiceTest {

	Cliente c1 = new Cliente("Yuri Azul", "yuri@gmail.com", "123.456.789-10", true);
	Cliente c2 = new Cliente("Julia Rosa", "julia@gmail.com", "123.456.789.11", true);
	
	ContaPoupanca cp = new ContaPoupanca(1111, 1111111, c1, true);
	ContaCorrente cc = new ContaCorrente(1111, 1111111, c1, true, 5000.0, 2500.0, 2000.0);
	ContaPoupanca cp2 = new ContaPoupanca(2222, 2222222, c2, false);
	ContaCorrente cc2 = new ContaCorrente(2222, 2222222, c2, false, 5000.0, 2500.0, 2000.0);
	
	Integer agencia = 1111;
	Integer numero = 1111111;
	Double limiteSaque = 5000.0;
	Double chequeEspecial = 2500.0;
	Double limiteTransferencia = 2000.0;
	
	@Test
	public void pesquisaContaAtivaComSucessoCC() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cc);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(cc.getAgencia(), cc.getNumero()), cc);
	}
	
	@Test
	public void pesquisaContaInativaComSucessoCC() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cc2);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(cc2.getAgencia(), cc2.getNumero()), cc2);
	}
	
	@Test
	public void pesquisaContaAtivaComSucessoCP() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cp);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(cp.getAgencia(), cp.getNumero()), cp);
	}
	
	@Test
	public void pesquisaInativaComSucessoCP() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cp2);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(cp2.getAgencia(), cp2.getNumero()), cp2);
	}
	
	@Test
	public void pesquisaContaComAgenciaIgualAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.pesquisaConta(0, 1111111);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void pesquisaContaComAgenciaMenorQueZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.pesquisaConta(-1, 1111111);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void pesquisaContaComNumeroIgualAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.pesquisaConta(1111, 0);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void pesquisaContaComNumeroMenorQueZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.pesquisaConta(1111, -1);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void pesquisaContaComAgenciaValidaMasQueNaoPertenceANenhumaConta() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(111, 1111111), "Conta não encontrada!");
	}
	
	@Test
	public void pesquisaContaComNumeroValidoMasQueNaoPertenceANenhumaConta() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(1111, 111), "Conta não encontrada!");
	}
	
	@Test
	public void pesquisaContaNãoEncontrada() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.pesquisaConta(11111111, 111111111), "Conta não encontrada!");
	}

	@Test
	public void adicionaContaComSucessoCC() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.adicionaConta(cc), "Conta adicionada com sucesso");
	}
	
	@Test
	public void adicionaContaComSucessoCP() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.adicionaConta(cp), "Conta adicionada com sucesso");
	}
	
	@Test
	public void adicionaContaNula() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.adicionaConta(null);
		} catch (DadosInvalidosException e) {
			assertEquals("Conta destino não deve ser nula!", e.getMessage());
		}
	}
	
	@Test
	public void removeContaComSucessoCC() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cc);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.removeConta(cc.getAgencia(), cc.getNumero()), "Conta removida com sucesso");
	}
	
	@Test
	public void removeContaComSucessoCP() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cp);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.removeConta(cp.getAgencia(), cp.getNumero()), "Conta removida com sucesso");
	}
	
	@Test
	public void removeContaAgenciaIgualAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(0, 1111111);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void removeContaAgenciaMenorQueZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(-1, 1111111);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void removeContaNumeroIgualAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(1111, 0);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void removeContaNumeroMenorQueZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(1111, -1);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void removeContaAgenciaValidaMasQueNaoPertenceANenhumaConta() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.removeConta(1111111, 222222222), "Conta não encontrada");
	}
	
	@Test
	public void removeContaNumeroValidoMasQueNaoPertenceANenhumaConta() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.removeConta(1111, 222222222), "Conta não encontrada");
	}
	
	@Test
	public void verificaContaAtivaComSucessoCC() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cc);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.verificaConta(cc.getAgencia(), cc.getNumero()), "Conta ativa");
	}
	
	@Test
	public void verificaContaAtivaComSucessoCP() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cp);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.verificaConta(cp.getAgencia(), cp.getNumero()), "Conta ativa");
	}
	
	@Test
	public void verificaContaInativaComSucessoCC() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cc2);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.verificaConta(cc2.getAgencia(), cc2.getNumero()), "Conta inativa");
	}
	
	@Test
	public void verificaContaInativaComSucessoCP() {
		
		List<Conta> listaContas = new ArrayList<>();
		listaContas.add(cp2);
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.verificaConta(cp2.getAgencia(), cp2.getNumero()), "Conta inativa");
	}
	
	@Test
	public void verificaContaAgenciaIgualAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(0, 111111);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void verificaContaNumeroIgualAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(1111, 0);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void verificaAgenciaMenorQueAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(-1, 111111);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void verificaNumeroMenorQueAZero() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		try {
			contaService.removeConta(1111, -1);
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}
	
	@Test
	public void verificaContaAgenciaValidaMasQueNaoPertenceANenhumaConta() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.removeConta(3333, 222222222), "Conta não encontrada");
	}
	
	@Test
	public void verificaContaNumeroValidoMasQueNaoPertenceANenhumaConta() {
		
		List<Conta> listaContas = new ArrayList<>();
		
		ContaService contaService = new ContaService(listaContas);
		
		assertEquals(contaService.removeConta(3333, 222222222), "Conta não encontrada");
	}
}
