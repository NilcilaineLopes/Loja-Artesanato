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

    @GetMapping("/produtos")
    public List<Produto> getAllProduto(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") long produtoId)
        throws ResourceNotFoundException{
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado id:: " + produtoId));
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping("/produtos")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PostMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Long produtoId,
                                                 @Valid @RequestBody Produto produtoDetails) throws ResourceNotFoundException{
        Produto produto = produtoRepository.findById((produtoId))
                .orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado id:: " + produtoId));
        produto.setNome(produtoDetails.getNome());
        produto.setDescricao(produtoDetails.getDescricao());
        produto.setQuantidade(produtoDetails.getQuantidade());
        produto.setPreco(produtoDetails.getPreco());

        final Produto updateProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updateProduto);
    }

    @DeleteMapping("/produto{id}")
    public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long produtoId)
            throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado id::" + produtoId));

        produtoRepository.delete(produto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);

        return response;
    }
}
