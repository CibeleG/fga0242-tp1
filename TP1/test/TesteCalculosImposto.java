import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Test;

public class TesteImposto {
    Rendimento[] r = new Rendimento[] {new Rendimento(1200,"salario"),new Rendimento(400,"bolsa")};
    Deducao[] d = new Deducao[] {new Deducao(190,"dependente"),new Deducao(200,"pensao")};
    Contribuinte c = Contribuinte.NovoContribuinte("Caio",r,d);
    CalculoImposto calcula = new CalculoImposto();

    @Test
    public void testCalFaixa() {
        double valorFaixa = calcula.calFaixa(2563.91,1710.79,0.075);
        assertEquals(valorFaixa,63.983999,0);
    }

    @Test
    public void testTotalImposto() throws BaseInvalidaException {
        double valorImposto = calcula.imposto(c);
        assertEquals(valorImposto,0,0);
    }

    @Test
    public void totalRend() {
        double somaRendimentos = calcula.totalRend(c);
        assertEquals(somaRendimentos,1600,0);
    }

    @Test
    public void totalDedu() {
        double somaDeducoes = calcula.totalDedu(c);
        assertEquals(somaDeducoes,390,0);
    }

}