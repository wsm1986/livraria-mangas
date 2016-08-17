package com.livraria.dto;

import java.math.BigDecimal;

public class Financeiro {

	private String nomeLivro;
	private BigDecimal valor;
	private Integer quantLivro;
	private BigDecimal totalLivro;
	private BigDecimal faltaComprar;
	private BigDecimal totalaSerGasto;

	public BigDecimal getTotalLivro() {
		return totalLivro;
	}

	public void setTotalLivro(BigDecimal totalLivro) {
		this.totalLivro = totalLivro;
	}

	public BigDecimal getFaltaComprar() {
		return faltaComprar;
	}

	public void setFaltaComprar(BigDecimal faltaComprar) {
		this.faltaComprar = faltaComprar;
	}

	public Integer getQuantLivro() {
		return quantLivro;
	}

	public void setQuantLivro(Integer quantLivro) {
		this.quantLivro = quantLivro;
	}

	public BigDecimal getTotalaSerGasto() {
		return totalaSerGasto;
	}

	public void setTotalaSerGasto(BigDecimal totalaSerGasto) {
		this.totalaSerGasto = totalaSerGasto;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
