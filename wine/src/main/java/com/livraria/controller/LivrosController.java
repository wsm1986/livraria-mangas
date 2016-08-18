package com.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.livraria.model.Livro;
import com.livraria.repository.Livros;
import com.livraria.service.CadastroLivroService;

@Controller
@RequestMapping("/livro")
public class LivrosController {
	
	@Autowired
	private Livros livro;
	
	private Livro livroSelecionado;

	@Autowired
	private CadastroLivroService cadastroVinhoService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/livros/ListaLivro");
		mv.addObject("livros", livro.findAll());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(Livro livro) {
		ModelAndView mv = new ModelAndView("/livros/CadastroLivro");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Livro livro, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(livro);
		}
		
		cadastroVinhoService.salvar(livro);
		attributes.addFlashAttribute("mensagem", "Livro salvo com sucesso!");
		return new ModelAndView("redirect:/livro/novo");
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView visualizar(@PathVariable("codigo") Livro livro) {
		ModelAndView mv = new ModelAndView("/livros/DetalheLivro");
		mv.addObject("livro", livro);
		return mv;
	}
	@RequestMapping("/{codigo}/update/{livro}")
	public ModelAndView update(@PathVariable("livro") Livro livro) {
		ModelAndView mv = new ModelAndView("/livros/UpdateLivro");
		livroSelecionado = livro;
		mv.addObject("livro", livroSelecionado);
		return mv;
	}
	@RequestMapping(value = "/livro/salvar/{livro}", method = RequestMethod.POST)
	public ModelAndView alteracao(@PathVariable("codigo") Livro livro) {
		//cadastroVinhoService.salvar(livro);
		return new ModelAndView("redirect:/livro/novo");
	}
}
