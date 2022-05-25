package br.com.jaque.banco.bajax.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.DadosInvalidosException;
import br.com.jaque.banco.bajax.entities.Endereco;

public class ClienteTest {

	String nome = "Yuri Azul";
	String email = "yuri@gmail.com";
	String cpf = "789456123-90";

	Cliente cliente = new Cliente(nome, email, cpf, true);

	String rua = "Rua Oliveiras";
	String numero = "77A";
	String bairro = "Laranjeiras";
	String cep = "04506020";
	String cidade = "Lua";
	String estado = "São Paulo";
	String pais = "Brasil";

	@Test
	public void criaClienteAtivoComSucesso() {

		Cliente cliente = new Cliente(nome, email, cpf, true);

		assertEquals(cliente.getNome(), nome);
		assertEquals(cliente.getEmail(), email);
		assertEquals(cliente.getCpf(), cpf);
		assertTrue(cliente.getAtivo());
	}

	@Test
	public void criaClienteInativoComSucesso() {

		Cliente cliente = new Cliente(nome, email, cpf, false);

		assertEquals(cliente.getNome(), nome);
		assertEquals(cliente.getEmail(), email);
		assertEquals(cliente.getCpf(), cpf);
		assertFalse(cliente.getAtivo());
	}

	@Test
	public void nomeInvalidoNulo() {

		nome = null;

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void nomeInvalidoVazio() {

		nome = "";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void nomeInvalidoComEspacos() {

		nome = " ";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void nomeInvalidoComNumeros() {

		nome = "123";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Nome inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void nomeInvalidoComCarcateresEspeciais() {

		nome = "@";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Nome inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void emailInvalidoNulo() {

		email = null;

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void emailInvalidoVazio() {

		email = "";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void emailInvalidoComEspacos() {

		email = " ";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void emailInvalidoComNumeros() {

		email = "123";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Email inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void emailInvalidoComCaracteresEspeciais() {

		email = "@";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Email inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void emailInvalidoSóComLetras() {

		email = "aaa";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Email inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void cpfInvalidoNulo() {

		cpf = null;

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void cpfInvalidoVazio() {

		cpf = "";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void cpfInvalidoComEspacos() {

		cpf = " ";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void cpfInvalidoComLetras() {

		cpf = "abc";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void cpfValidoTamanhoMaximo() {

		cpf = "123.456.789-10";

		Cliente cliente = new Cliente(nome, email, cpf, true);

		assertEquals(cliente.getCpf(), cpf);
	}

	@Test
	public void cpfInvalidoTamanhoMaiorQueOMaximo() {

		cpf = "123.456.789-101";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void cpfValidoTamanhoMinimo() {

		cpf = "12345678980";

		Cliente cliente = new Cliente(nome, email, cpf, true);

		assertEquals(cliente.getCpf(), cpf);
	}

	@Test
	public void cpfInvalidoTamanhoMenorQueOMinimo() {

		cpf = "1234567898";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void cpfInvalidoComCaracteresEspeciais() {

		cpf = "@";

		try {
			Cliente cliente = new Cliente(nome, email, cpf, true);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void telefoneValido() {

		Cliente cliente = new Cliente(nome, email, cpf, true);

		assertEquals(cliente.setTelefone("(11)952485080"), "Telefone adicionado com sucesso!");
	}

	@Test
	public void telefoneIvalidoLetras() {

		try {
			cliente.setTelefone("abc");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Telefone inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void telefoneIvalidoCaracteresEspeciais() {

		try {
			cliente.setTelefone("@");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Telefone inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void telefoneIvalidoNulo() {

		try {
			cliente.setTelefone(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Telefone inválido tente novamente!", e.getMessage());
		}
	}

	@Test
	public void enderecoValido() {

		Cliente cliente = new Cliente(nome, email, cpf, true);

		Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
		cliente.setEndereco(endereco);

		assertEquals(cliente.getEndereco().getRua(), rua);
		assertEquals(cliente.getEndereco().getNumero(), numero);
		assertEquals(cliente.getEndereco().getBairro(), bairro);
		assertEquals(cliente.getEndereco().getCep(), cep);
		assertEquals(cliente.getEndereco().getCidade(), cidade);
		assertEquals(cliente.getEndereco().getEstado(), estado);
		assertEquals(cliente.getEndereco().getPais(), pais);
	}

	@Test
	public void enderecoInvalidoRuaNulo() {

		rua = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoRuaVazio() {

		rua = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoRuaComEspacos() {

		rua = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoRuaCaracteresEspeciais() {

		rua = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoNumeroNulo() {

		numero = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoNumeroVazio() {

		numero = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoNumeroComEspacos() {

		numero = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoNumeroComCaracteresEspeciais() {

		numero = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoBairroNulo() {

		bairro = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoBairroVazio() {

		bairro = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoBairroComEspacos() {

		bairro = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoBairroComCaracteresEspeciais() {

		bairro = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCepNulo() {

		cep = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCepVazio() {

		cep = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCepComEspacos() {

		cep = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCepComCaracteresEspeciais() {

		cep = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoValidoCepTamanhoMin() {

		cep = "12345678";

		Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
		cliente.setEndereco(endereco);

		assertEquals(cliente.getEndereco().getRua(), rua);
		assertEquals(cliente.getEndereco().getNumero(), numero);
		assertEquals(cliente.getEndereco().getBairro(), bairro);
		assertEquals(cliente.getEndereco().getCep(), cep);
		assertEquals(cliente.getEndereco().getCidade(), cidade);
		assertEquals(cliente.getEndereco().getEstado(), estado);
		assertEquals(cliente.getEndereco().getPais(), pais);
	}

	@Test
	public void enderecoInvalidoCepTamanhoMenorQueOMinimo() {

		cep = "123";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoValidoCepTamanhoMaximo() {

		cep = "123456789";

		Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
		cliente.setEndereco(endereco);

		assertEquals(cliente.getEndereco().getRua(), rua);
		assertEquals(cliente.getEndereco().getNumero(), numero);
		assertEquals(cliente.getEndereco().getBairro(), bairro);
		assertEquals(cliente.getEndereco().getCep(), cep);
		assertEquals(cliente.getEndereco().getCidade(), cidade);
		assertEquals(cliente.getEndereco().getEstado(), estado);
		assertEquals(cliente.getEndereco().getPais(), pais);
	}

	@Test
	public void enderecoInvalidoCepTamanhoMaiorQueOMaximo() {

		cep = "1234567891";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCidadeNulo() {

		cidade = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCidadeVazio() {

		cidade = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCidadeComEspacos() {

		cidade = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoCidadeComCaracteresEspeciais() {

		cidade = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoEstadoNulo() {

		estado = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoEstadoVazio() {

		estado = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoEstadoComEspacos() {

		estado = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoEstadoComCaracteresEspeciais() {

		estado = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoPaisNulo() {

		pais = null;

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoPaisVazio() {

		pais = "";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoPaisComEspacos() {

		pais = " ";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void enderecoInvalidoPaisComCaracteresEspeciais() {

		pais = "@";

		try {
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			cliente.setEndereco(endereco);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Dados inválidos!", e.getMessage());
		}
	}

	@Test
	public void setAtivoNulo() {

		try {
			cliente.setAtivo(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Campos obrigatórios não devem ser nulos!", e.getMessage());
		}
	}
}
