package com.github.jadilson22a.APIFinanceira.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.jadilson22a.APIFinanceira.model.Divida;



public record DividaDTOEntrada(
		String nome, 
		BigDecimal valor,
		LocalDate dataVencimento) {

	
	public Divida toDivida() {
		return new Divida(nome, valor, dataVencimento);
	}
}
