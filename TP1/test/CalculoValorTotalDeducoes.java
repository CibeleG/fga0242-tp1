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

    @Test
    public void ValorTotalDuasDeducoes() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
        simul.cadastrarDeducao("Saúde", 2450f);
        simul.cadastrarDeducao("Educacao", 1090f);


        assertEquals(3540f, simul.getTotalDeducoes(), 0f);
    }

    @Test
    public void ValorTotalTresDeducoes() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
        simul.cadastrarDeducao("Saúde", 2450f);
        simul.cadastrarDeducao("Educacao", 1090f);
        simul.cadastrarDeducao("Pensao", 1700f);

        assertEquals(5240f, simul.getTotalDeducoes(), 0f);
    }

}
