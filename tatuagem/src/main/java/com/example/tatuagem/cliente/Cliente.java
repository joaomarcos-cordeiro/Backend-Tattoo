package com.example.tatuagem.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")


public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;


   public Cliente (ClienteRequestDTO data){
       this.title = data.title();
       this.image = data.image();
       this.price = data.price();
   }

    public void updateFromDTO(ClienteRequestDTO newData) {
        this.title = newData.title();
        this.image = newData.image();
        this.price = newData.price();
    }



}
