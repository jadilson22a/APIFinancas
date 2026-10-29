package com.github.jadilson22a.APIFinanceira.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.jadilson22a.APIFinanceira.model.Divida;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record DividaDTOEntrada(
		@NotBlank(message = "Nome não pode estar vazio!")
		String nome, 
		
		@NotNull(message = "Preco e obrigatorio")
		@Min(value = 1 ,message = "Preco não pode ser negativo ou zero")
		BigDecimal valor,
		
		@NotNull
		LocalDate dataVencimento) {

	
	public Divida toDivida() {
		return new Divida(nome, valor, dataVencimento);
	}
}
