package br.com.jaque.banco.bajax.entities;

public class ContaCorrente extends Conta {

	private Double limiteSaque;
	private Double chequeEspecial;
	private Double limiteTransferencia;

	public ContaCorrente(Integer agencia, Integer numero, Cliente titular, Boolean ativa, Double limiteSaque,
			Double chequeEspecial, Double limiteTransferencia) {
		super(agencia, numero, titular, ativa);
		validaAtributos(limiteSaque, chequeEspecial, limiteTransferencia);
		this.limiteSaque = limiteSaque;
		this.chequeEspecial = chequeEspecial;
		this.limiteTransferencia = limiteTransferencia;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public String setLimiteSaque(Double limiteSaque) {
		if (limiteSaque == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		verificaValor(limiteSaque);
		this.limiteSaque = limiteSaque;
		return "Limite de saque definido de sucesso";
	}

	public Double getChequeEspecial() {
		return chequeEspecial;
	}

	public String setChequeEspecial(Double chequeEspecial) {
		if (chequeEspecial == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		verificaValor(chequeEspecial);
		this.chequeEspecial = chequeEspecial;
		return "Cheque especial definido com sucesso!";
	}

	public Double getLimiteTransferencia() {
		return limiteTransferencia;
	}

	public String setLimiteTransferencia(Double limiteTransferencia) {
		if (limiteTransferencia == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		verificaValor(limiteTransferencia);
		this.limiteTransferencia = limiteTransferencia;
		return "Limite de transferência definido com sucesso";
	}

	@Override
	public String saca(Double valor) {
		verificaValor(valor);
		if (this.getAtiva() == false) {
			throw new DadosInvalidosException("Falha na transação: conta inativa não pode realizar operações!");
		}
		if (valor > limiteSaque) {
			throw new DadosInvalidosException("Falha ao sacar: Valor inválido, valor maior do que o limite de saque!");
		}
		if (valor > chequeEspecial) {
			throw new DadosInvalidosException("Falha ao sacar: Valor inválido, valor maior do que o cheque especial!");
		}
		saldo -= valor;
		return "Saque realizado com sucesso!";
	}

	public String transfere(Double valor, Conta destino) {
		verificaValor(valor);
		if (getAtiva() == false) {
			throw new DadosInvalidosException("Falha na transação: conta inativa não pode realizar operações!");
		}
		if (destino == null) {
			throw new DadosInvalidosException("Conta destino não deve ser nula!");
		}
		if (destino.getAtiva() == false) {
			throw new DadosInvalidosException("Falha na transação: conta destino inativa!");
		}
		if (valor > limiteTransferencia) {
			throw new DadosInvalidosException("Falha ao transferir: valor maior que o limite de transferência!");
		}
		if (valor > chequeEspecial) {
			throw new DadosInvalidosException("Falha ao transferir: valor maior que o cheque especial!");
		}
		this.saca(valor);
		destino.deposita(valor);
		return "Transferência realizado com sucesso";
	}

	private void validaAtributos(Double limiteSaque, Double chequeEspecial, Double limiteTransferencia) {
		if (limiteSaque == null || chequeEspecial == null || limiteTransferencia == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		if (limiteSaque <= 0 || chequeEspecial <= 0 || limiteTransferencia <= 0) {
			throw new DadosInvalidosException("Valor inválido!");
		}
	}

	public Double calculaChequeEspecial() {
		double valor = -getChequeEspecial();
		return valor;
	}

	@Override
	public String toString() {
		return "Conta corrente: " + super.toString();
	}
}
