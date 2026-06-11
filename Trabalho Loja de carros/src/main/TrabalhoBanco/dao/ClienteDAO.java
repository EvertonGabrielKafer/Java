package main.TrabalhoBanco.dao;

import main.TrabalhoBanco.model.Cliente;

public interface ClienteDAO extends CrudDAO<Cliente, Integer> {
    boolean existeCpf(String cpf);
}