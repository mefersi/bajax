package br.com.jaque.banco.bajax.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectClasses({ ClienteTest.class, ClienteServiceTest.class, ContaTest.class, ContaServiceTest.class })
@Suite
@SuiteDisplayName("Todos os testes do banco Bajax")
public class BajaxTestesSuiteTest {
}
