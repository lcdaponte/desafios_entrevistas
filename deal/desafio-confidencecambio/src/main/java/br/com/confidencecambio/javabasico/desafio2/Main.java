package br.com.confidencecambio.javabasico.desafio2;

public class Main {
	
	public static void main(String[] args) {
		
		
		// CENARIO 01 - Cliente com nome nulo
		System.out.println("---------------CENARIO 01 - Cliente com nome nulo---------------");
		Cliente cliente01 = new Cliente(null);
		
		if(cliente01.isNomeValido()) {
			System.out.println(cliente01.retornarPrimeiroNome());
		}else {
			System.out.println("O nome esta nulo.");
		}
		System.out.println();
		
		
		// CENARIO 02 - Gerente com nome branco
		System.out.println("---------------CENARIO 02 - Gerente com nome branco---------------");
		Gerente gerente02 = new Gerente("");
		
		if(gerente02.isNomeValido()) {
			System.out.println(gerente02.retornarPrimeiroNome());
		}else {
			System.out.println("O nome esta em branco.");
		}
		System.out.println();
		
		// CENARIO 03 - Robo com nome com espacos
		System.out.println("---------------CENARIO 03 - Robo com nome com espacos---------------");
		Robo robo03 = new Robo(" Lucas Cavalcante ");
		
		if(robo03.isNomeValido()) {
			System.out.println(robo03.retornarPrimeiroNome());
		}else {
			System.out.println("O nome contem espacos invalidos.");
		}
		System.out.println();
		
		// CENARIO 04 - Cliente com primeiro nome
		System.out.println("---------------CENARIO 04 - Cliente com primeiro nome---------------");
		Cliente cliente04 = new Cliente("Gisele Tahim Sidou");
		
		if(cliente04.isNomeValido()) {
			System.out.println(cliente04.retornarPrimeiroNome());
		}else {
			System.out.println("O nome esta nulo.");
		}
		System.out.println();
		
		// CENARIO 05 - Gerente com ultimo nome
		System.out.println("---------------CENARIO 05 - Gerente com ultimo nome---------------");
		Gerente gerente05 = new Gerente("Gisele Tahim Sidou");
		
		if(gerente05.isNomeValido()) {
			System.out.println(gerente05.retornarUltimoNome());
		}else {
			System.out.println("Ocorreu um erro com a execucao.");
		}
		System.out.println();
		
		// CENARIO 06 - Robo com nome maiusculo
		System.out.println("---------------CENARIO 06 - Robo com nome maiusculo---------------");
		Robo robo06 = new Robo("Gisele Tahim Sidou");
		
		if(robo06.isNomeValido()) {
			System.out.println(robo06.retornarNomeTodoMaiusculo());
		}else {
			System.out.println("Ocorreu um erro com a execucao.");
		}
		System.out.println();
		
		// CENARIO 07 - Cliente com um nome abreviado
		System.out.println("---------------CENARIO 07 - Cliente com um nome abreviado---------------");
		Cliente cliente07 = new Cliente("Gisele Tahim Sidou");
		
		if(cliente07.isNomeValido()) {
			System.out.println(cliente07.retornarNomeAbreviado());
		}else {
			System.out.println("Ocorreu um erro com a execucao.");
		}
		System.out.println();
		
		// CENARIO 08 - Gerente com multiplos nomes abreviados
		System.out.println("---------------CENARIO 08 - Gerente com multiplos nomes abreviados---------------");
		Gerente gerente08 = new Gerente("Gisele Tahim Souza Brasil Othon Sidou");
		
		if(gerente08.isNomeValido()) {
			System.out.println(gerente08.retornarNomeAbreviado());
		}else {
			System.out.println("Ocorreu um erro com a execucao.");
		}
		System.out.println();
	}

}
