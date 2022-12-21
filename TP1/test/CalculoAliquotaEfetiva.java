import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculoAliquotaEfetiva {
    Object[][] rendimentos;
    Object[][] deducoes;
    String valorEsperado;

    private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }

    public CalculoAliquotaEfetiva(Object[][] rendimentos, Object[][] deducoes, String valorEsperado){
        this.rendimentos = rendimentos;
        this.deducoes = deducoes;
        this.valorEsperado = valorEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {new Object[][]{
                        {"Salario", 5250f}
                }, new Object[][]{
                        {"Saude", 250f}
                }, "0,0963"},
                {new Object[][]{
                        {"Salario", 5250f},
                        {"Servico", 1250f}
                }, new Object[][]{
                        {"Saude", 250f},
                }, "0,1307"},
                {new Object[][]{
                        {"Salario", 5250f}
                }, new Object[][]{
                        {"Saude", 250f},
                        {"Pensao", 1250f}
                }, "0,0396"}
        });
    }

    @Test
    public void testCalculoBaseFaixa() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException {
        for(Object [] rd: rendimentos){
            simul.cadastroRendimento((String) rd[0], (Float) rd[1]);
        }

        for(Object [] de: deducoes){
            simul.cadastrarDeducao((String) de[0], (Float) de[1]);
        }

        assertEquals(valorEsperado, String.format("%.4f", simul.getAliquotaEfetiva()));
    }
}
