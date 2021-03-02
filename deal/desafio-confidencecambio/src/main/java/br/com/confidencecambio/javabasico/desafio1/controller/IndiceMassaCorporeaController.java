package br.com.confidencecambio.javabasico.desafio1.controller;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.desafio1.service.CalcularIndiceMassaCorporeaService;

@RestController
@Validated
public class IndiceMassaCorporeaController {
	
	@Autowired
	private CalcularIndiceMassaCorporeaService calcularIndiceMassaCorporeaService;

	
	@GetMapping("/imc")
	public ResponseEntity<Double> calcularIMC(@RequestParam @Positive double peso, 
											  @RequestParam @Positive double altura){
		
		Double imc = calcularIndiceMassaCorporeaService.execute(peso, altura);
		
		return new ResponseEntity<Double>(imc, HttpStatus.OK);
	}
}
