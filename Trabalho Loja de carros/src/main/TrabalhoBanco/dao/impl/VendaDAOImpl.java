package main.TrabalhoBanco.dao.impl;

import main.TrabalhoBanco.connection.ConnectionFactory;
import main.TrabalhoBanco.dao.VendaDAO;
import main.TrabalhoBanco.model.Cliente;
import main.TrabalhoBanco.model.Veiculo;
import main.TrabalhoBanco.model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOImpl implements VendaDAO {

    @Override
    public Venda salvar(Venda entidade) {
        String sql = "INSERT INTO venda (data_venda, cliente_id, veiculo_id, valor_venda)" +
                " VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new java.sql.Date(entidade.getDataVenda().getTime()));
            ps.setInt(2, entidade.getCliente().getCodigo());
            ps.setInt(3, entidade.getVeiculo().getCodigo());
            ps.setDouble(4, entidade.getValorVenda());
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
    public List<Venda> listarTodos() {
        String sql = "SELECT codigo, data_venda, cliente_id, veiculo_id, valor_venda " +
                "FROM venda ORDER BY codigo";
        List<Venda> venda = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                venda.add(mapearVenda(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return venda;
    }

    @Override
    public Venda buscarPorId(Integer integer) {
        return null;
    }

    @Override
    public Venda atualizar(Venda entidade) {
        String sql = """
            UPDATE venda SET data_venda = ?, cliente_id = ?, veiculo_id = ?, valor_venda = ?
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(entidade.getDataVenda().getTime()));
            ps.setInt(2, entidade.getCliente().getCodigo());
            ps.setInt(3, entidade.getVeiculo().getCodigo());
            ps.setDouble(4, entidade.getValorVenda());
            ps.setInt(5, entidade.getCodigo());

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
            DELETE FROM venda
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao excluir venda.", e);
        }
    }

    private Venda mapearVenda(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCodigo(rs.getInt("cliente_id"));

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(rs.getInt("veiculo_id"));

        return new Venda(
                rs.getInt("codigo"),
                rs.getDouble("valor_venda"),
                veiculo,
                cliente,
                new java.util.Date(rs.getDate("data_venda").getTime()));
    }

}
