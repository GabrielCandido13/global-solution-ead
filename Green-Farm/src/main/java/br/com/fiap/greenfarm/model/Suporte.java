package br.com.fiap.greenfarm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SUPORTE")
public class Suporte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SUPORTE")
    @SequenceGenerator(name = "SQ_SUPORTE", sequenceName = "SQ_SUPORTE")
    @Column(name = "ID_SUPORTE")
    private long id_suporte;

    @Column(name = "EMAIL_SUPORTE")
    private String email_suporte;

    @Column(name = "MENSAGEM_SUPORTE")
    private String mensagem_suporte;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "Atividade_Usuario_FK", value = ConstraintMode.CONSTRAINT))
    private Usuario usuario;

    public Suporte() {
    }

    public Suporte(long id_suporte, String email_suporte, String mensagem_suporte, Usuario usuario) {
        this.id_suporte = id_suporte;
        this.email_suporte = email_suporte;
        this.mensagem_suporte = mensagem_suporte;
        this.usuario = usuario;
    }

    public long getId_suporte() {
        return id_suporte;
    }

    public Suporte setId_suporte(long id_suporte) {
        this.id_suporte = id_suporte;
        return this;
    }

    public String getEmail_suporte() {
        return email_suporte;
    }

    public Suporte setEmail_suporte(String email_suporte) {
        this.email_suporte = email_suporte;
        return this;
    }

    public String getMensagem_suporte() {
        return mensagem_suporte;
    }

    public Suporte setMensagem_suporte(String mensagem_suporte) {
        this.mensagem_suporte = mensagem_suporte;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Suporte setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    @Override
    public String toString() {
        return "Suporte{" +
                "id_suporte=" + id_suporte +
                ", email_suporte='" + email_suporte + '\'' +
                ", mensagem_suporte='" + mensagem_suporte + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
