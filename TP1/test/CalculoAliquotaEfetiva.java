import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoAliquotaEfetiva {
    private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    @Test
    public void testCalculoAliquotaEfetiva() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastrarDeducao("Saude", 250f);

        assertEquals("0,0963", String.format("%.4f", simul.getAliquotaEfetiva()));
    }
}
