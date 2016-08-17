package com.livraria.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.livraria.dto.Financeiro;
import com.livraria.model.Livro;
import com.livraria.repository.Livros;

@Controller
@RequestMapping("/financeiro")
public class FinanceiroController {
	
	@Autowired
	private Livros livro;
	
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/livros/Financeiro");
		List<Livro> lista = livro.findAll();
		Financeiro fin;
		List<Financeiro> listaF = new ArrayList<>();
		for (Livro livro : lista) {
			fin = new Financeiro();
			fin.setNomeLivro(livro.getNome());
			fin.setValor(livro.getValor());
			fin.setTotalLivro(livro.getValor().multiply(new BigDecimal(livro.getVolume())));
			fin.setFaltaComprar(livro.getValor().multiply(new BigDecimal(livro.getVolume() - livro.getUlt_vol_comprado())));
			fin.setQuantLivro(livro.getUlt_vol_comprado());
			fin.setTotalaSerGasto(livro.getValor().multiply(new BigDecimal(livro.getUlt_vol_comprado())));
			listaF.add(fin);
		}
		mv.addObject("financeiro", listaF);
		return mv;
	}
	
	
}
