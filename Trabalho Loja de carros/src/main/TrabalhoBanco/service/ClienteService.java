package main.TrabalhoBanco.service;

import main.TrabalhoBanco.dao.ClienteDAO;
import main.TrabalhoBanco.model.Cliente;

import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /*public Cliente salvarCliente(Cliente novoCliente) {return clienteDAO.salvar(novoCliente);
    }*/
    public Cliente salvarCliente(Cliente novoCliente) {

        if(clienteDAO.existeCpf(
                novoCliente.getCpf())) {

            throw new RuntimeException(
                    "CPF já cadastrado.");
        }

        return clienteDAO.salvar(novoCliente);
    }

    public List<Cliente> listarTodos() {
        return clienteDAO.listarTodos();
    }

    public Cliente atualizarCliente(Cliente cliente) {return clienteDAO.atualizar(cliente);}

    public void excluirCliente(Integer codigo) {clienteDAO.deletar(codigo);}

}
