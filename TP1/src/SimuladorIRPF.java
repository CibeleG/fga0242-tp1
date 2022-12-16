import java.util.*;

public class SimuladorIRPF {
    private ArrayList<Float> pensoes;
    private List<Dependente> dependentes;

    SimuladorIRPF(){
        pensoes = new ArrayList<Float>();
        dependentes = new LinkedList<Dependente>();
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
}
