package com.imobil.apiimobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imobil.apiimobiliaria.entity.Terreno;
import com.imobil.apiimobiliaria.service.ImobiliariaService;

@RestController
@RequestMapping("/api/imobiliaria")
public class ImobiliariaController {
	
	@Autowired
	private ImobiliariaService imobiliariaService;
	
	@GetMapping("/valorComissaoLoteadora")
	public Double valorComissaoLoteadora(@RequestParam Long idLoteadora) {
		return imobiliariaService.valorComissaoLoteadora(idLoteadora);
	}
	
	@GetMapping("/aumentarvalorTerreno")
	public List<Terreno> aumentarValorVendaTerrenoLivre(@RequestParam Long idLoteadora, @RequestParam Double porcentagemInformada) {
		return imobiliariaService.aumentarValorVendaTerrenoLivre(idLoteadora, porcentagemInformada);
	}
}
