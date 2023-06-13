package br.com.fiap.greenfarm.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroUsuario(
	
		@NotBlank
		String nome_usuario,
		@NotBlank
		@Email
		String email_usuario,
		@NotBlank
		String senha_usuario
		
	) {

}
