package br.com.fiap.greenfarm.model.dto;

import br.com.fiap.greenfarm.model.entity.Suporte;

public record DadosListagemSuporte(
		
		Long id_suporte,
		String email_suporte,
		String mensagem_suporte

	) {
	
	public DadosListagemSuporte(Suporte suporte) {
		
		this(
				suporte.getId_suporte(),
				suporte.getEmail_suporte(),
				suporte.getMensagem_suporte()

			);
		
	}

}
