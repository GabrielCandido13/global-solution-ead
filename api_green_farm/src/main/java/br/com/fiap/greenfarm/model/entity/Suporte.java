package br.com.fiap.greenfarm.model.entity;

import br.com.fiap.greenfarm.model.dto.DadosCadastroSuporte;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "suportes")
@Entity(name = "Suporte")
public class Suporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_suporte;
	private String email_suporte;
	private String mensagem_suporte;

	private Boolean ativo;

	public Suporte() {

	}

	public Suporte(DadosCadastroSuporte dados) {
	    this.email_suporte = dados.email_suporte();
	    this.mensagem_suporte = dados.mensagem_suporte();
	    this.ativo = true;
	}

	public void excluir() {
		this.ativo = false;
	}

	public Long getId_suporte() {
		return id_suporte;
	}

	public void setId_suporte(Long id_suporte) {
		this.id_suporte = id_suporte;
	}

	public String getEmail_suporte() {
		return email_suporte;
	}

	public void setEmail_suporte(String email_suporte) {
		this.email_suporte = email_suporte;
	}

	public String getMensagem_suporte() {
		return mensagem_suporte;
	}

	public void setMensagem_suporte(String mensagem_suporte) {
		this.mensagem_suporte = mensagem_suporte;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}