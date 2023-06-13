package br.com.fiap.greenfarm.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
	
		@NotNull
		Long id_usuario,
		String nome_usuario,
		@Email
		String email_usuario,
		String senha_usuario
		
	) {

}
