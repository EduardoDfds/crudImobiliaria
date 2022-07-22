package com.imobil.apiimobiliaria.entity;


import org.springframework.beans.BeanUtils;

import lombok.Data;


@Data
public class TerrenoDtoRequest {

	
	private Long id;
	
	private String endereco;
	private String medidas;
	private String situacao = "livre";
	private Loteadora loteadora;
	
	
	public Terreno toTerreno(TerrenoDtoRequest terrenoDto) {
		Terreno terreno = new Terreno();
		BeanUtils.copyProperties(terrenoDto, terreno);
		return terreno;
	}
}
