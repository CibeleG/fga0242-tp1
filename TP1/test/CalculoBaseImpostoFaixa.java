import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoBaseImpostoFaixa {

    private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    @Test
    public void testCalculoBaseFaixaUm() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException {
        simul.cadastroRendimento("Salario", 5000f);

        assertEquals("1903,98", String.format("%.2f", simul.calcularValorBaseFaixa(1)));
    }

    @Test
    public void testCalculoBaseFaixaDois() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException {
        simul.cadastroRendimento("Salario", 5000f);

        assertEquals("922,67", String.format("%.2f", simul.calcularValorBaseFaixa(2)));
    }

    @Test
    public void testCalculoBaseFaixaTres() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException {
        simul.cadastroRendimento("Salario", 5000f);

        assertEquals("924,40", String.format("%.2f", simul.calcularValorBaseFaixa(3)));
    }

}
