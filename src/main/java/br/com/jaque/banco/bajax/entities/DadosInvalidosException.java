package br.com.jaque.banco.bajax.entities;

public class DadosInvalidosException extends RuntimeException {
	private static final long serialVersionUID = 1169378003599229797L;

	public DadosInvalidosException(String msg) {
		super(msg);
	}
}
