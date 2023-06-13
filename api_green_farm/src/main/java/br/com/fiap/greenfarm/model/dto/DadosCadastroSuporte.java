package br.com.fiap.greenfarm.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroSuporte(
		
		@NotBlank
		@Email
		String email_suporte,
		@NotBlank
		String mensagem_suporte
		
		) {

}
