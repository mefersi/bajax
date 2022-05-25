package br.com.jaque.banco.bajax.services;

import java.util.List;

import br.com.jaque.banco.bajax.entities.Conta;
import br.com.jaque.banco.bajax.entities.DadosInvalidosException;

public class ContaService {

	protected List<Conta> listaContas;

	public ContaService(List<Conta> listaContas) {
		this.listaContas = listaContas;
	}

	public List<Conta> getListaContas() {
		return listaContas;
	}

	public Object pesquisaConta(int agencia, int numero) {
		validaAgenciaNumero(agencia, numero);
		for (Conta conta : listaContas) {
			if (conta.getAgencia() == agencia && conta.getNumero() == numero) {
				return conta;
			}
		}
		return "Conta não encontrada!";
	}

	public String adicionaConta(Conta conta) {
		if (conta == null) {
			throw new DadosInvalidosException("Conta destino não deve ser nula!");
		}
		listaContas.add(conta);
		return "Conta adicionada com sucesso";
	}

	public String removeConta(int agencia, int numero) {
		validaAgenciaNumero(agencia, numero);
		for (Conta c : listaContas) {
			if (c.getAgencia() == agencia && c.getNumero() == numero) {
				listaContas.remove(c);
				return "Conta removida com sucesso";
			}
		}
		return "Conta não encontrada";
	}

	public String verificaConta(int agencia, int numero) {
		validaAgenciaNumero(agencia, numero);
		for (Conta c : listaContas) {
			if (c.getAgencia() == agencia && c.getNumero() == numero && c.getAtiva() == true) {
				return "Conta ativa";
			} else if (c.getAgencia() == agencia && c.getNumero() == numero && c.getAtiva() == false) {
				return "Conta inativa";
			}
		}
		return "Conta não encontrada";
	}

	public void validaAgenciaNumero(int agencia, int numero) {
		if (agencia <= 0 || numero <= 0) {
			throw new DadosInvalidosException("Dados inválidos!");
		}
	}
}
