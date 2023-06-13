package br.com.fiap.greenfarm.model.entity;

import br.com.fiap.greenfarm.model.dto.DadosAtualizacaoUsuario;
import br.com.fiap.greenfarm.model.dto.DadosCadastroUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String nome_usuario;
	private String email_usuario;
	private String senha_usuario;

	private Boolean ativo;

	public Usuario() {

	}

	public Usuario(DadosCadastroUsuario dados) {
		this.nome_usuario = dados.nome_usuario();
		this.email_usuario = dados.email_usuario();
		this.senha_usuario = dados.senha_usuario();
		this.ativo = true;
	}

	public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
		if (dados.nome_usuario() != null) {
			this.nome_usuario = dados.nome_usuario();
		}
		if (dados.email_usuario() != null) {
			this.email_usuario = dados.email_usuario();
		}
		if (dados.senha_usuario() != null) {
			this.senha_usuario = dados.senha_usuario();
		}
	}

	public void excluir() {
		this.ativo = false;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}