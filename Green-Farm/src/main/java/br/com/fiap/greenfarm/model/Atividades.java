package br.com.fiap.greenfarm.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ATIVIDADE")
public class Atividades {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATIVIDADE")
    @SequenceGenerator(name = "SQ_ATIVIDADE", sequenceName = "SQ_ATIVIDADE")
    @Column(name = "ID_ATIVIDADE")
    private long id_atividade;

    @Column(name = "tipo_atividade")
    private String tipo_atividade;

    @Column(name = "data_atividade")
    private LocalDate data_atividade;

    @Column(name = "descricao_atividade")
    private String descricao_atividade;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO",
                    foreignKey = @ForeignKey(name = "Suporte_Usuario_FK", value = ConstraintMode.CONSTRAINT))
    private Usuario usuario;

    public Atividades() {
    }


    public Atividades(long id_atividade, String tipo_atividade, LocalDate data_atividade, String descricao_atividade, Usuario usuario) {
        this.id_atividade = id_atividade;
        this.tipo_atividade = tipo_atividade;
        this.data_atividade = data_atividade;
        this.descricao_atividade = descricao_atividade;
        this.usuario = usuario;
    }

    public long getId_atividade() {
        return id_atividade;
    }

    public Atividades setId_atividade(long id_atividade) {
        this.id_atividade = id_atividade;
        return this;
    }

    public String getTipo_atividade() {
        return tipo_atividade;
    }

    public Atividades setTipo_atividade(String tipo_atividade) {
        this.tipo_atividade = tipo_atividade;
        return this;
    }

    public LocalDate getData_atividade() {
        return data_atividade;
    }

    public Atividades setData_atividade(LocalDate data_atividade) {
        this.data_atividade = data_atividade;
        return this;
    }

    public String getDescricao_atividade() {
        return descricao_atividade;
    }

    public Atividades setDescricao_atividade(String descricao_atividade) {
        this.descricao_atividade = descricao_atividade;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Atividades setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    @Override
    public String toString() {
        return "Atividades{" +
                "id_atividade=" + id_atividade +
                ", tipo_atividade='" + tipo_atividade + '\'' +
                ", data_atividade=" + data_atividade +
                ", descricao_atividade='" + descricao_atividade + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
