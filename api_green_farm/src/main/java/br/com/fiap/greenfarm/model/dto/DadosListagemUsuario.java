package br.com.fiap.greenfarm.model.dto;

import br.com.fiap.greenfarm.model.entity.Usuario;

public record DadosListagemUsuario(
	
		Long id_usuario,
		String nome_usuario,
		String email_usuario

	) {
	
	public DadosListagemUsuario(Usuario usuario) {
		
		this(
				usuario.getId_usuario(),
				usuario.getNome_usuario(),
				usuario.getEmail_usuario()

			);
		
	}

}
