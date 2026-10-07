package org.example.minhaapi.model;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String autor;
    public Double valor;
}

