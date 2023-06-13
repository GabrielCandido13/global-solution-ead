package br.com.fiap.greenfarm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "EMAIL_USUARIO")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO")
    @Column(name = "ID_USUARIO")
    private long id_usuario;

    @Column(name = "NOME_USUARIO")
    private String nome_usuario;

    @Column(name = "EMAIL_USUARIO")
    private String email_usuario;

    @Column(name = "SENHA_USUARIO")
    private String senha_usuario;

    public Usuario() {
    }

    public Usuario(long id_usuario, String nome_usuario, String email_usuario, String senha_usuario) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.email_usuario = email_usuario;
        this.senha_usuario = senha_usuario;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public Usuario setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
        return this;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public Usuario setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
        return this;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public Usuario setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
        return this;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public Usuario setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", email_usuario='" + email_usuario + '\'' +
                ", senha_usuario='" + senha_usuario + '\'' +
                '}';
    }
}
