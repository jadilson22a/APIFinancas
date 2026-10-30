package com.github.jadilson22a.APIFinanceira.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.jadilson22a.APIFinanceira.model.CronogramaPagamento;
import com.github.jadilson22a.APIFinanceira.model.Divida;
import com.github.jadilson22a.APIFinanceira.repository.CronogramaPagamentoRepository;

@Service
public class CronogramaPagamentoService {

	private CronogramaPagamentoRepository repository;
	private DividaService dividaService;

	public CronogramaPagamentoService(CronogramaPagamentoRepository repository) {
		this.repository = repository;
	}
	
	public void criar(CronogramaPagamentoDTOEntrada dto) {
		List<Divida> dividas = dto.IdsDividas()
				.stream()
				.map(x -> dividaService.buscar(x).toDivida())
				.toList();
		
		CronogramaPagamento cp = new CronogramaPagamento(dto.titulo(), dto.data(), dividas);
		
		repository.save(cp);
	}
}
