package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres"; // Geralmente é 'postgres'
    private static final String SENHA = "Alexlan23*!";


    public static Connection Conectar() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL ,USUARIO ,SENHA);
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: O Driver do PostgreSQL não foi encontrado na pasta lib!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados!");
            e.printStackTrace();
            return null;
        }

    }

    public static void FecharConexao( Connection conexao) {
        if (conexao != null){
            try {
                conexao.close();
                System.out.println("Conexão com o banco fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão.");
                e.printStackTrace();
            }
        }
    }
}
