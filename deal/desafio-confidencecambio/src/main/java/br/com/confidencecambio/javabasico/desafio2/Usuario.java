package br.com.confidencecambio.javabasico.desafio2;

import java.util.stream.Stream;

public class Usuario {
	
	private String nomeCompleto;
	
	public Usuario(String nomeCompleto){
		this.nomeCompleto = nomeCompleto;
	}
	
	
	public String retornarPrimeiroNome() {
		String primeiroNome = Stream.of(this.nomeCompleto)
										.map(nome -> nome.split(" ")[0])
										.findFirst()
										.orElseThrow(); 
		return primeiroNome;
	}

	
	public String retornarUltimoNome() {
		String ultimoNome = Stream.of(this.nomeCompleto)
										.map(nome -> nome.split(" "))
										.map(array -> array[array.length - 1])
										.findFirst()
										.orElseThrow();
		return ultimoNome;
	}

	
	public String retornarNomeTodoMaiusculo() {
		return this.nomeCompleto.toUpperCase();
	}

	
	public String retornarNomeAbreviado() {
		String[] nomes = this.nomeCompleto.split((" "));
		
		if(nomes.length <= 2) {
			return this.nomeCompleto;
		}else {
			for(int i = 0; i < nomes.length; i++) {
				if(i != 0 && i != nomes.length - 1) {
					nomes[i] = nomes[i].substring(0, 1) + ".";
				}
			}
			return String.join(" ", nomes);
		}
	}
	
	public boolean isNomeValido() {
		boolean isValido = true;
		
		if(this.nomeCompleto == null) {
			isValido = false;
			return isValido;
		}
		
		if(this.nomeCompleto.isBlank())
			isValido = false;
		
		if(!this.nomeCompleto.equalsIgnoreCase(this.nomeCompleto.trim()))
			isValido = false;
		
		
		return isValido;
	}

}
