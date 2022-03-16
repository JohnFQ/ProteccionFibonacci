package co.com.proteccion.pruebaTecnica.PruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.proteccion.pruebaTecnica.PruebaTecnica.service.pruebaFibonacci;

@RestController
@RequestMapping("/serieFibonacci")
public class pruebaFibonacciController {
	
	@Autowired
	private pruebaFibonacci pruebaFibonacci;
	
	@GetMapping(produces = {"application/json"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public int[] seriefibonacci() {
		return pruebaFibonacci.serieFibonacci();
	}
}
