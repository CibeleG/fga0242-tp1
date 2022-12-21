import java.util.*;
public class SimuladorIRPF {
    private ArrayList<Float> pensoes;
    private List<Dependente> dependentes;
    private List<Deducao> deducoes;
    private List<Contribuicao> contribuicoes;
    private List <Rendimento> rendimentos;
	private float totalRendimento;

    private List<FaixaImposto> faixas;

    SimuladorIRPF(){
        pensoes = new ArrayList<Float>();
        dependentes = new LinkedList<Dependente>();
        deducoes = new LinkedList<Deducao>();
        contribuicoes = new LinkedList<Contribuicao>();
        rendimentos = new LinkedList <Rendimento>();
        faixas = new LinkedList<FaixaImposto>();

        faixas.add(new FaixaImposto(1, 1903.98f));
        faixas.add(new FaixaImposto(2, 922.67f));
        faixas.add(new FaixaImposto(3, 924.40f));
        faixas.add(new FaixaImposto(4, 913.63f));
        faixas.add(new FaixaImposto(5, 0f));
    }

    public void cadastroRendimento(String descricaoRendimento, float valorRendimento) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException{
		if(descricaoRendimento == null) {
			throw new DescricaoEmBrancoException("Descrição em Branco");
		}
		if (valorRendimento <= 0) {
			throw new ValorRendimentoInvalidoException();
		}
		
		Rendimento rendimentoNovo = new Rendimento(descricaoRendimento, valorRendimento);
		this.rendimentos.add(rendimentoNovo);
		
		this.totalRendimento += valorRendimento;
	}
	
	public float getTotalRendimento() {
		return totalRendimento;
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


    public float getTotalDeducoes() {
        float valorTotal = 0f;

        for(Deducao deducoes: this.deducoes){
            valorTotal += deducoes.getValor();
        }

        return valorTotal;
    }
}
