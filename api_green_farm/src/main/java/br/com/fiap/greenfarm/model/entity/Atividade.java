package br.com.fiap.greenfarm.model.entity;

import br.com.fiap.greenfarm.model.dto.DadosAtualizacaoAtividade;
import br.com.fiap.greenfarm.model.dto.DadosCadastroAtividade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "atividades")
@Entity(name = "Atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_atividade;
	private String tipo_atividade;
	private String data_atividade;
	private String descricao_atividade;

	private Boolean ativo;

	public Atividade() {

	}

	public Atividade(DadosCadastroAtividade dados) {
	    this.tipo_atividade = dados.tipo_atividade();
	    this.data_atividade = dados.data_atividade();
	    this.descricao_atividade = dados.descricao_atividade();
	    this.ativo = true;
	}


	public void atualizarInformacoes(DadosAtualizacaoAtividade dados) {
	    if (dados.tipo_atividade() != null) {
	        this.tipo_atividade = dados.tipo_atividade();
	    }
	    if (dados.data_atividade() != null) {
	        this.data_atividade = dados.data_atividade();
	    }
	    if (dados.descricao_atividade() != null) {
	        this.descricao_atividade = dados.descricao_atividade();
	    }
	}


	public void excluir() {
		this.ativo = false;
	}

	public Long getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(Long id_atividade) {
		this.id_atividade = id_atividade;
	}

	public String getTipo_atividade() {
		return tipo_atividade;
	}

	public void setTipo_atividade(String tipo_atividade) {
		this.tipo_atividade = tipo_atividade;
	}

	public String getData_atividade() {
		return data_atividade;
	}

	public void setData_atividade(String data_atividade) {
		this.data_atividade = data_atividade;
	}

	public String getDescricao_atividade() {
		return descricao_atividade;
	}

	public void setDescricao_atividade(String descricao_atividade) {
		this.descricao_atividade = descricao_atividade;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}