package br.com.banco.bajax.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/cadastrar_cliente.feature",
		glue = "br.com.banco.bajax.steps", 
		tags = "@cliente", 
		plugin = {"pretty", "summary"}, 
		monochrome = true, 
		snippets = CucumberOptions.SnippetType.CAMELCASE, 
		dryRun = false
		)
public class RunnerClienteTest {
}
