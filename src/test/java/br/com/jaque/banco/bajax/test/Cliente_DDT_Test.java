package br.com.jaque.banco.bajax.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import br.com.jaque.banco.bajax.entities.Cliente;

public class Cliente_DDT_Test {

	@ParameterizedTest
	@CsvFileSource(files = "src/test/resources/csv/cliente.csv", useHeadersInDisplayName = true)
	public void deveDarErroDadosInvalidos(String nome, String email, String cpf, boolean se_ativo, String resultado) {
		try {
			Cliente cliente = new Cliente(nome, email, cpf, se_ativo);
			fail();
		} catch (Exception e) {
			System.out.println(e);
			assertEquals(resultado, e.getMessage());
		}
	}
}
