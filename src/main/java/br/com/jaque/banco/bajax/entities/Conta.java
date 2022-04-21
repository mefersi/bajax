package br.com.jaque.banco.bajax.entities;

public abstract class Conta {

	private Integer agencia;
	private Integer numero;
	protected Double saldo;
	private Cliente titular;
	private Boolean ativa;
	private static int totalContasCriadas;

	public Conta(Integer agencia, Integer numero, Cliente titular, Boolean ativa) {
		if (agencia <= 0 || numero <= 0) {
			throw new DadosInvalidosException("Valor inválido!");
		}
		if (titular == null || ativa == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		if (titular.getAtivo() == false) {
			throw new DadosInvalidosException("Falha na criação da conta: titular deve ser um cliente ativo!");
		}
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = 0.0;
		this.titular = titular;
		this.ativa = ativa;
		totalContasCriadas++;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getTitular() {
		return titular;
	}

	public Boolean getAtiva() {
		return ativa;
	}
	
	public void setAtiva(Boolean ativa) {
		if (ativa == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		this.ativa = ativa;
	}

	public static int getTotalContasCriadas() {
		return totalContasCriadas;
	}

	public String deposita(Double valor) {
		if (ativa == false) {
			throw new DadosInvalidosException("Falha na transação: conta inativa não pode realizar operações!");
		}
		verificaValor(valor);
		saldo += valor;
		return "Depósito realizado com sucesso!";
	}

	public abstract String saca(Double valor);

	public abstract String transfere(Double valor, Conta destino);
	
	public void verificaValor(Double valor) {
		if (valor == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		if (valor <= 0) {
			throw new DadosInvalidosException("Valor inválido!");
		}
	}

	@Override
	public String toString() {
		return "DADOS DA CONTA: " + "\nTitular: " + getTitular() + "\nagencia: " + getAgencia()
		+ ", número: " + getNumero() + ", saldo: " + getSaldo();
	}
}
