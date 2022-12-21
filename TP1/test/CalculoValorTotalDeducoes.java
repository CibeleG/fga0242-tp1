import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoValorTotalDeducoes {
    SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    @Test
    public void ValorTotalUmaDeducao() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
        simul.cadastrarDeducao("Saúde", 450f);

        assertEquals(450f, simul.getTotalDeducoes(), 0f);
    }

}
