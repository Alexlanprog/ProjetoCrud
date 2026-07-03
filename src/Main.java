import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando conexão...");

        Connection conn = ConexaoBD.Conectar();

        if (conn != null) {
            System.out.println("Sucesso! O Java conectou ao PostgreSQL.");
            // Fecha a conexão logo em seguida para não deixar aberta à toa
            ConexaoBD.FecharConexao(conn);
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}