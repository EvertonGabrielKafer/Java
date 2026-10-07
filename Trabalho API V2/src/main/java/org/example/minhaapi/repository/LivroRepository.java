package org.example.minhaapi.repository;

import org.example.minhaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("""
        SELECT l FROM Livro l
            WHERE (:nome IS NULL OR l.nome = :nome)
            AND (:autor IS NULL OR l.autor = :autor)
            AND (:valor IS NULL OR l.valor = :valor)
    """)
    List<Livro> filtrarLivros(
            @Param("nome") String nome,
            @Param("autor") String autor,
            @Param("valor") Double valor
    );

}