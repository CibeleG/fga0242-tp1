
public class Contribuinte {
    private String nome;
    private Rendimento[] rendimentos;
    private Deducao[] deducoes;

    public Contribuinte(String nome, Rendimento[] rendimentos, Deducao[] deducoes) {
        this.deducoes = deducoes;
        this.rendimentos = rendimentos;
        this.nome = nome;
    }

    public static Contribuinte NovoContribuinte(String nome, Rendimento[] rendimentos, Deducao[] deducoes) {
        Contribuinte c = new Contribuinte(nome, rendimentos, deducoes);
        return c;
    }

    public Rendimento[] getRendimentos() {
        return rendimentos;
    }
    public Deducao[] getDeducoes() {
        return deducoes;
    }
}