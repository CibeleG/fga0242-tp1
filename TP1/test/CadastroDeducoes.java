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
public class CadastroDeducoes {
    Object [][] deducoes;
    String [] descricaoEsperado;
    float [] valorEsperado;

    SimuladorIRPF simul;
    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CadastroDeducoes(Object [][] deducoes, String[] descricaoEsperado, float[] valorEsperado){
        this.deducoes = deducoes;
        this.descricaoEsperado = descricaoEsperado;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {new Object[][]{
                        {"Previdencia privada", 1200f}
                }, new String[]{
                        "Previdencia privada"
                },new float[]{
                        1200f
                }},
                {new Object[][]{
                        {"Previdencia privada", 1200f},
                        {"Funpresp", 400f}
                }, new String[]{
                        "Previdencia privada",
                        "Funpresp"
                },new float[]{
                        1200f,
                        400f
                }},
        });
    }

    @Test
    public void testCadastroDeducoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException  {
        for(Object[] dp: deducoes){
            simul.cadastrarDeducao((String) dp[0], (float) dp[1]);
        }
        int count = 0;
        for(String ne: descricaoEsperado){
            assertEquals(ne, simul.getDeducoes().get(count++).getDescricao());
        }
        count = 0;
        for(Float ne: valorEsperado){
            assertEquals(ne, simul.getDeducoes().get(count++).getValor(), 0f);
        }
    }
}
