import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoValorImposto {
    private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    @Test
    public void testCalculoValorImpostoFaixaUm() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastrarDeducao("Saude", 250f);

        assertEquals("0,00", String.format("%.2f", simul.calcularValorImpostoFaixa(1)));
    }
    @Test
    public void testCalculoValorImpostoFaixaDois() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastrarDeducao("Saude", 250f);

        assertEquals("69,20", String.format("%.2f", simul.calcularValorImpostoFaixa(2)));
    }
    @Test
    public void testCalculoValorImpostoFaixaTres() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastrarDeducao("Saude", 250f);

        assertEquals("138,66", String.format("%.2f", simul.calcularValorImpostoFaixa(3)));
    }
}
