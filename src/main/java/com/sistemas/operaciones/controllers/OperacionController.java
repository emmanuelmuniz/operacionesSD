package com.sistemas.operaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OperacionController {

	@Autowired
	private RestTemplate clienteRest;
	
	@GetMapping("/sumar-usa")
	public String sumarUsa(@RequestParam float a, @RequestParam float b) {
		
		String resultado = Float.toString(a + b);
		
		return clienteRest.getForObject("https://emmamuniz-resultados-sd-eu.herokuapp.com/resultado/" + resultado, String.class);
	}
	
	@GetMapping("/restar-usa")
	public String restarUsa(@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a - b);
		
		return clienteRest.getForObject("https://emmamuniz-resultados-sd-eu.herokuapp.com/resultado/" + resultado, String.class);
	}

	@GetMapping("/sumar-eu")
	public String sumarEu(@RequestParam float a, @RequestParam float b) {

		String resultado = Float.toString(a + b);

		return clienteRest.getForObject("https://emmamuniz-resultados-sd-eu.herokuapp.com/resultado/" + resultado, String.class);
	}

	@GetMapping("/restar-eu")
	public String restarEu(@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a - b);

		return clienteRest.getForObject("https://emmamuniz-resultados-sd-eu.herokuapp.com/resultado/" + resultado, String.class);
	}
}
