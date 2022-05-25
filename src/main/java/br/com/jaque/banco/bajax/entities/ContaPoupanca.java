package br.com.jaque.banco.bajax.entities;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Integer agencia, Integer numero, Cliente titular, Boolean ativa) {
		super(agencia, numero, titular, ativa);
	}

	@Override
	public String saca(Double valor) {
		verificaValor(valor);
		if (getAtiva() == false) {
			throw new DadosInvalidosException("Falha na transação: conta inativa não pode realizar operações!");
		}
		if (valor > saldo) {
			throw new DadosInvalidosException("Saldo insuficiente!");
		}
		saldo -= valor;
		return "Saque realizado com sucesso!";
	}

	@Override
	public String transfere(Double valor, Conta destino) {
		verificaValor(valor);
		if (getAtiva() == false) {
			throw new DadosInvalidosException("Falha na transação: conta inativa não pode realizar operações!");
		}
		if (valor > saldo) {
			throw new DadosInvalidosException("Saldo insuficiente!");
		}
		if (destino == null) {
			throw new DadosInvalidosException("Conta destino não deve ser nula!");
		}
		if (destino.getAtiva() == false) {
			throw new DadosInvalidosException("Falha na transação: conta destino inativa!");
		}
		this.saca(valor);
		destino.deposita(valor);
		return "Transferência realizado com sucesso";
	}

	@Override
	public String toString() {
		return "Conta poupança: " + super.toString();
	}
}
