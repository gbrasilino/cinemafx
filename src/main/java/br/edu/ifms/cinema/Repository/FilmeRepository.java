package br.edu.ifms.cinema.Repository;

import br.edu.ifms.cinema.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filmes, Long> {}
