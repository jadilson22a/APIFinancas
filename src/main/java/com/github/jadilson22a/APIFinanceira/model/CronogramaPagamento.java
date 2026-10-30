package com.github.jadilson22a.APIFinanceira.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.github.jadilson22a.APIFinanceira.service.CronogramaPagamentoDTORetorno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cronograma_pagamento")
public class CronogramaPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "data")
	private LocalDate data;
	
	@OneToMany
	private List<Divida> dividas;
	
	public CronogramaPagamento(Integer id, String titulo, LocalDate data, List<Divida> dividas) {
		this.id = id;
		this.titulo = titulo;
		this.data = data;
		this.dividas = dividas;
	}

	public CronogramaPagamento(String titulo, LocalDate data, List<Divida> dividas) {
		this.titulo = titulo;
		this.data = data;
		this.dividas = dividas;
	}

	public CronogramaPagamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Divida> getDividas() {
		return dividas;
	}

	public void setDividas(List<Divida> dividas) {
		this.dividas = dividas;
	}
	
	public CronogramaPagamentoDTORetorno toDTO() {
		return new CronogramaPagamentoDTORetorno(id, titulo, data, dividas);
	}

	@Override
	public String toString() {
		return "CronogramaPagamento [id=" + id + ", titulo=" + titulo + ", data=" + data + ", dividas=" + dividas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, dividas, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CronogramaPagamento other = (CronogramaPagamento) obj;
		return Objects.equals(data, other.data) && Objects.equals(dividas, other.dividas)
				&& Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
	}
	
	

}
