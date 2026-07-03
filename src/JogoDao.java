import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDao {

    public void salvar(Jogo jogo){

        String sql = "INSERT INTO jogos (titulo, genero, preco, plataforma, disponivel, descricao, ano_lancamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.Conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, jogo.getTitulo());
            stmt.setString(2, jogo.getGenero());
            stmt.setDouble(3, jogo.getPreco());
            stmt.setString(4, jogo.plataforma);
            stmt.setBoolean(5, jogo.isDisponivel());
            stmt.setString(6, jogo.descricao);
            stmt.setInt(7 , jogo.anoLancamento);

            stmt.executeUpdate();
            System.out.println("Jogo cadastrado com sucesso!");
        }
        catch(SQLException e){
            System.out.println("Erro ao cadastrar Jogo!");
            e.printStackTrace();
        }
    }

    public void atualizar(Jogo jogo){

        String sql = "UPDATE jogos SET titulo = ? , genero = ? , preco = ? , plataforma = ?, disponivel = ?, descricao = ?, ano_lancamento = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.Conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, jogo.getTitulo());
            stmt.setString(2, jogo.getGenero());
            stmt.setDouble(3, jogo.getPreco());
            stmt.setString(4, jogo.plataforma);
            stmt.setBoolean(5, jogo.isDisponivel());
            stmt.setString(6, jogo.descricao);
            stmt.setInt(7, jogo.anoLancamento);
            stmt.setLong(8, jogo.getId());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Jogo atualizado com sucesso!");
            } else {
                System.out.println("Nenhum jogo encontrado com o ID informado.");
            }

        }catch(SQLException e){
            System.out.println("Erro ao atualizar Jogo!");
            e.printStackTrace();
        }

    }


    public List<Jogo> ListaTodos(Jogo jogo){

        String sql = "SELECT * FROM jogos WHERE id = ?";
        List <Jogo> jogos = new ArrayList<>();


        try (Connection comm = ConexaoBD.Conectar();
             PreparedStatement stmt = comm.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){



        }catch (SQLException e) {
            System.err.println("Erro ao listar os jogos.");
            e.printStackTrace();
        }

        return jogos;


    }


}
