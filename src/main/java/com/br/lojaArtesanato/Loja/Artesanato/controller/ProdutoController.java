package com.br.lojaArtesanato.Loja.Artesanato.controller;

import com.br.lojaArtesanato.Loja.Artesanato.exception.ResourceNotFoundException;
import com.br.lojaArtesanato.Loja.Artesanato.model.Produto;
import com.br.lojaArtesanato.Loja.Artesanato.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:42000")
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<Produto> getAllProduto(){
        return produtoRepository.findAll();
    }
}
