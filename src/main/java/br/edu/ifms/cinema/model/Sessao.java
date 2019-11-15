package br.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSessao;
    private LocalTime horario;
    private String sala;
    @OneToOne
    private Filmes idFilmes;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Cliente> clientes;


}
