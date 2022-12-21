public class Rendimento {
	private String descricaoRendimento;
	private float totalRendimento;
	
	public Rendimento(String descricaoRendimento, float valorRendimento) {
		this.descricaoRendimento = descricaoRendimento;
		this.totalRendimento = valorRendimento;
	}

	public float getRendimento() {
		return totalRendimento;
	}
}