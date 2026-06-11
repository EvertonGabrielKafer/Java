package main.TrabalhoBanco.dao;

import java.util.List;

public interface CrudDAO<T, ID> {

    T salvar(T entidade);

    List<T> listarTodos();

    T buscarPorId(ID id);

    T atualizar(T entidade);

    void deletar(ID id);

}
