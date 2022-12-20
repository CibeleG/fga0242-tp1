package src;

import java.util.LinkedList;
import java.util.List;

public class SimuladorIRPF {
		
	private List <Rendimento> rendimentos;
	private float totalRendimento;
	
	public SimuladorIRPF() {
		rendimentos = new LinkedList <Rendimento>();
	}
	
	public void cadastroRendimento(String descricaoRendimento, float valorRendimento) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException{
		if(descricaoRendimento == null) {
			throw new DescricaoEmBrancoException();
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
}