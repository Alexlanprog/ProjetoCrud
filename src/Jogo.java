public class Jogo {

    private String titulo;
    private String genero;
    private double preco;
    private boolean disponivel;
    private long ID;

    public String plataforma;
    public String descricao;
    public int anoLancamento;


    public Jogo() {

    }

    public Jogo(Long id, String titulo, String genero, double preco, String plataforma, boolean disponivel, String descricao, int anoLancamento) {

        this.ID = id;
        this.titulo = titulo;
        this.genero = genero;
        this.preco = preco;
        this.plataforma = plataforma;
        this.disponivel = disponivel;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo; }

    public Long getId() { return ID; }
    public void setId(Long id) { this.ID = id; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

}
