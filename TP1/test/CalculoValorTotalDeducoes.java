import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculoValorTotalDeducoes {
    SimuladorIRPF simul;

    Object[][] deducoes;
    float valorEsperado;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CalculoValorTotalDeducoes(Object[][] deducoes, float valorEsperado){
        this.deducoes = deducoes;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Collection<Object []> getParameters(){
        return Arrays.asList(
                new Object[][]{
                        {new Object[][]{
                                {"Saude", 2450f}
                        }, 2450f},
                        {new Object[][]{
                                {"Saúde", 2450f},
                                {"Educacao", 1090f}
                        }, 3540f},
                        {new Object[][]{
                                {"Pensao", 1700f},
                                {"Saúde", 2450f},
                                {"Educacao", 1090f}
                        }, 5240f},
                }
        );
    }

    @Test
    public void testCalculoValorTotalDeducoes() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
        for(Object[] deducao: deducoes){
            simul.cadastrarDeducao((String) deducao[0], (float) deducao[1]);
        }
        assertEquals(valorEsperado, simul.getTotalDeducoes(), 0f);

    }

}
