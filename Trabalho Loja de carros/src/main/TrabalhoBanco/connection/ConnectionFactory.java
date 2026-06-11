package main.TrabalhoBanco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/TrabalhoJava";
    private static final String USUARIO = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String SENHA = System.getenv().getOrDefault("DB_PASS", "123");

    public ConnectionFactory() { }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    URL,
                    USUARIO,
                    SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }
}