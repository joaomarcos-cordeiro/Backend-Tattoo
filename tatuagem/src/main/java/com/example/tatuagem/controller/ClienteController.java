package com.example.tatuagem.controller;
import com.example.tatuagem.cliente.Cliente;
import com.example.tatuagem.cliente.ClienteRepository;
import com.example.tatuagem.cliente.ClienteRequestDTO;
import com.example.tatuagem.cliente.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")

public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public void saveCliente(@RequestBody ClienteRequestDTO data ){
     Cliente clienteData = new Cliente(data);
     repository.save(clienteData);
     return;
    }


    @GetMapping
    public List<ClienteResponseDTO> getAll(){


        List<ClienteResponseDTO> clienteList = repository.findAll().stream().map(ClienteResponseDTO::new).toList();
        return clienteList;//traz todos os dados com stream e map como um funil para criação de objetos representando a lista
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO newData) {
        Optional<Cliente> clienteOptional = repository.findById(id);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = clienteOptional.get();
        cliente.updateFromDTO(newData); // Implemente um método na classe Cliente para atualizar os dados a partir do DTO

        repository.save(cliente);
        return ResponseEntity.ok("Cliente atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Cliente excluído com sucesso");
    }


    }





