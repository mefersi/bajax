package br.com.jaque.banco.bajax.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.Conta;
import br.com.jaque.banco.bajax.entities.ContaCorrente;
import br.com.jaque.banco.bajax.entities.ContaPoupanca;
import br.com.jaque.banco.bajax.entities.DadosInvalidosException;

public class ContaTest {

	Cliente c1 = new Cliente("Yuri Azul", "yuri@gmail.com", "123.456.789-10", true);
	Cliente c2 = new Cliente("Julia Rosa", "julia@gmail.com", "123.456.789.11", true);
	Cliente c3 = new Cliente("Regina Amarela", "regina@gmail.com", "123.456.789.12", false);

	Integer agencia = 1111;
	Integer numero = 1111111;
	Double limiteSaque = 5000.0;
	Double chequeEspecial = 6000.0;
	Double limiteTransferencia = 4000.0;

	ContaPoupanca cp = new ContaPoupanca(agencia, numero, c1, true);
	ContaCorrente cc = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial, limiteTransferencia);

	Conta cp2 = new ContaPoupanca(2222, 2222222, c2, true);
	Conta cp3 = new ContaPoupanca(2222, 2222222, c1, false);
	Conta cc2 = new ContaCorrente(3333, 3333333, c2, true, limiteSaque, chequeEspecial, limiteTransferencia);
	Conta cc3 = new ContaCorrente(3333, 3333333, c1, true, limiteSaque, chequeEspecial, limiteTransferencia);

	/* Cenários de sucesso */

	@Test
	public void criaContaAtivaComSucessoCP() {

		Conta conta = new ContaPoupanca(agencia, numero, c1, true);

		assertEquals(conta.getAgencia(), agencia);
		assertEquals(conta.getNumero(), numero);
		assertEquals(conta.getTitular(), c1);
		assertEquals(conta.getAtiva(), true);
	}

	@Test
	public void criaContaAtivaComSucessoCC() {

		ContaCorrente conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
				limiteTransferencia);

		assertEquals(conta.getAgencia(), agencia);
		assertEquals(conta.getNumero(), numero);
		assertEquals(conta.getTitular(), c1);
		assertEquals(conta.getAtiva(), true);
		assertEquals(conta.getLimiteSaque(), limiteSaque);
		assertEquals(conta.getChequeEspecial(), chequeEspecial);
		assertEquals(conta.getLimiteTransferencia(), limiteTransferencia);
	}

	@Test
	public void criaContaInativaComSucessoCP() {

		Conta conta = new ContaPoupanca(agencia, numero, c1, false);

		assertEquals(conta.getAgencia(), agencia);
		assertEquals(conta.getNumero(), numero);
		assertEquals(conta.getTitular(), c1);
		assertEquals(conta.getAtiva(), false);
	}

	@Test
	public void criaContaInativaComSucessoCC() {

		ContaCorrente conta = new ContaCorrente(agencia, numero, c1, false, limiteSaque, chequeEspecial,
				limiteTransferencia);

		assertEquals(conta.getAgencia(), agencia);
		assertEquals(conta.getNumero(), numero);
		assertEquals(conta.getTitular(), c1);
		assertEquals(conta.getAtiva(), false);
		assertEquals(conta.getLimiteSaque(), limiteSaque);
		assertEquals(conta.getChequeEspecial(), chequeEspecial);
		assertEquals(conta.getLimiteTransferencia(), limiteTransferencia);
	}

	/* Validações do construtor */

	@Test
	public void agenciaNegativoCP() {

		agencia = -1;

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c1, false);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void agenciaNegativoCC() {

		agencia = -1;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void agenciaIgualAZeroCP() {

		agencia = 0;

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c1, false);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void agenciaIgualAZeroCC() {

		agencia = 0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void numeroNegativoCP() {

		numero = -1;

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c1, false);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void numeroNegativoCC() {

		numero = -1;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void numeroIgualAZeroCP() {

		numero = 0;

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c1, false);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void numeroIgualAZeroCC() {

		numero = 0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void titularNuloCP() {

		try {
			Conta conta = new ContaPoupanca(agencia, numero, null, false);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void titularNuloCC() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, null, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void seContaAtivaNuloCP() {

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c1, null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void seContaAtivaNuloCC() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, null, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void setAtivaNuloCP() {

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c1, true);
			conta.setAtiva(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void setAtivaNuloCC() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, null, limiteSaque, chequeEspecial,
					limiteTransferencia);
			conta.setAtiva(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void limiteSaqueNuloCP() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, null, chequeEspecial, limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void limiteSaqueNulo() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, null, chequeEspecial, limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void chequeEspecialNulo() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, null, limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void limiteTransferenciaNulo() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial, null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void limiteSaqueIgualAZero() {

		limiteSaque = 0.0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void chequeEspecialIgualAZero() {

		chequeEspecial = 0.0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void limiteTransferenciaIgualAZero() {

		limiteTransferencia = 0.0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void limiteSaqueNegativo() {

		limiteSaque = -1.0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void chequeEspecialNegativo() {

		chequeEspecial = -1.0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void limiteTransferenciaNegativo() {

		limiteTransferencia = -1.0;

		try {
			Conta conta = new ContaCorrente(agencia, numero, c1, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void titularInativoCC() {

		try {
			Conta conta = new ContaCorrente(agencia, numero, c3, true, limiteSaque, chequeEspecial,
					limiteTransferencia);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na criação da conta: titular deve ser um cliente ativo!", e.getMessage());
		}
	}

	@Test
	public void titularInativoCP() {

		try {
			Conta conta = new ContaPoupanca(agencia, numero, c3, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na criação da conta: titular deve ser um cliente ativo!", e.getMessage());
		}
	}
	/*
	 * Validações da operação de depósito (que funciona da mesma forma para qualquer
	 * conta)
	 */

	@Test
	public void depositaComSucessoCP() {

		assertEquals(cp.deposita(100.0), "Depósito realizado com sucesso!");
	}

	@Test
	public void depositaComSucessoCC() {

		assertEquals(cc.deposita(100.0), "Depósito realizado com sucesso!");
	}

	@Test
	public void depositaValorNuloCP() {

		try {
			cp.deposita(null);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void depositaValorNuloCC() {

		try {
			cc.deposita(null);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void depositaValorIgualAZeroCP() {

		try {
			cp.deposita(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void depositaValorIgualAZeroCC() {

		try {
			cc.deposita(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void depositaValorNegativoCC() {

		try {
			cc.deposita(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void depositaValorNegativoCP() {

		try {
			cp.deposita(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void depositaContaInativaCP() {

		try {
			cp3.deposita(100.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta inativa não pode realizar operações!", e.getMessage());
		}
	}

	@Test
	public void depositaContaInativaCC() {

		try {
			cc3.deposita(100.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta inativa não pode realizar operações!", e.getMessage());
		}
	}

	/* Validações próprias para conta poupanca */

	@Test
	public void sacaComSucessoCP() {

		cp.deposita(1000.0);

		assertEquals(cp.saca(500.0), "Saque realizado com sucesso!");
	}

	@Test
	public void sacaValorNuloCP() {

		cp.deposita(1000.0);

		try {
			cp.saca(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void sacaValorIguaAZeroCP() {

		cp.deposita(1000.0);
		try {
			cp.saca(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void sacaValorNegativoCP() {

		cp.deposita(1000.0);
		try {
			cp.saca(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void sacaValorMaiorQueOSaldoCP() {

		try {
			cp.saca(100.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Saldo insuficiente!", e.getMessage());
		}
	}

	@Test
	public void sacaContaInativaCP() {

		try {
			cp3.saca(100.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta inativa não pode realizar operações!", e.getMessage());
		}
	}

	@Test
	public void transfereComSucessoParaContaPoupancaCP() {

		cp.deposita(1000.0);

		assertEquals(cp.transfere(100.0, cp2), "Transferência realizado com sucesso");
	}

	@Test
	public void transfereComSucessoParaContaCorrenteCP() {

		cp.deposita(1000.0);

		assertEquals(cp.transfere(100.0, cc2), "Transferência realizado com sucesso");
	}

	@Test
	public void transfereValorNuloParaContaPoupancaCP() {

		try {
			cp.transfere(null, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void transfereValorNuloParaContaCorrenteCP() {

		try {
			cp.transfere(null, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void transfereValorIgualAZeroParaContaPoupancaCP() {

		try {
			cp.transfere(0.0, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorIgualAZeroParaContaCorrenteCP() {

		try {
			cp.transfere(0.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorNegativoParaContaPoupancaCP() {

		try {
			cp.transfere(-1.0, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorNegativoParaContaCorrenteCP() {

		try {
			cp.transfere(-1.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorMaiorQueOSaldoParaContaPoupancaCP() {

		try {
			cp.transfere(100.0, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Saldo insuficiente!", e.getMessage());
		}
	}

	@Test
	public void transfereValorMaiorQueOSaldoParaContaCorrenteCP() {

		try {
			cp.transfere(100.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Saldo insuficiente!", e.getMessage());
		}
	}

	@Test
	public void transfereParaContaDestinoNulaCP() {

		cp.deposita(100.0);
		try {
			cp.transfere(50.0, null);
		} catch (DadosInvalidosException e) {
			assertEquals("Conta destino não deve ser nula!", e.getMessage());
		}
	}

	@Test
	public void transfereDeContaInativaCP() {

		try {
			cp3.transfere(50.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta inativa não pode realizar operações!", e.getMessage());
		}
	}

	@Test
	public void transfereParaContaInativaCP() {

		cp2.deposita(100.0);
		try {
			cp2.transfere(50.0, cp3);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta destino inativa!", e.getMessage());
		}
	}

	/* Validações próprias para conta corrente */

	@Test
	public void setLimiteSaqueSucessoCC() {

		assertEquals(cc.setLimiteSaque(1000.0), "Limite de saque definido de sucesso");
	}

	@Test
	public void setLimiteSaqueNuloCC() {

		try {
			cc.setLimiteSaque(null);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void setLimiteSaqueValorIgualAZeroCC() {

		try {
			cc.setLimiteSaque(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void setLimiteSaqueValorNegativoCC() {

		try {
			cc.setLimiteSaque(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void setChequeEspecialSucessoCC() {

		assertEquals(cc.setChequeEspecial(1500.0), "Cheque especial definido com sucesso!");
	}

	@Test
	public void setChequeEspecialNuloCC() {

		try {
			cc.setChequeEspecial(null);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void setChequeEspecialValorIgualAZeroCC() {

		try {
			cc.setChequeEspecial(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void setChequeEspecialValorNegativoCC() {

		try {
			cc.setChequeEspecial(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void setLimiteTransferenciaSucessoCC() {

		assertEquals(cc.setLimiteTransferencia(2000.0), "Limite de transferência definido com sucesso");
	}

	@Test
	public void setLimiteTransferenciaNuloCC() {

		try {
			cc.setLimiteSaque(null);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void setLimiteTransferenciaValorIgualAZeroCC() {

		try {
			cc.setLimiteTransferencia(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void setLimiteTransferenciaValorNegativoCC() {

		try {
			cc.setLimiteTransferencia(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void sacaComSucessoCC() {

		assertEquals(cc.saca(100.0), "Saque realizado com sucesso!");
	}

	@Test
	public void sacaComSucessoAtéOLimiteDeSaqueCC() {

		cc.deposita(10000.0);
		assertEquals(cc.saca(cc.getLimiteSaque()), "Saque realizado com sucesso!");
	}

	@Test
	public void sacaValorNuloCC() {

		cc.deposita(1000.0);

		try {
			cc.saca(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void sacaValorIguaAZeroCC() {

		cc.deposita(1000.0);
		try {
			cc.saca(0.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void sacaValorNegativoCC() {

		cc.deposita(1000.0);
		try {
			cc.saca(-1.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void sacaValorMaiorQueOLimiteDeSaque() {

		cc.deposita(10000.0);
		try {
			cc.saca(cc.getLimiteSaque() + 1);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha ao sacar: Valor inválido, valor maior do que o limite de saque!", e.getMessage());
		}
	}

	@Test
	public void sacaValorMaiorQueOChequeEspecial() {

		cc.deposita(3000.0);
		try {
			cc.saca(2000.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha ao sacar: Valor inválido, valor maior do que o cheque especial!", e.getMessage());
		}
	}

	@Test
	public void sacaContaInativaCC() {

		try {
			cc3.saca(2000.0);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta inativa não pode realizar operações!", e.getMessage());
		}
	}

	@Test
	public void transfereComSucessoParaContaPoupancaCC() {

		cp.deposita(1000.0);

		assertEquals(cc.transfere(100.0, cp2), "Transferência realizado com sucesso");
	}

	@Test
	public void transfereComSucessoAteOLimiteDeTransferenciaParaContaCorrenteCC() {

		cc.deposita(5000.0);

		assertEquals(cc.transfere(cc.getLimiteTransferencia(), cc2), "Transferência realizado com sucesso");
	}

	@Test
	public void transfereComSucessoAteOLimiteDeTransferenciaParaContaPoupancaCC() {

		cp.deposita(5000.0);

		assertEquals(cc.transfere(cc.getLimiteTransferencia(), cp2), "Transferência realizado com sucesso");
	}

	@Test
	public void transfereComSucessoParaContaCorrenteCC() {

		cc.deposita(1000.0);

		assertEquals(cc.transfere(100.0, cc2), "Transferência realizado com sucesso");
	}

	@Test
	public void transfereValorNuloParaContaPoupancaCC() {

		try {
			cc.transfere(null, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void transfereValorNuloParaContaCorrenteCC() {

		try {
			cc.transfere(null, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}

	@Test
	public void transfereValorIgualAZeroParaContaPoupancaCC() {

		try {
			cc.transfere(0.0, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorIgualAZeroParaContaCorrenteCC() {

		try {
			cc.transfere(0.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorNegativoParaContaPoupancaCC() {

		try {
			cc.transfere(-1.0, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorNegativoParaContaCorrenteCC() {

		try {
			cc.transfere(-1.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor inválido!", e.getMessage());
		}
	}

	@Test
	public void transfereValorMaiorQueOSaldoParaContaPoupancaCC() {

		try {
			cc.transfere(100.0, cp2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor maior do que o limite de transferência ou saldo insuficiente!", e.getMessage());
		}
	}

	@Test
	public void transfereValorMaiorQueOSaldoParaContaCorrenteCC() {

		try {
			cc.transfere(100.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Valor maior do que o limite de transferência ou saldo insuficiente!", e.getMessage());
		}
	}

	@Test
	public void transfereParaContaDestinoNulaCC() {

		cc.deposita(100.0);
		try {
			cc.transfere(50.0, null);
		} catch (DadosInvalidosException e) {
			assertEquals("Conta destino não deve ser nula!", e.getMessage());
		}
	}

	@Test
	public void transfereValorMaiorQueOLimiteTransferenciaCC() {

		cc.deposita(5000.0);
		try {
			cc.transfere(2500.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha ao transferir: valor maior que o limite de transferência!", e.getMessage());
		}
	}

	@Test
	public void transfereDeContaInativaCC() {

		try {
			cc3.transfere(2500.0, cc2);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta inativa não pode realizar operações!", e.getMessage());
		}
	}

	@Test
	public void transfereParaContaInativaCC() {

		try {
			cc2.transfere(2500.0, cc3);
		} catch (DadosInvalidosException e) {
			assertEquals("Falha na transação: conta destino inativa!", e.getMessage());
		}
	}
}
