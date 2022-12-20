import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CadastroPensoes {
    Object[][] pensoes;
    float valorEsperado;
    SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CadastroPensoes(Object[][] pensoes, float valorEsperado){
        this.pensoes = pensoes;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {new Object[][]{
                        {1000f}
                }, 1000f},
                {new Object[][]{
                        {1000f},
                        {2000f},
                }, 3000f},
                {new Object[][]{
                        {1000f},
                        {2000f},
                        {500f}
                }, 3500f},
        });
    }

    @Test
    public void testCadastroPensoes(){
        for(Object[] o: pensoes){
            simul.cadastrarPensaoAlimenticia((float) o[0]);
        }
        assertEquals(valorEsperado, simul.getTotalPensoes(), 0f);
    }
}
