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
    public void testCalculoBaseUmaFaixa() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException {
        simul.cadastroRendimento("Salario", 5000f);

        assertEquals(1903.98f, simul.calcularValorBaseFaixa(1), 0f);
    }

}
