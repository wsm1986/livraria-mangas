package com.livraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.model.Livro;
import com.livraria.repository.Livros;

@Service
public class CadastroLivroService {

	@Autowired
	private Livros livro;
	
	
	public void salvar(Livro livro) {
		livro.setUlt_leitura(0);
		livro.setUlt_vol_comprado(0);
		this.livro.save(livro);
	}
}
