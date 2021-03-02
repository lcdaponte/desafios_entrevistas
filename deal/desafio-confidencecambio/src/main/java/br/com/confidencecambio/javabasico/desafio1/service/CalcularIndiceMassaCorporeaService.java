package br.com.confidencecambio.javabasico.desafio1.service;

import org.springframework.stereotype.Service;

@Service
public class CalcularIndiceMassaCorporeaService {
	
	public double execute(double peso, double altura){
		
		double imc = peso/(Math.pow(altura, 2));
		
		return imc;
	}

}
