package com.imobil.apiimobiliaria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Terreno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String endereco;
	private double valorPedido;
	private Double valorVenda;
	private String medidas;
	private String situacao = "livre";
	
	@ManyToOne
	@JoinColumn
	private Loteadora loteadora;
}
