package br.edu.ifms.cinema.Controler;

import br.edu.ifms.cinema.Repository.FilmeRepository;
import br.edu.ifms.cinema.model.Filmes;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/filme")

public class Filme {

    private FilmeRepository repository;

    public Filme(FilmeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listar-filmes")
    public List<Filmes> filmes() {
        return repository.findAll();
    }

    @PostMapping("/cad-filme")
    ResponseEntity<Filmes> saveFilme(@RequestBody Filmes filme) throws URISyntaxException {

        Filmes f1 = repository.save(filme);


        return ResponseEntity.created(new URI("/filme/cad-filme" +
                f1.getIdFilme())).body(f1);

    }

    @PutMapping("/upd-filme{id1}")
    ResponseEntity<Filmes> update(@Valid @RequestBody Filmes filme) {

        Filmes f1 = repository.save(filme);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-filme/{id1}")
    ResponseEntity<Filme> deleteFilme(@PathVariable Long id1) {

        repository.deleteById(id1);
        return ResponseEntity.ok().build();

    }
    @GetMapping("/busca-filme-id/{idf}")
    ResponseEntity<Filmes> getFilmeId(@PathVariable(value = "idf") Long idf) {
        Filmes filme = repository.findById(idf)
                .orElseThrow(() -> new ResourceNotFoundException("Filme not found for this id :: " + idf));
        return ResponseEntity.ok().body(filme);
    }


}
