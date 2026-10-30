package com.github.jadilson22a.APIFinanceira.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.github.jadilson22a.APIFinanceira.model.Divida;



public record DividaDTORetorno(
		Integer id, 
		String nome, 
		BigDecimal valor,
		String dataVencimento,
		boolean pago) {

	
	public Divida toDivida() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return new Divida(id, nome, valor, LocalDate.parse(dataVencimento, dtf), pago);
	}
}
