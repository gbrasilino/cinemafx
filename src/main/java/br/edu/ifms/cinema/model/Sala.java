package br.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idSala;
    private String tipoSala;
    private int numero;
    @ManyToOne(fetch = FetchType.EAGER)
    private Filmes idFilmes;
    @OneToMany
    private List<Assento> idAssentos;


}
