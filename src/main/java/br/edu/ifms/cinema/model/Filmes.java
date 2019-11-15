package br.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;
    private String titulo;
    private String duracao;
    private String genero;
    private int classificacao; //0 free e 5 adulto

    public Long getIdFilme() {
        return idFilme;
    }
}

