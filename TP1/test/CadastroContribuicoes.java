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
public class CadastroContribuicoes {
    Object [][] contribuicoes;
    String [] descricaoEsperado;
    float [] valorEsperado;

    SimuladorIRPF simul;
    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CadastroContribuicoes(Object [][] contribuicoes, String[] descricaoEsperado, float[] valorEsperado){
        this.contribuicoes = contribuicoes;
        this.descricaoEsperado = descricaoEsperado;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {new Object[][]{
                        {"PGBL", 1000f}
                }, new String[]{
                        "PGBL"
                }, new float[]{
                        1000f
                }},
                {new Object[][]{
                        {"PGBL", 1000f},
                        {"VGBL", 200f}
                }, new String[]{
                        "PGBL",
                        "VGBL"
                },new float[]{
                        1000f,
                        200f
                }},
        });
    }

    @Test
    public void testCadastroContribuicoes() throws DescricaoEmBrancoException, ValorContribuicaoInvalidoException  {
        for(Object[] dp: contribuicoes){
            simul.cadastrarContribuicao((String) dp[0], (float) dp[1]);

        }
        int count = 0;
        for(String ne: descricaoEsperado){
            assertEquals(ne, simul.getContribuicoes().get(count++).getDescricao());
        }
        count = 0;
        for(Float ne: valorEsperado){
            assertEquals(ne, simul.getContribuicoes().get(count++).getValor(), 0f);
        }

    }
}
