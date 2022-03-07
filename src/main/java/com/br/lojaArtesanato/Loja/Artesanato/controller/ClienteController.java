package com.br.lojaArtesanato.Loja.Artesanato.controller;

import com.br.lojaArtesanato.Loja.Artesanato.exception.ResourceNotFoundException;
import com.br.lojaArtesanato.Loja.Artesanato.entity.Cliente;
import com.br.lojaArtesanato.Loja.Artesanato.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(path = "/cliente")
    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = "/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") long clienteId)
        throws ResourceNotFoundException{
        Cliente cliente = clienteRepository.findById(clienteId).
            orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado id::" + clienteId));
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping("/cliente/salvar")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    @PutMapping(path = "/cliente/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
                                                 @Valid @RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById((clienteId))
                .orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado id::" + clienteId));
        cliente.setNome(clienteDetails.getNome());
        cliente.setCpf(clienteDetails.getCpf());
        cliente.setEndereco(clienteDetails.getEndereco());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setLogin(clienteDetails.getLogin());
        cliente.setSenha(clienteDetails.getSenha());
        final Cliente updateCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updateCliente);
    }

    @DeleteMapping("/cliente/{id}")
        public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long clienteId)
            throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado id::" + clienteId));

        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("apagado com sucesso", Boolean.TRUE);

        return response;
    }

}


