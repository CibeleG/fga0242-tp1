import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculoValorImposto {
    Object[][] rendimentos;
    Object[][] deducoes;
    int faixa;
    String valorEsperado;

    private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CalculoValorImposto(Object[][] rendimentos, Object[][] deducoes, int faixa, String valorEsperado){
        this.rendimentos = rendimentos;
        this.deducoes = deducoes;
        this.faixa = faixa;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {new Object[][]{
                        {"Salario", 5250f}
                }, new Object[][]{
                        {"Saude", 250f}
                }, 1,"0,00"},
                {new Object[][]{
                        {"Salario", 5250f}
                }, new Object[][]{
                        {"Saude", 250f}
                }, 2,"69,20"},
                {new Object[][]{
                        {"Salario", 5250f}
                }, new Object[][]{
                        {"Saude", 250f}
                }, 3,"138,66"}
        });
    }

    @Test
    public void testCalculoImpostoFaixa() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        for(Object [] rd: rendimentos){
            simul.cadastroRendimento((String) rd[0], (Float) rd[1]);
        }

        for(Object [] de: deducoes){
            simul.cadastrarDeducao((String) de[0], (Float) de[1]);
        }

        assertEquals(valorEsperado, String.format("%.2f", simul.calcularValorImpostoFaixa(faixa)));
    }
}
