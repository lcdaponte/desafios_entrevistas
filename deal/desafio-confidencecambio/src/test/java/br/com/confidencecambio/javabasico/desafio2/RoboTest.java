package br.com.confidencecambio.javabasico.desafio2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RoboTest {
	
	@Test
	public void deveRetornarPrimeiroNome() {
		
		Robo robo = new Robo("Humberto Farias Castelo Branco");
		
		assertEquals("Humberto", robo.retornarPrimeiroNome());
	}
	
	@Test
	public void deveRetornarUltimoNome() {
		
		Robo robo = new Robo("Humberto Farias Castelo Branco");
		
		assertEquals("Branco", robo.retornarUltimoNome());
	}
	
	@Test
	public void deveRetornarNomeTodoMaiusculo() {
		
		Robo robo = new Robo("Humberto Farias Castelo Branco");
		
		assertEquals("HUMBERTO FARIAS CASTELO BRANCO", robo.retornarNomeTodoMaiusculo());
	}
	
	@Test
	public void deveRetornarSemNomeAbreviado() {
		
		Robo robo = new Robo("Humberto Castelo");
		
		assertEquals("Humberto Castelo", robo.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeComUmAbreviado() {
		
		Robo robo = new Robo("Humberto Farias Castelo");
		
		assertEquals("Humberto F. Castelo", robo.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeComMaisDeUmAbreviado() {
		
		Robo robo = new Robo("Humberto Farias Castelo Branco");
		
		assertEquals("Humberto F. C. Branco", robo.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeNulo() {
		
		Robo robo = new Robo(null);
		
		assertEquals(false, robo.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeVazio() {
		
		Robo robo = new Robo("");
		
		assertEquals(false, robo.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeIniciandoETerminandoComEspacos() {
		
		Robo robo = new Robo(" Humberto Farias ");
		
		assertEquals(false, robo.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeValido() {
		
		Robo robo = new Robo("Humberto Farias Castelo Branco");
		
		assertEquals(true, robo.isNomeValido());
	}

}
