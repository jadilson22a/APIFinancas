package com.github.jadilson22a.APIFinanceira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.jadilson22a.APIFinanceira.entity.DividaDTOEntrada;
import com.github.jadilson22a.APIFinanceira.entity.DividaDTORetorno;
import com.github.jadilson22a.APIFinanceira.exceptions.NullObjectException;
import com.github.jadilson22a.APIFinanceira.exceptions.ObjectExistsException;
import com.github.jadilson22a.APIFinanceira.model.Divida;
import com.github.jadilson22a.APIFinanceira.repository.DividaRepository;

@Service
public class DividaService {

	private DividaRepository repository;

	public DividaService(DividaRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(DividaDTOEntrada dto) {
		validacao(dto.toDivida());
		repository.save(dto.toDivida());
	}
	
	public DividaDTORetorno atualizar(Integer id, DividaDTOEntrada dto) {
		Divida divida = dto.toDivida();
		validacao(divida);
		divida.setId(id);
		
		repository.save(divida);
		
		return divida.toDTO();
	}
	
	public void excluir(Integer id) {
		buscar(id);
		repository.deleteById(id);
	}
	
	public DividaDTORetorno buscar(Integer id) {
		Optional<Divida> divida = repository.findById(id);
		
		if(divida.isEmpty()) {
			throw new NullObjectException("Divida não encontrada!");
		}
		
		return divida.get().toDTO();
	}
	
	public List<DividaDTORetorno> buscar(String nome) {
		List<Divida> dividas = repository.findByNome(nome);
		
		if(dividas.isEmpty()) {
			throw new NullObjectException("Divida não encontrada!");
		}
		
		return dividas.stream().map(x -> x.toDTO()).toList();
	}
	
	public List<DividaDTORetorno> buscarTudo(){
		return repository.findAll().stream().map(x -> x.toDTO()).toList();
	}
	
	public List<DividaDTORetorno> buscar(boolean pago){
		return repository.findByPago(pago).stream().map(x -> x.toDTO()).toList();
	}
	
	private void validacao(Divida divida) {
		Optional<Divida> dividaEncontrada = repository.findByNomeAndValorAndDataVencimento(
				divida.getNome(), 
				divida.getValor(), 
				divida.getDataVencimento());
		
		
		if(dividaEncontrada.isPresent()) {
			throw new ObjectExistsException();
		}
	}
	
}
