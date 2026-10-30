package com.github.jadilson22a.APIFinanceira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jadilson22a.APIFinanceira.service.CronogramaPagamentoDTOEntrada;
import com.github.jadilson22a.APIFinanceira.service.CronogramaPagamentoDTORetorno;
import com.github.jadilson22a.APIFinanceira.service.CronogramaPagamentoService;

@RestController
@RequestMapping("/cronograma")
public class CronogramaPagamentoController {

	private CronogramaPagamentoService service;

	public CronogramaPagamentoController(CronogramaPagamentoService service) {
		this.service = service;
	}
	
	@PostMapping()
	public ResponseEntity<CronogramaPagamentoDTORetorno> criar(CronogramaPagamentoDTOEntrada
			dto){
		service.criar(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
