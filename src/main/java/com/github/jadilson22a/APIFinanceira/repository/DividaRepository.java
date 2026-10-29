package com.github.jadilson22a.APIFinanceira.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jadilson22a.APIFinanceira.model.Divida;

public interface DividaRepository extends JpaRepository<Divida, Integer> {

	List<Divida> findByNome(String nome);
	List<Divida> findByPago(boolean pago);
	Optional<Divida> findByNomeAndValorAndDataVencimento(String nome, BigDecimal valor, LocalDate dataVencimento);
}
