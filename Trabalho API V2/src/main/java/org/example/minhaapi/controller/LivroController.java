package org.example.minhaapi.controller;

import org.example.minhaapi.model.Livro;
import org.example.minhaapi.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livraria")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/listar-livro")
    public List<Livro> listarlivro(){
        return livroRepository.findAll();
    }

    @PostMapping("/criar-livro")
    public Livro cadastrar(@RequestBody Livro livro){
        //if (livro == null){
            //return ResponseEntity.badRequest().build();
        //} else {
            return livroRepository.save(livro);
        //}
    }

    @PutMapping("editar-livro/{id}")
    public Livro editar(@PathVariable Long id, @RequestBody Livro livro){

        livro.setId(id);

        return livroRepository.save(livro);
    }

    @DeleteMapping("/deletar-livro/{id}")
    public void excluir(@PathVariable Long id){

        livroRepository.deleteById(id);
    }

    @GetMapping("/filtrar-livro")
    public ResponseEntity<List<Livro>> filtrarLivros(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) Double valor) {

        List<Livro> resultado =
                livroRepository.filtrarLivros(nome, autor, valor);

        return ResponseEntity.ok(resultado);
    }
}
