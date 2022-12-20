
public class Contribuinte {
    String nome;
    Rendimento[] rendimentos;
    Deducao[] deducoes;

    public Contribuinte(String nome, Rendimento[] rendimentos, Deducao[] deducoes) {
        this.deducoes = deducoes;
        this.rendimentos = rendimentos;
        this.nome = nome;
    }

    public static Contribuinte NovoContribuinte(String nome, Rendimento[] rendimentos, Deducao[] deducoes) {
        Contribuinte c = new Contribuinte(nome, rendimentos, deducoes);
        return c;
    }

}