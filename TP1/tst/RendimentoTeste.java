package tst;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import DescricaoEmBrancoException;
import SimuladorIRPF;
import ValorRendimentoInvalidoException;

import java.util.Arrays;
import java.util.Collection;


 @RunWith(Parameterized.class)
public class RendimentoTeste {

	SimuladorIRPF simulador;
	private Object[][] rendimentos;
	private float valor;
	
	@Before
	public void setup() {
		simulador = new SimuladorIRPF();
	}
	
	public CadastroRendimentosTeste(Object[][] rendimentos, float valor) {
		this.rendimentos = rendimentos;
		this.valor = valor;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		Object[][] retorno = new Object[][] {
			{new Object[][] {
				{"Salario", 500f},
			}, 500f},
			{new Object[][] {
				{"Salario", 4000f}, 
				{"Aluguel", 10000f}
			}, 14000f}, 
			{new Object[][] {
				{"Salario", 5000f}, 
				{"Aluguel", 9000f}
			}, 11000f}
		};
		
		return Arrays.asList(retorno);
	}
	
	
	@Test
	public void testCadastroRendimentos() {
		for (Object[] objeto : rendimentos) {
			simulador.cadastroRendimento((String)objeto[0], (float)objeto[1]);
		}
		assertEquals(valor, simulador.getTotalRendimento(), 0f);
	}
	
	@Test
	public void testeCadastraUmRendimento() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento("Salario", 10000f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}
	
	@Test(expected = DescricaoEmBrancoException.class)
	public void testeCadastraRendimentoDescricaoEmBranco() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento(null, 10000f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}
	
	@Test (expected = ValorRendimentoInvalidoException.class)
	public void testeCadastraRendimentoValorZero() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento("Salario", 0f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}
	
	@Test (expected = ValorRendimentoInvalidoException.class)
	public void testeCadastraRendimentoValorNegativo() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento("Salario", -500f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}

}