package br.com.fiap.greenfarm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DICA")
public class Dicas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DICA")
    @SequenceGenerator(name = "SQ_DICA", sequenceName = "SQ_DICA")
    @Column(name = "id_dica")
    private long id_dica;

    @Column(name = "titulo_dica")
    private String titulo_dica;

    @Column(name = "desc_dica")
    private String desc_dica;

    @Column(name = "img_dica")
    private String img_dica; //url

    @Column(name = "tipo_dica")
    private String tipo_dica;

    public Dicas() {
    }

    public Dicas(long id_dica, String titulo_dica, String desc_dica, String img_dica, String tipo_dica) {
        this.id_dica = id_dica;
        this.titulo_dica = titulo_dica;
        this.desc_dica = desc_dica;
        this.img_dica = img_dica;
        this.tipo_dica = tipo_dica;
    }

    public long getId_dica() {
        return id_dica;
    }

    public Dicas setId_dica(long id_dica) {
        this.id_dica = id_dica;
        return this;
    }

    public String getTitulo_dica() {
        return titulo_dica;
    }

    public Dicas setTitulo_dica(String titulo_dica) {
        this.titulo_dica = titulo_dica;
        return this;
    }

    public String getDesc_dica() {
        return desc_dica;
    }

    public Dicas setDesc_dica(String desc_dica) {
        this.desc_dica = desc_dica;
        return this;
    }

    public String getImg_dica() {
        return img_dica;
    }

    public Dicas setImg_dica(String img_dica) {
        this.img_dica = img_dica;
        return this;
    }

    public String getTipo_dica() {
        return tipo_dica;
    }

    public Dicas setTipo_dica(String tipo_dica) {
        this.tipo_dica = tipo_dica;
        return this;
    }

    @Override
    public String toString() {
        return "Dicas{" +
                "id_dica=" + id_dica +
                ", titulo_dica='" + titulo_dica + '\'' +
                ", desc_dica='" + desc_dica + '\'' +
                ", img_dica='" + img_dica + '\'' +
                ", tipo_dica='" + tipo_dica + '\'' +
                '}';
    }
}
