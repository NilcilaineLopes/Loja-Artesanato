package com.br.lojaArtesanato.Loja.Artesanato.repository;

import com.br.lojaArtesanato.Loja.Artesanato.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
