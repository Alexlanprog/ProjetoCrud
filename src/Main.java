import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JogoDao dao = new JogoDao();

       Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=================================");
            System.out.println("    GERENCIADOR DE JOGOS 🎮     ");
            System.out.println("=================================");
            System.out.println("1. Cadastrar Novo Jogo");
            System.out.println("2. Listar Todos os Jogos");
            System.out.println("3. Atualizar Preço de um Jogo");
            System.out.println("4. Deletar um Jogo");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado (evita bugs ao ler textos depois)

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRAR JOGO ---");
                    Jogo novoJogo = new Jogo();

                    System.out.print("Título: ");
                    novoJogo.setTitulo(scanner.nextLine());

                    System.out.print("Gênero: ");
                    novoJogo.setGenero(scanner.nextLine());

                    System.out.print("Preço: R$ ");
                    novoJogo.setPreco(scanner.nextDouble());
                    scanner.nextLine(); // Limpa buffer

                    System.out.print("Plataforma: ");
                    novoJogo.plataforma = scanner.nextLine();

                    System.out.print("Descrição: ");
                    novoJogo.descricao = scanner.nextLine();

                    System.out.print("Ano de Lançamento: ");
                    novoJogo.anoLancamento = scanner.nextInt();
                    scanner.nextLine(); // Limpa buffer

                    novoJogo.setDisponivel(true); // Padrão disponível ao cadastrar

                    dao.salvar(novoJogo);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE JOGOS CADASTRADOS ---");
                    List<Jogo> lista = dao.ListaTodos();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum jogo encontrado no banco de dados.");
                    } else {
                        for (Jogo j : lista) {
                            System.out.println("ID: " + j.getId() +
                                    " | Título: " + j.getTitulo() +
                                    " | Preço: R$ " + j.getPreco() +
                                    " | Plataforma: " + j.plataforma);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- ATUALIZAR PREÇO ---");
                    System.out.print("Digite o ID do jogo que deseja alterar: ");
                    Long idAlterar = scanner.nextLong();
                    scanner.nextLine(); // Limpa buffer

                    // Usando o truque seguro que aprendemos: buscar primeiro
                    Jogo jogoDoBanco = dao.BuscaporID(idAlterar);

                    if (jogoDoBanco != null) {
                        System.out.println("Jogo encontrado: " + jogoDoBanco.getTitulo() + " (Preço atual: R$ " + jogoDoBanco.getPreco() + ")");
                        System.out.print("Digite o NOVO preço: R$ ");
                        double novoPreco = scanner.nextDouble();
                        scanner.nextLine(); // Limpa buffer

                        // Altera apenas o preço no objeto e manda atualizar
                        jogoDoBanco.setPreco(novoPreco);
                        dao.atualizar(jogoDoBanco);
                    } else {
                        System.out.println("Jogo não encontrado com o ID informado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- DELETAR JOGO ---");
                    System.out.print("Digite o ID do jogo que deseja excluir: ");
                    Long idDeletar = scanner.nextLong();
                    scanner.nextLine(); // Limpa buffer

                    dao.deletar(idDeletar);
                    break;

                case 0:
                    System.out.println("\nSaindo do sistema... Até mais! 👋");
                    rodando = false;
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();




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

   /*     Long idParaAlterar = 2L;

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
        }*/

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