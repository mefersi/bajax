package br.com.banco.bajax.steps;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import br.com.jaque.banco.bajax.entities.Cliente;
import br.com.jaque.banco.bajax.services.ClienteService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ClienteSteps {

	String nome;
	String email;
	String cpf;
	boolean seAtivo;
	Cliente cliente;
	List<String> clientes;
	ClienteService cs;
	List<Map<String, String>> linhas;

	@Dado("que possuo as informações válidas de um individuo")
	public void quePossuoAsInformaçõesVálidasDeUmIndividuo() {
		nome = "Yuri";
		email = "yuri@gmail.com";
		cpf = "123456789-11";
		seAtivo = true;
		System.out.println("teste lalalala");
	}

	@Quando("crio um cliente com essas informações")
	public void crioUmClienteComEssasInformações() {
		cliente = new Cliente(nome, email, cpf, seAtivo);
		assertNull(cliente);
	}

	@Então("o cliente é cadastrado com sucesso")
	public void oClienteÉCadastradoComSucesso() {
		assertEquals(cliente.getNome(), nome);
		assertEquals(cliente.getEmail(), email);
		assertEquals(cliente.getCpf(), cpf);
		assertEquals(cliente.getAtivo(), seAtivo);
	}

	@Dado("que possuo as informações para criar um cliente a partir da lista")
	public void quePossuoAsInformaçõesParaCriarUmClienteAPartirDaLista(DataTable dataTable) {

		List<List<String>> rows = dataTable.asLists(String.class);
		
		for(List<String> row : rows) {
			System.out.println(row.get(0));
		}
		
		
		
		
		
		clientes = dataTable.asList();
		System.out.println(clientes);

		linhas = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> colunas : linhas) {
			Cliente c1 = new Cliente(colunas.get("nome"), colunas.get("email"), colunas.get("cpf"),
					Boolean.valueOf(colunas.get("ativo")));
			assertEquals(c1.getNome(), "1");
		}

	}

	@Quando("adiciono um campo como nulo")
	public void adicionoUmCampoComoNulo(io.cucumber.datatable.DataTable dataTable) {
		
		linhas = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> colunas : linhas) {
			Cliente c2 = new Cliente(colunas.get("nome"), colunas.get("email"), colunas.get("cpf"),
					Boolean.valueOf(colunas.get("ativo")));
		}
		
	}

	@Então("ao tentar criar o cliente recebo uma mensagem de erro")
	public void aoTentarCriarOClienteReceboUmaMensagemDeErro() {
		
		
	    System.out.println("jaque");
	}

}
