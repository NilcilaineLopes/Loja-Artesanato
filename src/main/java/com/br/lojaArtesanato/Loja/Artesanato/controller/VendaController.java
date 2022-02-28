package com.br.lojaArtesanato.Loja.Artesanato.controller;

import com.br.lojaArtesanato.Loja.Artesanato.exception.ResourceNotFoundException;
import com.br.lojaArtesanato.Loja.Artesanato.model.Venda;
import com.br.lojaArtesanato.Loja.Artesanato.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:42000")
@RequestMapping("/api/v1")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }


    @PostMapping("/produtos")
    public Venda createVenda(@Valid @RequestBody Venda venda) {
        return vendaRepository.save(venda);
    }


    @GetMapping("/vendas/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable(value = "id") long vendaId)
        throws ResourceNotFoundException{
        Venda venda = vendaRepository.findById(vendaId)
                .orElseThrow(()-> new ResourceNotFoundException("Venda não encontrada id:: " + vendaId));
        return ResponseEntity.ok().body(venda);

    }


}
