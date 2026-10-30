package com.github.jadilson22a.APIFinanceira.service;

import java.time.LocalDate;
import java.util.List;

public record CronogramaPagamentoDTOEntrada(
		String titulo, 
		LocalDate data, 
		List<Integer> IdsDividas) {

}
