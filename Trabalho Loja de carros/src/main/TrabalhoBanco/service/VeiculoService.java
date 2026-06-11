package main.TrabalhoBanco.service;

import main.TrabalhoBanco.dao.VeiculoDAO;
import main.TrabalhoBanco.model.Veiculo;

import java.util.List;

public class VeiculoService {
    private VeiculoDAO veiculoDAO;

    public VeiculoService(VeiculoDAO veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }

    /*public Veiculo salvarVeiculo(Veiculo novoVeiculo) {return veiculoDAO.salvar(novoVeiculo);}*/

    public Veiculo salvarVeiculo(Veiculo veiculo) {

        if(veiculo.getValor() <= 0) {
            throw new RuntimeException(
                    "Valor do veículo deve ser maior que zero.");
        }

        return veiculoDAO.salvar(veiculo);
    }

    public List<Veiculo> listarTodos() {return veiculoDAO.listarTodos();}

    /*public Veiculo atualizarVeiculo(Veiculo veiculo) {return veiculoDAO.atualizar(veiculo);}*/

    public Veiculo atualizarVeiculo(Veiculo veiculo) {

        if(veiculo.getValor() <= 0) {
            throw new RuntimeException(
                    "Valor do veículo deve ser maior que zero.");
        }

        return veiculoDAO.atualizar(veiculo);
    }

    public void excluirVeiculo(Integer codigo) {veiculoDAO.deletar(codigo);}

}