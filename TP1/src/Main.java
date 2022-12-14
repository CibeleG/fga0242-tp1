package src;

import java.util.LinkedList;
import java.util.List;



public class Simulador {
		
	private List <Rendimento> rendimentos;
	
	public Simulador() {
		rendimentos = new LinkedList <Rendimento>();
	}
	
	public void cadastroRendimento(String descricaoRendimento, float valorRendimento) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException{
		if(descricaoRendimeto == null) {
			throw new DescricaoEmBrancoException();
		}
		if (valorRendimento <= 0) {
			throw new ValorRendimentoInvalidoException();
		}
		
		Rendimento rendimentoNovo = new Rendimento(descricaoRendimento, valorRendimento);
		this.rendimentos.add(rendimentoNovo);
		
		this.totalRendimento += valorRendimento
	}
}