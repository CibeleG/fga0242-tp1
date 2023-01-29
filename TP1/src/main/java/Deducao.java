public class Deducao {
    private String descricao;
    private float valor;

    public Deducao(String descricao, float valorDeducao) {
        this.descricao = descricao;
        this.valor = valorDeducao;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public float getValor() {
        return this.valor;
    }

    public boolean validate() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
        if(this.descricao.split(" ").length == 0)
            throw new DescricaoEmBrancoException("Descrição em branco");

        if(this.valor < 0 || String.valueOf(this.valor).split(" ").length == 0)
            throw new ValorDeducaoInvalidoException("Valor da dedução inválido");
        return true;
    }
}
