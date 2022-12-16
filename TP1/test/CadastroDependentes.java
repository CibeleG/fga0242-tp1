import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;

@RunWith(Parameterized.class)
public class CadastroDependentes {
    Object [][] dependentes;
    String [] nomeEsperado;

    SimuladorIRPF simul;
    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CadastroDependentes(Object [][] dependentes, String[] nomeEsperado){
        this.dependentes = dependentes;
        this.nomeEsperado = nomeEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {new Object[][]{
                        {"Joaquim da Silva Silverio", new GregorianCalendar(1981, 12, 20)}
                }, new String[]{
                        "Joaquim da Silva Silverio"
                }},
                {new Object[][]{
                        {"Joaquim da Silva Silverio", new GregorianCalendar(1981, 12, 20)},
                        {"Samuel da Silva Silverio", new GregorianCalendar(1995, 06, 19)}
                }, new String[]{
                        "Joaquim da Silva Silverio",
                        "Samuel da Silva Silverio"
                }},
                {new Object[][]{
                        {"Joaquim da Silva Silverio", new GregorianCalendar(1981, 12, 20)},
                        {"Samuel da Silva Silverio", new GregorianCalendar(1995, 06, 19)},
                        {"Manuel Rocha de Souza", new GregorianCalendar(1990, 07, 10)}
                }, new String[]{
                        "Joaquim da Silva Silverio",
                        "Samuel da Silva Silverio",
                        "Manuel Rocha de Souza"
                }},
        });
    }

    @Test
    public void testCadastroDependentes() throws NomeEmBrancoException {
        for(Object[] dp: dependentes){
            simul.cadastrarDependente((String) dp[0], (GregorianCalendar) dp[1]);

        }
        int count = 0;
        for(String ne: nomeEsperado){
            assertEquals(ne, simul.getDependentes().get(count++).getName());
        }
    }
}
