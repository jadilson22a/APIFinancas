package com.github.jadilson22a.APIFinanceira.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.jadilson22a.APIFinanceira.model.Divida;



public record DividaDTORetorno(
		Integer id, 
		String nome, 
		BigDecimal valor,
		LocalDate dataVencimento,
		boolean pago) {

	
	public Divida toDivida() {
		return new Divida(id, nome, valor, dataVencimento, pago);
	}
}
