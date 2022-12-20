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
	
	@Test
	public void testeCadastroRendimento() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento("Salario", 10000f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}
	
	@Test(expected = DescricaoEmBrancoException.class)
	public void testeCadastroRendimentoDescricaoEmBranco() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento(null, 10000f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}
	
	@Test (expected = ValorRendimentoInvalidoException.class)
	public void testeCadastroRendimentoValorZero() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento("Salario", 0f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}
	
	@Test (expected = ValorRendimentoInvalidoException.class)
	public void testeCadastroRendimentoValorNegativo() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastroRendimento("Salario", -500f);
		assertEquals(10000f, simulador.getTotalRendimento(), 0f);
	}

}