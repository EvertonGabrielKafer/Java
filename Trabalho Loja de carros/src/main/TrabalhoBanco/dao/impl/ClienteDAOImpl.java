package main.TrabalhoBanco.dao.impl;

import main.TrabalhoBanco.connection.ConnectionFactory;
import main.TrabalhoBanco.dao.ClienteDAO;
import main.TrabalhoBanco.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Cliente salvar(Cliente entidade) {
        String sql = "INSERT INTO cliente (nome, cpf, telefone)" +
                " VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getCpf());
            ps.setString(3, entidade.getTelefone());
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Nenhuma linha foi inserida.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    entidade.setCodigo(rs.getInt(1));
                }
            }

            return entidade;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT codigo, nome, cpf, telefone " +
                "FROM cliente ORDER BY nome";
        List<Cliente> cliente = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                cliente.add(mapearCliente(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cliente;
    }

    @Override
    public Cliente buscarPorId(Integer integer) {
        return null;
    }

    @Override
    public Cliente atualizar(Cliente entidade) {
        String sql = """
            UPDATE cliente SET nome = ?, cpf = ?, telefone = ?
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getCpf());
            ps.setString(3, entidade.getTelefone());
            ps.setInt(4, entidade.getCodigo());

            ps.executeUpdate();

            return entidade;

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao atualizar curso.", e);
        }
        //return null;
    }

    @Override
    public void deletar(Integer codigo) {

        String sql = """
            DELETE FROM cliente
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao excluir cliente.", e);
        }
    }

    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("telefone"));
    }


    @Override
    public boolean existeCpf(String cpf) {

        String sql = """
            SELECT 1
              FROM cliente
             WHERE cpf = ?
            """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
