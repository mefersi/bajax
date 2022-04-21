package br.com.banco.bajax.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.jaque.banco.bajax.entities.Cliente;
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
	
	@Dado("que possuo as informações válidas de um individuo")
	public void quePossuoAsInformaçõesVálidasDeUmIndividuo() {
		nome = "Yuri";
		email = "yuri@gmail.com";
		cpf = "123456789-11";
		seAtivo = true;
	}

	@Quando("crio um cliente com essas informações")
	public void crioUmClienteComEssasInformações() {
		cliente = new Cliente(nome, email, cpf, seAtivo);
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
	
		List<String> clientes = dataTable.asList();
		System.out.println(clientes);
	}

	@Quando("adiciono o {string} vazio")
	public void adicionoOVazio(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Então("ao tentar criar o cliente recebo a mensagem de erro {string}")
	public void aoTentarCriarOClienteReceboAMensagemDeErro(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Quando("adiciono o {string} no formato inválido")
	public void adicionoONoFormatoInválido(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Dado("que tenho um cliente válido")
	public void queTenhoUmClienteVálido() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Quando("adiciono um telefone no formato inválido")
	public void adicionoUmTelefoneNoFormatoInválido() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Então("recebo uma mensagem de erro")
	public void receboUmaMensagemDeErro() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Quando("tento alterar o campo ativo para nulo")
	public void tentoAlterarOCampoAtivoParaNulo() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
