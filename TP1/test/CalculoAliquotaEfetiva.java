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
    public void testCalculoAliquotaEfetivaUmRendimento() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastrarDeducao("Saude", 250f);

        assertEquals("0,0963", String.format("%.4f", simul.getAliquotaEfetiva()));
    }

    @Test
    public void testCalculoAliquotaEfetivaDoisRendimentos() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastroRendimento("Servico", 1250f);
        simul.cadastrarDeducao("Saude", 250f);

        assertEquals("0,1307", String.format("%.4f", simul.getAliquotaEfetiva()));
    }

    @Test
    public void testCalculoAliquotaEfetivaDuasDeducoes() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastroRendimento("Salario", 5250f);
        simul.cadastrarDeducao("Saude", 250f);
        simul.cadastrarDeducao("Pensao", 1250f);


        assertEquals("0,0396", String.format("%.4f", simul.getAliquotaEfetiva()));
    }
}
