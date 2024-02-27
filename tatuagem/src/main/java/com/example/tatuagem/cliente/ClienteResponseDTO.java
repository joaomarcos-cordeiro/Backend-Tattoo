package com.example.tatuagem.cliente;

public record ClienteResponseDTO(Long id, String title, String image, Integer price) {
    public ClienteResponseDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getTitle(), cliente.getImage(), cliente.getPrice());

    }
}
