package br.com.fiap.greenfarm.model.dto;

import br.com.fiap.greenfarm.model.entity.Atividade;

public record DadosListagemAtividade(
		
		Long id_atividade,
		String tipo_atividade

	) {
	
	public DadosListagemAtividade(Atividade atividade) {
		
		this(
				atividade.getId_atividade(),
				atividade.getTipo_atividade()

			);
		
	}

}
