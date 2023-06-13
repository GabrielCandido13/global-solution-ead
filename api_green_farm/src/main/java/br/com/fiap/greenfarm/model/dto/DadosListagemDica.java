package br.com.fiap.greenfarm.model.dto;

import br.com.fiap.greenfarm.model.entity.Dica;

public record DadosListagemDica(
	
		Long id_dica,
		String titulo_dica,
		String tipo_dica

	) {
	
	public DadosListagemDica(Dica dica) {
		
		this(
				dica.getId_dica(),
				dica.getTitulo_dica(),
				dica.getTipo_dica()

			);
		
	}

}