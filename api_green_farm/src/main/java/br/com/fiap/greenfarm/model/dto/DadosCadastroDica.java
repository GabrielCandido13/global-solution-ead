package br.com.fiap.greenfarm.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDica(
		
		@NotBlank
		String titulo_dica,
		String desc_dica,
		String img_dica,
		@NotBlank
		String tipo_dica
		
		
		
		
		) {

}
