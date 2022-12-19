import java.util.*;

public class SimuladorIRPF {
    private ArrayList<Float> pensoes;
    private List<Dependente> dependentes;
    private List<Deducao> deducoes;
    private List<Contribuicao> contribuicoes;

    SimuladorIRPF(){
        pensoes = new ArrayList<Float>();
        dependentes = new LinkedList<Dependente>();
        deducoes = new LinkedList<Deducao>();
        contribuicoes = new LinkedList<Contribuicao>();
    }
    public void cadastrarPensaoAlimenticia(float valor) {
        pensoes.add(valor);
    }

    public float getTotalPensoes() {
        float valorTotal = 0;
        for(float valor: pensoes){
            valorTotal += valor;
        }
        return valorTotal;
    }

    public void cadastrarDependente(String nameDependente, GregorianCalendar dtNasc) throws NomeEmBrancoException {
        if(nameDependente.split(" ").length == 0){
            throw new NomeEmBrancoException("Nome em branco");
        }
        Dependente dependente = new Dependente(nameDependente, dtNasc);
        this.dependentes.add(dependente);
    }

    public List<Dependente> getDependentes() {
        return this.dependentes;
    }

    public void cadastrarDeducao(String descricaoDeducao, float valorDeducao) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        if(descricaoDeducao.split(" ").length == 0){
            throw new DescricaoEmBrancoException("Descrição em branco");
        }
        if(valorDeducao < 0 && String.valueOf(valorDeducao).split(" ").length == 0){
            throw new ValorDeducaoInvalidoException("Valor da dedução inválido");
        }
        Deducao deducao = new Deducao(descricaoDeducao, valorDeducao);
        this.deducoes.add(deducao);
    }

    public List<Deducao> getDeducoes() {
        return this.deducoes;
    }

    public void cadastrarContribuicao(String descricaoContribuicao, float valorContribuicao) throws DescricaoEmBrancoException, ValorContribuicaoInvalidoException {
        if(descricaoContribuicao.split(" ").length == 0){
            throw new DescricaoEmBrancoException("Descrição em branco");
        }
        if(valorContribuicao < 0 && String.valueOf(valorContribuicao).split(" ").length == 0){
            throw new ValorContribuicaoInvalidoException("Valor da contribuição inválido");
        }
        Contribuicao contribuicao = new Contribuicao(descricaoContribuicao, valorContribuicao);
        this.contribuicoes.add(contribuicao);
    }

    public List<Contribuicao> getContribuicoes() {
        return this.contribuicoes;
    }
}
