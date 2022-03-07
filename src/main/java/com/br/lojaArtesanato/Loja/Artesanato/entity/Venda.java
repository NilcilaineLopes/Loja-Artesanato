package com.br.lojaArtesanato.Loja.Artesanato.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Builder
@Getter
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer qtd_de_ventas;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private Date data_venda;

    public Venda() {
    }

    public Venda(Long id, Integer qtd_de_ventas, Float valor, Date data_venda) {
        this.id = id;
        this.qtd_de_ventas = qtd_de_ventas;
        this.valor = valor;
        this.data_venda = data_venda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtd_de_ventas() {
        return qtd_de_ventas;
    }

    public void setQtd_de_ventas(Integer qtd_de_ventas) {
        this.qtd_de_ventas = qtd_de_ventas;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }
}
