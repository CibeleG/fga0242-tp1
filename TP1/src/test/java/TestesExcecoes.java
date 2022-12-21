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
    
    @Test(expected = DescricaoEmBrancoException.class)
    public void cadastrarDeducaoSemDescricao() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        simul.cadastrarDeducao(" ", 1400);
    }
    
    @Test(expected = ValorDeducaoInvalidoException.class)
    public void cadastrarDeducaoComValorNegativo() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
        simul.cadastrarDeducao("Funpresp", -1300);
    }
    
    @Test(expected = DescricaoEmBrancoException.class)
    public void cadastrarContribuicaoSemDescricao() throws DescricaoEmBrancoException, ValorContribuicaoInvalidoException {
        simul.cadastrarContribuicao(" ", 600);
    }
    
    @Test(expected = ValorContribuicaoInvalidoException.class)
    public void cadastrarContribuicaoComValorNegativo() throws ValorContribuicaoInvalidoException, DescricaoEmBrancoException {
        simul.cadastrarContribuicao("PGBL", -700);
    }
}
