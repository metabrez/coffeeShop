package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private PersonService personService;

	@Autowired
	private ProductService productService;

	@GetMapping({ "/" })
	public String homePage(Model model) {
		model.addAttribute("lst", productService.getAllProduct());
		return "home";
	}

	@GetMapping({ "/secure" })
	public String securePage() {
		return "secure";
	}
}
