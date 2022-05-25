package br.com.jaque.banco.bajax.services;

import java.util.List;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.DadosInvalidosException;

public class ClienteService {

	private List<Cliente> clientesDoBanco;

	public ClienteService(List<Cliente> clientesDoBanco) {
		this.clientesDoBanco = clientesDoBanco;
	}

	public List<Cliente> getClientesDoBanco() {
		return clientesDoBanco;
	}

//	public Object pesquisaCliente(String cpf) {
//		Stream<Cliente> cliente = clientesDoBanco.stream().filter(c -> c.getCpf() == cpf);
//	}

	public Object pesquisaCliente(String cpf) {
		if (!validaCpf(cpf)) {
			throw new DadosInvalidosException("CPF inválido!");
		}
		for (Cliente cliente : clientesDoBanco) {
			if (cliente.getCpf() == cpf) {
				return cliente;
			}
		}
		return "Cliente não encontrado!";
	}

	public String adicionaCliente(Cliente novoCliente) {
		if (novoCliente == null) {
			throw new DadosInvalidosException("Cliente não deve ser nulo!");
		}
		clientesDoBanco.add(novoCliente);
		return "Cliente adicionado com sucesso!";
	}

	public String removeCliente(String cpf) {
		if (!validaCpf(cpf)) {
			throw new DadosInvalidosException("CPF inválido!");
		}
		for (Cliente cliente : clientesDoBanco) {
			if (cliente.getCpf() == cpf) {
				clientesDoBanco.remove(cliente);
				return "Cliente removido com sucesso!";
			}
		}
		return "Cliente não encontrado";
	}

	public String verificaCliente(String cpf) {
		if (!validaCpf(cpf)) {
			throw new DadosInvalidosException("CPF inválido!");
		}
		for (Cliente cliente : clientesDoBanco) {
			if (cliente.getCpf() == cpf && cliente.getAtivo() == true) {
				return "Cliente ativo";
			} else if (cliente.getCpf() == cpf && cliente.getAtivo() == false) {
				return "Cliente inativo";
			}
		}
		return "Cliente não encontrado";
	}

	public String limparLista() {
		clientesDoBanco.clear();
		return "Lista limpa com sucesso!";
	}

	public boolean validaCpf(String cpf) {
		if (cpf == null || cpf.isEmpty() || cpf.trim().isEmpty()) {
			return false;
		}
		if (!cpf.matches("^[0-9]{3}[\\.]?[\\/]?[-]?[0-9]{3}[\\.]?[\\/]?[-]?[0-9]{3}[\\.]?[\\/]?[-]?[0-9]{2}$")) {
			return false;
		}
		return true;
	}
}
