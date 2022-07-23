package com.imobil.apiimobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobil.apiimobiliaria.entity.Loteadora;
import com.imobil.apiimobiliaria.entity.Terreno;
import com.imobil.apiimobiliaria.repository.LoteadoraRepository;
import com.imobil.apiimobiliaria.repository.TerrenoRepository;

@Service
public class ImobiliariaService {
	
	
	@Autowired
	private TerrenoRepository terrenoRepository;
	
	@Autowired
	private LoteadoraRepository loteadoraRepository;
	
	
	
	
	public Double valorComissaoLoteadora(Long idLoteadora) {
		Loteadora loteadora = loteadoraRepository.findById(idLoteadora).get();
		
		List<Terreno> terrenoVendidos = terrenoRepository.buscarTerrenosVendidosLoteadora(idLoteadora);
		Double totalVendido =0.;
		Double comissao=0.;
		for(Terreno t:terrenoVendidos) {
			totalVendido+=t.getValorVenda();
		}
		comissao = totalVendido*(loteadora.getPorcentagemComissao()/100);
		return comissao;
	}
	
	public List<Terreno> aumentarValorVendaTerrenoLivre(Long idLoteadora, Double porcentagemInformada) {
		
	
		List<Terreno> terrenoLivre = terrenoRepository.buscarTerrenosLivresLoteadora(idLoteadora);
		Double aumentoTerreno=0.;
		
		for(Terreno t:terrenoLivre) {
			aumentoTerreno += t.getValorPedido() + ( t.getValorPedido()*(porcentagemInformada/100));
			
			t.setValorPedido(aumentoTerreno);
			
			terrenoRepository.save(t);	
		}
		
		return terrenoLivre;
	}
}


















