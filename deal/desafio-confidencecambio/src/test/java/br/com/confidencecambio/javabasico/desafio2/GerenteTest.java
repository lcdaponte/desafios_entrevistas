package br.com.confidencecambio.javabasico.desafio2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GerenteTest {
	
	@Test
	public void deveRetornarPrimeiroNome() {
		
		Gerente gerente = new Gerente("Louise Tahim Sidou Cavalcante");
		
		assertEquals("Louise", gerente.retornarPrimeiroNome());
	}
	
	@Test
	public void deveRetornarUltimoNome() {
		
		Gerente gerente = new Gerente("Louise Tahim Sidou Cavalcante");
		
		assertEquals("Cavalcante", gerente.retornarUltimoNome());
	}
	
	@Test
	public void deveRetornarNomeTodoMaiusculo() {
		
		Gerente gerente = new Gerente("Louise Tahim Sidou Cavalcante");
		
		assertEquals("LOUISE TAHIM SIDOU CAVALCANTE", gerente.retornarNomeTodoMaiusculo());
	}
	
	@Test
	public void deveRetornarSemNomeAbreviado() {
		
		Gerente gerente = new Gerente("Louise Cavalcante");
		
		assertEquals("Louise Cavalcante", gerente.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeComUmAbreviado() {
		
		Gerente gerente = new Gerente("Louise Tahim Cavalcante");
		
		assertEquals("Louise T. Cavalcante", gerente.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeComMaisDeUmAbreviado() {
		
		Gerente gerente = new Gerente("Louise Tahim Sidou Cavalcante");
		
		assertEquals("Louise T. S. Cavalcante", gerente.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeNulo() {
		
		Gerente gerente = new Gerente(null);
		
		assertEquals(false, gerente.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeVazio() {
		
		Gerente gerente = new Gerente("");
		
		assertEquals(false, gerente.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeIniciandoETerminandoComEspacos() {
		
		Gerente gerente = new Gerente(" Louise Tahim ");
		
		assertEquals(false, gerente.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeValido() {
		
		Gerente gerente = new Gerente("Louise Tahim Sidou Cavalcante");
		
		assertEquals(true, gerente.isNomeValido());
	}

}
