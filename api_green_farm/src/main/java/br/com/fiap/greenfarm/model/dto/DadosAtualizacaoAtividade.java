package br.com.fiap.greenfarm.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoAtividade(
		
		@NotNull
		Long id_atividade,
		String tipo_atividade,
		@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
		String data_atividade,
		String descricao_atividade
		
		) {

}
