package com.br.lojaArtesanato.Loja.Artesanato.model;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum Endereco {

    HOME("Residencial"),
    COMERCIAL("Comercial");

    private final String descricao;
}
