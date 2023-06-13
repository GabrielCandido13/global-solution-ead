package br.com.fiap.greenfarm.model.entity;

import br.com.fiap.greenfarm.model.dto.DadosAtualizacaoDica;
import br.com.fiap.greenfarm.model.dto.DadosCadastroDica;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "dicas")
@Entity(name = "Dica")
public class Dica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dica;
	private String titulo_dica;
	private String desc_dica;
	private String img_dica; //url
	private String tipo_dica;

	private Boolean ativo;

	public Dica() {

	}

	public Dica(DadosCadastroDica dados) {
		this.titulo_dica = dados.titulo_dica();
	    this.desc_dica = dados.desc_dica();
	    this.img_dica = dados.img_dica();
	    this.tipo_dica = dados.tipo_dica();
		this.ativo = true;
	}

	public void atualizarInformacoes(DadosAtualizacaoDica dados) {
	    if (dados.titulo_dica() != null) {
	        this.titulo_dica = dados.titulo_dica();
	    }
	    if (dados.desc_dica() != null) {
	        this.desc_dica = dados.desc_dica();
	    }
	    if (dados.img_dica() != null) {
	        this.img_dica = dados.img_dica();
	    }
	    if (dados.tipo_dica() != null) {
	        this.tipo_dica = dados.tipo_dica();
	    }
	}


	public void excluir() {
		this.ativo = false;
	}

	public Long getId_dica() {
		return id_dica;
	}

	public void setId_dica(Long id_dica) {
		this.id_dica = id_dica;
	}

	public String getTitulo_dica() {
		return titulo_dica;
	}

	public void setTitulo_dica(String titulo_dica) {
		this.titulo_dica = titulo_dica;
	}

	public String getDesc_dica() {
		return desc_dica;
	}

	public void setDesc_dica(String desc_dica) {
		this.desc_dica = desc_dica;
	}

	public String getImg_dica() {
		return img_dica;
	}

	public void setImg_dica(String img_dica) {
		this.img_dica = img_dica;
	}

	public String getTipo_dica() {
		return tipo_dica;
	}

	public void setTipo_dica(String tipo_dica) {
		this.tipo_dica = tipo_dica;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	

}