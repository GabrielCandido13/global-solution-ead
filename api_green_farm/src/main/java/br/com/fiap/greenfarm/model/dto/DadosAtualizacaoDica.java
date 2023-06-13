package br.com.fiap.greenfarm.model.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDica(
		
		@NotNull
		Long id_dica,
		String titulo_dica,
		String desc_dica,
		String img_dica,
		String tipo_dica
		
		
		) {

}
