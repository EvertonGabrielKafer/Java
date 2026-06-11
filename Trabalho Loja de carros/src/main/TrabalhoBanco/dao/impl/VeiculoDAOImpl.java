package main.TrabalhoBanco.dao.impl;

import main.TrabalhoBanco.connection.ConnectionFactory;
import main.TrabalhoBanco.dao.VeiculoDAO;
import main.TrabalhoBanco.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAOImpl implements VeiculoDAO {

    @Override
    public Veiculo salvar(Veiculo entidade) {
        String sql = "INSERT INTO veiculo (marca, modelo, ano, valor, disponivel)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entidade.getMarca());
            ps.setString(2, entidade.getModelo());
            ps.setInt(3, entidade.getAno());
            ps.setDouble(4, entidade.getValor());
            ps.setBoolean(5, entidade.getDisponivel());
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
    public List<Veiculo> listarTodos() {
        String sql = "SELECT codigo, marca, modelo, ano, valor, disponivel " +
                "FROM veiculo ORDER BY modelo";
        List<Veiculo> veiculo = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                veiculo.add(mapearVeiculo(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return veiculo;
    }

    @Override
    public Veiculo buscarPorId(Integer integer) {
        String sql = """
            SELECT codigo, marca, modelo, ano, valor, disponivel
              FROM veiculo
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, integer);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearVeiculo(rs);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Veiculo atualizar(Veiculo entidade) {
        String sql = """
            UPDATE veiculo SET marca = ?, modelo = ?, ano = ?, valor = ?, disponivel = ?
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidade.getMarca());
            ps.setString(2, entidade.getModelo());
            ps.setInt(3, entidade.getAno());
            ps.setDouble(4, entidade.getValor());
            ps.setBoolean(5, entidade.getDisponivel());
            ps.setInt(6, entidade.getCodigo());

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
            DELETE FROM veiculo
             WHERE codigo = ?
            """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao excluir veiculo.", e);
        }
    }

    private Veiculo mapearVeiculo(ResultSet rs) throws SQLException {
        return new Veiculo(
                rs.getInt("codigo"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getInt("ano"),
                rs.getDouble("valor"),
                rs.getBoolean("disponivel"));
    }

}
