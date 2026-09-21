package org.example.minhaapi.controller;

import org.example.minhaapi.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livraria")
public class LivroController {

    List<Livro> livros = new ArrayList<>();

    @GetMapping("/listar-livro")
    public ResponseEntity<List<Livro>> listarlivro(){
        return ResponseEntity.ok(livros);
    }

    @PostMapping("/criar-livro")
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
        if (livro == null){
            return ResponseEntity.badRequest().build();
        } else {
            livros.add(livro);
            return ResponseEntity.ok(livro);
        }
    }

    @PutMapping("editar-livro/{id}")
    public ResponseEntity<Livro> editarLivro(@PathVariable int id, @RequestBody Livro livro){
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {

                Livro u = livros.get(i);
                u.setNome(livro.getNome());
                u.setAutor(livro.getAutor());
                u.setValor(livro.getValor());
                livros.set(i, u);
                return ResponseEntity.ok(u);

            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar-livro/{id}")
    public ResponseEntity deletarLivro(@PathVariable int id){
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {

                livros.remove(i);
                return ResponseEntity.ok("O Livro com o ID: "+ id + " foi deletado");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filtrar-livro")
    public ResponseEntity<List<Livro>> filtrarLivros(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) Double valor) {
        List<Livro> resultado = new ArrayList<>();

        for (Livro livro : livros) {

            if (nome != null && !livro.getNome().equalsIgnoreCase(nome)) {
                continue;
            }
            if (autor != null && !livro.getAutor().equalsIgnoreCase(autor)) {
                continue;
            }
            if (valor != null && livro.getValor() != valor) {
                continue;
            }
            resultado.add(livro);
        }
        return ResponseEntity.ok(resultado);
    }
}
