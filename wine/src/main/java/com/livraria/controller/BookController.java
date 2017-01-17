package com.livraria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/aqui")
@Controller
public class BookController {

	final Logger logger = LoggerFactory.getLogger(BookController.class);

	/**
	 * List all books.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("Listing books");

		model.addAttribute("books", "");

		return "books/list";
	}

}
