package main.TrabalhoBanco.service;

import main.TrabalhoBanco.dao.VeiculoDAO;
import main.TrabalhoBanco.dao.VendaDAO;
import main.TrabalhoBanco.model.Venda;
import main.TrabalhoBanco.model.Veiculo;

import java.util.List;

public class VendaService {
    private VendaDAO vendaDAO;
    private VeiculoDAO veiculoDAO;

    public VendaService(VendaDAO vendaDAO, VeiculoDAO veiculoDAO) {
        this.vendaDAO = vendaDAO;
        this.veiculoDAO = veiculoDAO;
    }

    public Venda salvarVenda(Venda novaVenda) {
        if (novaVenda.getCliente() == null || novaVenda.getCliente().getCodigo() == null) {
            throw new RuntimeException("Cliente obrigatorio.");
        }

        if (novaVenda.getVeiculo() == null || novaVenda.getVeiculo().getCodigo() == null) {
            throw new RuntimeException("Veiculo obrigatorio.");
        }

        Veiculo veiculoPersistido = veiculoDAO.buscarPorId(novaVenda.getVeiculo().getCodigo());
        if (veiculoPersistido == null) {
            throw new RuntimeException("Veiculo nao encontrado.");
        }

        novaVenda.setVeiculo(veiculoPersistido);

        if (!Boolean.TRUE.equals(novaVenda.getVeiculo().getDisponivel())) {
            throw new RuntimeException("Veiculo ja vendido.");
        }

        Venda vendaSalva = vendaDAO.salvar(novaVenda);

        novaVenda.getVeiculo().setDisponivel(false);
        veiculoDAO.atualizar(novaVenda.getVeiculo());

        return vendaSalva;
    }

    public List<Venda> listarTodos() {
        return vendaDAO.listarTodos();
    }

    public Venda atualizarVenda(Venda venda) {
        return vendaDAO.atualizar(venda);
    }

    public void excluirVenda(Integer codigo) {
        vendaDAO.deletar(codigo);
    }
}
