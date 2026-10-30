package com.github.jadilson22a.APIFinanceira.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jadilson22a.APIFinanceira.entity.DividaDTOEntrada;
import com.github.jadilson22a.APIFinanceira.entity.DividaDTORetorno;
import com.github.jadilson22a.APIFinanceira.service.DividaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/divida")
public class DividaController {

	private DividaService service;

	public DividaController(DividaService service) {
		this.service = service;
	}
	
	@PostMapping()
	public ResponseEntity<DividaDTORetorno> criar(@Valid @RequestBody DividaDTOEntrada dto){
		service.salvar(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DividaDTORetorno> atualizar(@PathVariable("id") Integer id, @Valid @RequestBody DividaDTOEntrada dto){
		return new ResponseEntity<DividaDTORetorno>(service.atualizar(id, dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DividaDTORetorno> excluir(@PathVariable("id") Integer id){
		service.excluir(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<DividaDTORetorno> buscar(@PathVariable("id") Integer id){
		return new ResponseEntity<DividaDTORetorno>(service.buscar(id), HttpStatus.OK);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<DividaDTORetorno>> buscar(@PathVariable("nome") String nome){
		return new ResponseEntity<List<DividaDTORetorno>>(service.buscar(nome), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<DividaDTORetorno>> buscar(){
		return new ResponseEntity<List<DividaDTORetorno>>(service.buscarTudo(), HttpStatus.OK);
	}
	
	@GetMapping("/pago/{pago}")
	public ResponseEntity<List<DividaDTORetorno>> buscar(@PathVariable("pago") boolean pago){
		return new ResponseEntity<List<DividaDTORetorno>>(service.buscar(pago), HttpStatus.OK);
	}
	
	@PutMapping("/pagar/{id}")
	public ResponseEntity<DividaDTORetorno> pagar(@PathVariable("id") Integer id){
		return new ResponseEntity<DividaDTORetorno>(service.pagarDivida(id), HttpStatus.OK);
	}
}
