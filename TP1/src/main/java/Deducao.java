public class Deducao {
    private String descricao;
    private float valor;

    public Deducao(String descricao, float valorDeducao) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        if(descricao.split(" ").length == 0)
            throw new DescricaoEmBrancoException("Descrição em branco");
        if(valorDeducao < 0 || String.valueOf(valorDeducao).split(" ").length == 0)
        	throw new ValorDeducaoInvalidoException("Valor da dedução inválido");
        this.descricao = descricao;
        this.valor = valorDeducao;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public float getValor() {
        return this.valor;
    }
}
