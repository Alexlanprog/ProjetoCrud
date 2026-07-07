import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JogoDao dao = new JogoDao();

      /* // --- TESTANDO O CREATE (SALVAR) ---
        System.out.println("Inserindo um novo jogo...");
        Jogo novoJogo = new Jogo();
        novoJogo.setTitulo("Horinzon 1  ");
        novoJogo.setGenero("Aventura");
        novoJogo.setPreco(49.99);
        novoJogo.setDisponivel(true);

        // Atributos públicos
        novoJogo.plataforma = "PC/ps4/ps5";
        novoJogo.descricao = "Jogo com aloy";
        novoJogo.anoLancamento = 2018;

        dao.salvar(novoJogo);*/

        //TESTANDO ATUALiZAR

        Long idParaAlterar = 2L;

        // 1. Buscamos o jogo completo do jeito que ele está hoje no banco
       Jogo jogoDoBanco = dao.BuscaporID(idParaAlterar);

        if (jogoDoBanco != null) {
            System.out.println("Jogo original encontrado: " + jogoDoBanco.getTitulo());
            System.out.println("Preço antigo: R$ " + jogoDoBanco.getPreco());

            // 2. Modificamos APENAS o que a gente quer mudar
            // O resto (gênero, plataforma, descrição) continua intacto dentro do objeto 'jogoDoBanco'
            jogoDoBanco.setPreco(89.90);

            dao.atualizar(jogoDoBanco);

        } else {
            System.out.println("Jogo não encontrado para atualização.");
        }

      /*  // --- TESTANDO DELETAR
        System.out.println("--- Jogos antes da exclusão ---");
        for (Jogo j : dao.ListaTodos()) {
            System.out.println("ID: " + j.getId() + " | Título: " + j.getTitulo());
        }

        // PASSO 2: Defina o ID do jogo que você quer apagar
        // Olhe no console o passo anterior ou no DBeaver e coloque um ID válido aqui (ex: 1)
        Long idParaDeletar = 1L;

        System.out.println("\n-> Executando a exclusão do ID: " + idParaDeletar);
        dao.deletar(idParaDeletar);

        // PASSO 3: Verificar se a exclusão funcionou de verdade
        System.out.println("\n--- Verificação pós-exclusão ---");*/
    }
}