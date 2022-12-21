public class Contribuicao {
    private String descricao;
    private float valor;

    public Contribuicao(String descricao, float valor) throws DescricaoEmBrancoException, ValorContribuicaoInvalidoException {
        if(descricao.split(" ").length == 0)
            throw new DescricaoEmBrancoException("Descrição em branco");
        if(valor < 0 || String.valueOf(valor).split(" ").length == 0)
        	throw new ValorContribuicaoInvalidoException("Valor da contribuição inválido");
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public float getValor() {
        return this.valor;
    }
}
