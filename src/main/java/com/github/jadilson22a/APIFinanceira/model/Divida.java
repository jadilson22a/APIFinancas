package com.github.jadilson22a.APIFinanceira.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.github.jadilson22a.APIFinanceira.entity.DividaDTORetorno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dividas")
public class Divida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valor", precision = 20, scale = 2)
	private BigDecimal valor;
	
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name = "pago")
	private boolean pago;
	
	public Divida() {
	}

	public Divida(Integer id, String nome, BigDecimal valor, LocalDate dataVencimento, boolean pago) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.pago = pago;
	}

	public Divida(String nome, BigDecimal valor, LocalDate dataVencimento) {
		this.nome = nome;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.pago = false;
	}

	public DividaDTORetorno toDTO() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return new DividaDTORetorno(
				id, 
				nome, 
				valor, 
				String.valueOf(
						dataVencimento.getDayOfMonth()
						+"/"+ dataVencimento.getMonthValue()
						+"/"+dataVencimento.getYear())
				, pago);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataVencimento, id, nome, Boolean.valueOf(pago), valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divida other = (Divida) obj;
		return Objects.equals(dataVencimento, other.dataVencimento) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && pago == other.pago && Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "Divida [id=" + id + ", nome=" + nome + ", valor=" + valor + ", dataVencimento=" + dataVencimento
				+ ", pago=" + pago + "]";
	}
	
	

}
