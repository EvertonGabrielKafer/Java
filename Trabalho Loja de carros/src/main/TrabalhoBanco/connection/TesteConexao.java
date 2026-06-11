package main.TrabalhoBanco.connection;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {

        try (Connection conn =
                     ConnectionFactory.getConnection()) {

            System.out.println("Conectado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
