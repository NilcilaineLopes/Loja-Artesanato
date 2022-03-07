package com.br.lojaArtesanato.Loja.Artesanato.repository;

import com.br.lojaArtesanato.Loja.Artesanato.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
