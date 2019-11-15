package br.edu.ifms.cinema.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssento;
    private int poltrona;
    private String fila;
    @OneToOne
    private Sala sala;


}
