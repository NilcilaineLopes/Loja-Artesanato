package com.br.lojaArtesanato.Loja.Artesanato.model;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

import javax.persistence.*;
import java.util.List;

@Entity

@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Endereco> enderecos;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    public Cliente(String nome, String cpf, Endereco enderecos, String email, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = (List<Endereco>) enderecos;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Cliente() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public  String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Long getId() {
        return id;
    }
}
