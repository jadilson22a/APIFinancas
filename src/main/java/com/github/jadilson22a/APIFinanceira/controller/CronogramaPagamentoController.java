package com.github.jadilson22a.APIFinanceira.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity<CronogramaPagamentoDTORetorno> criar(
			@RequestBody CronogramaPagamentoDTOEntrada dto){
		service.criar(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CronogramaPagamentoDTORetorno> buscarID(
			@PathVariable(name = "id") Integer id){
		return new ResponseEntity<CronogramaPagamentoDTORetorno>(
				service.buscar(id).toDTO(),	
				HttpStatus.OK);
	}
	
	@PutMapping("/adddivida/{id}")
	public ResponseEntity<CronogramaPagamentoDTORetorno> adicionarDivida(
			@PathVariable(name = "id") Integer cronogramaID,
			@RequestBody List<Integer> dividasId){
		service.adicionarDivida(cronogramaID, dividasId);
		return new ResponseEntity<CronogramaPagamentoDTORetorno>(HttpStatus.OK);
	}
}
