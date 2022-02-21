package com.br.lojaArtesanato.Loja.Artesanato.repository;

import com.br.lojaArtesanato.Loja.Artesanato.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
