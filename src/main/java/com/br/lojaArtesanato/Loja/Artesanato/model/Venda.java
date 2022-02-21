package com.br.lojaArtesanato.Loja.Artesanato.model;

import java.util.Date;
import java.util.Objects;

public class Venda {

    private Long id;

    private Integer qtd_de_ventas;

    private Float valor;

    private Date data_venda;

    private Produto produto;

    private Cliente cliente;

    public Venda(Long id, Integer qtd_de_ventas, Float valor, Date data_venda, Produto produto, Cliente cliente) {
        this.id = id;
        this.qtd_de_ventas = qtd_de_ventas;
        this.valor = valor;
        this.data_venda = data_venda;
        this.produto = produto;
        this.cliente = cliente;
    }

    public Venda() {
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Vendas{" +
                "id=" + id +
                ", qtd_de_ventas=" + qtd_de_ventas +
                ", valor=" + valor +
                ", data_venda=" + data_venda +
                ", produto=" + produto +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id) && Objects.equals(qtd_de_ventas, venda.qtd_de_ventas) && Objects.equals(valor, venda.valor) && Objects.equals(data_venda, venda.data_venda) && Objects.equals(produto, venda.produto) && Objects.equals(cliente, venda.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qtd_de_ventas, valor, data_venda, produto, cliente);
    }
}
