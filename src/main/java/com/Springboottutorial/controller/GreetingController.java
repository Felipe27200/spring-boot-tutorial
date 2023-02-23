package com.Springboottutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Las peticiones HTTP de Spring
 * son manejadas por controladores.
 * 
 * Para hacer una clase Controller
 * se debe usar esta anotación.
 * */
@Controller
public class GreetingController {
	/*
	 * +-------------+
	 * | GET REQUEST |
	 * +-------------+
	 * 
	 * Este método maneja una petición 
	 * GET para "/greeting", retornando 
	 * el nombre de la vista, en este caso greeting.
	 * 
	 * @GetMapping se asegura que la petición para /greeting
	 * sea mapped to the greeting() method.
	 * */
	@GetMapping("/greeting")
	public String greeting(
		/*
		 * +-----------------------------------------+
		 * | BIND QUERY STRING PARAMETERS OF THE URL |
		 * +-----------------------------------------+
		 * 
		 * Vincula el parámetro name del query string parameter
		 * dentro del parámetro name del método greeting().
		 * 
		 * El query string parameter no es obligatorio, sino es enviado
		 * se le asignará el valor por defecto "World"
		 * */
		@RequestParam(name="name", required=false, defaultValue="World")
		String name,
		Model model
	) {
		/*
		 * +-----------------------------+
		 * | VALUES TO THE VIEW TEMPLATE |
		 * +-----------------------------+
		 * 
		 * Finalmente, se asigna el valor del parámetro name
		 * al objeto Model, haciendolo disponible para la view
		 * template.
		 * 
		 * +------------------+
		 * | RENDERING A VIEW |
		 * +------------------+
		 * 
		 * La implementación del cuerpo de este método
		 * depende de la view technology, en este caso
		 * Thymeleaf para realizar el server-side
		 * rendering del HTML.
		 * */
		model.addAttribute("name", name);
		
		return "gretting";
	}
}
