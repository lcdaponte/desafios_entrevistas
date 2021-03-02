package br.com.confidencecambio.javabasico.desafio2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClienteTest {
	
	@Test
	public void deveRetornarPrimeiroNome() {
		
		Cliente cliente = new Cliente("João Soares Silva");
		
		assertEquals("João", cliente.retornarPrimeiroNome());
	}
	
	@Test
	public void deveRetornarUltimoNome() {
		
		Cliente cliente = new Cliente("João Soares Silva");
		
		assertEquals("Silva", cliente.retornarUltimoNome());
	}
	
	@Test
	public void deveRetornarNomeTodoMaiusculo() {
		
		Cliente cliente = new Cliente("João Soares Silva");
		
		assertEquals("JOÃO SOARES SILVA", cliente.retornarNomeTodoMaiusculo());
	}
	
	@Test
	public void deveRetornarSemNomeAbreviado() {
		
		Cliente cliente = new Cliente("João Silva");
		
		assertEquals("João Silva", cliente.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeComUmAbreviado() {
		
		Cliente cliente = new Cliente("João Soares Silva");
		
		assertEquals("João S. Silva", cliente.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeComMaisDeUmAbreviado() {
		
		Cliente cliente = new Cliente("João Soares Augusto Silva");
		
		assertEquals("João S. A. Silva", cliente.retornarNomeAbreviado());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeNulo() {
		
		Cliente cliente = new Cliente(null);
		
		assertEquals(false, cliente.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeVazio() {
		
		Cliente cliente = new Cliente("");
		
		assertEquals(false, cliente.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeNaoValidoComNomeIniciandoETerminandoComEspacos() {
		
		Cliente cliente = new Cliente(" João Soares ");
		
		assertEquals(false, cliente.isNomeValido());
	}
	
	@Test
	public void deveRetornarNomeValido() {
		
		Cliente cliente = new Cliente("João Soares Augusto Silva");
		
		assertEquals(true, cliente.isNomeValido());
	}

}
