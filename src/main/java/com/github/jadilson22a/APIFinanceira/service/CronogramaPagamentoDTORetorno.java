package com.github.jadilson22a.APIFinanceira.service;

import java.time.LocalDate;
import java.util.List;

import com.github.jadilson22a.APIFinanceira.model.Divida;

public record CronogramaPagamentoDTORetorno(Integer id, String titulo, LocalDate data, List<Divida> dividas) {

}
