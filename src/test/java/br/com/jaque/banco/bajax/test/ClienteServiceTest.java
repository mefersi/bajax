package br.com.jaque.banco.bajax.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.entities.DadosInvalidosException;
import br.com.jaque.banco.bajax.services.ClienteService;

public class ClienteServiceTest {

	Cliente c1 = new Cliente("Yuri Azul", "yuri@gmail.com", "123.456.789-10", true);
	Cliente c2 = new Cliente("Julia Rosa", "julia@gmail.com", "123.456.789.11", false);

	@Test
	public void pesquisaClienteAtivoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.pesquisaCliente(c1.getCpf()), c1);
	}

	@Test
	public void pesquisaClienteInativoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c2);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.pesquisaCliente(c2.getCpf()), c2);
	}

	@Test
	public void pesquisaClienteCpfNulo() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.pesquisaCliente(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void pesquisaClienteCpfVazio() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.pesquisaCliente("");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void pesquisaClienteCpfComEspacos() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.pesquisaCliente(" ");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void pesquisaClienteCpfComCaracteresEspeciais() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.pesquisaCliente("@");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void pesquisaClienteCpfComTamanhoMaiorQueOEspecificado() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.pesquisaCliente("123.456.789-101");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void pesquisaClienteCpfComTamanhoMenorQueOEspecificado() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.pesquisaCliente("123.456.789-1");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void pesquisaClienteNaoEncontrado() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);
		listaClientes.add(c2);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.pesquisaCliente("123.456.789-16"), "Cliente não encontrado!");
	}

	@Test
	public void adicionaClienteAtivoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.adicionaCliente(c1), "Cliente adicionado com sucesso!");
	}

	@Test
	public void adicionaClienteInativoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.adicionaCliente(c2), "Cliente adicionado com sucesso!");
	}

	@Test
	public void adicionaClienteNulo() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.adicionaCliente(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("Cliente não deve ser nulo!", e.getMessage());
		}
	}

	@Test
	public void removeClienteAtivoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.removeCliente(c1.getCpf()), "Cliente removido com sucesso!");
	}

	@Test
	public void removeClienteInativoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c2);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.removeCliente(c2.getCpf()), "Cliente removido com sucesso!");
	}

	@Test
	public void removeClienteCpfNulo() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.removeCliente(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void removeClienteCpfVazio() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.removeCliente("");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void removeClienteCpfComEspacos() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.removeCliente(" ");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void removeClienteCpfComCaracteresEspeciais() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.removeCliente("@");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void removeClienteCpfNaoEncontrado() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.removeCliente("123.456.789-16"), "Cliente não encontrado");
	}

	@Test
	public void verificaClienteAtivoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.verificaCliente(c1.getCpf()), "Cliente ativo");
	}

	@Test
	public void verificaClienteInativoComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);
		listaClientes.add(c2);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.verificaCliente(c2.getCpf()), "Cliente inativo");
	}

	@Test
	public void verificaClienteCpfNulo() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.verificaCliente(null);
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void verificaClienteCpfVazio() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.verificaCliente("");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void verificaClienteCpfComEspacos() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.verificaCliente(" ");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void verificaClienteCpfComCaracteresEspeciais() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		try {
			clienteService.verificaCliente("@");
			fail();
		} catch (DadosInvalidosException e) {
			assertEquals("CPF inválido!", e.getMessage());
		}
	}

	@Test
	public void limpaListaComSucesso() {

		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes.add(c1);

		ClienteService clienteService = new ClienteService(listaClientes);

		assertEquals(clienteService.limparLista(), "Lista limpa com sucesso!");
	}
}
