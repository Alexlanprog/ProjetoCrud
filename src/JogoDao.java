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

    public List<Jogo> ListaTodos(){

        String sql = "SELECT * FROM jogos order by id";
        List <Jogo> Ljogos = new ArrayList<>();


        try (Connection comm = ConexaoBD.Conectar();
             PreparedStatement stmt = comm.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                Jogo jogo = new Jogo();

                // Mapeando dados do banco para os atributos privados (via Setter)
                jogo.setId(rs.getLong("id"));
                jogo.setTitulo(rs.getString("titulo"));
                jogo.setGenero(rs.getString("genero"));
                jogo.setPreco(rs.getDouble("preco"));
                jogo.setDisponivel(rs.getBoolean("disponivel"));

                // Mapeando dados do banco para os atributos públicos (Direto)
                jogo.plataforma = rs.getString("plataforma");
                jogo.descricao = rs.getString("descricao");
                jogo.anoLancamento = rs.getInt("ano_lancamento");

                Ljogos.add(jogo);
            }

        }catch (SQLException e) {
            System.err.println("Erro ao listar os jogos.");
            e.printStackTrace();
        }
        return Ljogos;

    }

    public Jogo BuscaporID(Long id){

        String sql = "SELECT * FROM jogos WHERE id = ?";
        Jogo jogo = null;

        try (Connection comm = ConexaoBD.Conectar();
             PreparedStatement stmt = comm.prepareStatement(sql);){

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                // Como o ID é único, usamos 'if' em vez de 'while'
                if (rs.next()) {
                    jogo = new Jogo();

                    // Atributos privados (Setters)
                    jogo.setId(rs.getLong("id"));
                    jogo.setTitulo(rs.getString("titulo"));
                    jogo.setGenero(rs.getString("genero"));
                    jogo.setPreco(rs.getDouble("preco"));
                    jogo.setDisponivel(rs.getBoolean("disponivel"));

                    // Atributos públicos (Direto)
                    jogo.plataforma = rs.getString("plataforma");
                    jogo.descricao = rs.getString("descricao");
                    jogo.anoLancamento = rs.getInt("ano_lancamento");
                }
            }

        }catch (SQLException e) {
            System.err.println("Erro ao buscar jogo.");
            e.printStackTrace();
        }
        return jogo;

    }

    public void deletar(Long ID){

    String sql = "DELETE FROM JOGOS WHERE id = ?";


        try(Connection conn = ConexaoBD.Conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setLong(1, ID);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Jogo excluído com sucesso!");
            } else {
                System.out.println("Nenhum jogo encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar o jogo.");
            e.printStackTrace();
        }
    }
}
