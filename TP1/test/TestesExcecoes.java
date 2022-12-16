import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

public class TestesExcecoes {
    SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    @Test(expected = NomeEmBrancoException.class)
    public void cadastrarDependenteSemNome() throws NomeEmBrancoException {
        simul.cadastrarDependente(" ", new GregorianCalendar(1981, 12, 20));
    }
}
