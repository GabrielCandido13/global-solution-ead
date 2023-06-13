package br.com.fiap.greenfarm.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAtividade(
		
		@NotBlank
		String tipo_atividade,
		@NotBlank
		@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
		String data_atividade,
		@NotBlank
		String descricao_atividade
		
		) {

}
