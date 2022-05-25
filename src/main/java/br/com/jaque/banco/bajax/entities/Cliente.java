package br.com.jaque.banco.bajax.entities;

public class Cliente {

	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private Endereco endereco;
	private Boolean ativo;

	public Cliente(String nome, String email, String cpf, Boolean ativo) {
		validaCliente(nome, email, cpf, ativo);
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String setTelefone(String telefone) {
		if (telefone == null || !telefone.matches("^[0-9\\(\\)\\-\\s]*$")) {
			throw new DadosInvalidosException("Telefone inválido tente novamente!");
		}
		this.telefone = telefone;
		return "Telefone adicionado com sucesso!";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		if (ativo == null) {
			throw new DadosInvalidosException("Campos obrigatórios não devem ser nulos!");
		}
		this.ativo = ativo;
	}

	public void validaCliente(String nome, String email, String cpf, Boolean ativo) {
		if (nome == null || email == null || cpf == null || ativo == null || nome.isEmpty() || email.isEmpty()
				|| cpf.isEmpty() || nome.trim().isEmpty() || email.trim().isEmpty() || cpf.trim().isEmpty()) {
			throw new DadosInvalidosException("Dados inválidos!");
		}
		if (!nome.matches("^[A-Za-zãáí\\s]*$")) {
			throw new DadosInvalidosException("Nome inválido tente novamente!");
		}
		if (!email.matches("^[a-z0-9\\-\\.\\_]+@[a-z]+\\.[a-z]+(\\.[a-z]+)?$")) {
			throw new DadosInvalidosException("Email inválido tente novamente!");
		}
		if (!cpf.matches("^[0-9]{3}[\\.]?[\\/]?[-]?[0-9]{3}[\\.]?[\\/]?[-]?[0-9]{3}[\\.]?[\\/]?[-]?[0-9]{2}$")) {
			throw new DadosInvalidosException("CPF inválido tente novamente!");
		}
	}

	@Override
	public String toString() {
		return nome + ", email = " + email + ", cpf = " + cpf + ", cliente ativo = " + ativo;
	}
}
