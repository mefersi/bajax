package br.com.jaque.banco.bajax.entities;

public class Endereco {

	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;

	public Endereco(String rua, String numero, String bairro, String cep, String cidade, String estado, String pais) {
		if (!validaEndereco(rua, numero, bairro, cep, cidade, estado, pais)) {
			throw new DadosInvalidosException("Dados inválidos!");
		}
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getPais() {
		return pais;
	}

	public boolean validaEndereco(String rua, String numero, String bairro, String cep, String cidade, String estado,
			String pais) {
		if (rua == null || numero == null || bairro == null || cep == null || cidade == null || estado == null || pais == null
				|| rua.isEmpty() || numero.isEmpty() || bairro.isEmpty() || cep.isEmpty() || cidade.isEmpty()
				|| estado.isEmpty() || pais.isEmpty() || rua.trim().isEmpty() || numero.trim().isEmpty()|| bairro.trim().isEmpty()
				|| cep.trim().isEmpty() || cidade.trim().isEmpty() || estado.trim().isEmpty()
				|| pais.trim().isEmpty()) {
			return false;
		}
		if (!rua.matches("^[A-Za-zãáí0-9\\s]*$") || !numero.matches("^[A-Za-z0-9\\s]*$") || !bairro.matches("^[A-Za-zãáí0-9\\s]*$")
				|| !cep.matches("^[0-9\\-\\.\\/\\s]{8,9}$") || !cidade.matches("^[A-Za-zãíá\\s]*$")
				|| !estado.matches("^[A-Za-zãíá\\s]*$") || !pais.matches("^[A-Za-zãíá\\s]*$")) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado="
				+ estado + ", pais=" + pais + "]";
	}
}
