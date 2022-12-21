public class CalculoImposto {
    public double baseCalculo(Contribuinte contribuinte) {
        double rendimentos = totalRend(contribuinte);
        double deducoes = totalDedu(contribuinte);
        double baseImposto = rendimentos - deducoes;
        return baseImposto;
    }

    public double calFaixa(double valorSuperior, double valorInferior, double aliquota) {
        double valorFaixa = (valorSuperior - valorInferior) * aliquota;
        return valorFaixa;
    }

    public double imposto(Contribuinte contribuinte) throws BaseInvalidaException {
        double totalImpostos = -1;
        double base = baseCalculo(contribuinte);

        if (base < 0) {
            throw new BaseInvalidaException(base);
        }
        else if (base <= 1903.98) {
            totalImpostos = 0;
        }
        else if (base <= 2826.65) {
            totalImpostos = calFaixa(base,1903.98,0.075);
        }
        else if (base <= 3751.05) {
            totalImpostos = calFaixa(2826.65,1903.98,0.075)+calFaixa(base,2826.65,0.15);
        }
        else if (base <= 4664.68) {
            totalImpostos = calFaixa(2826.65,1903.98,0.075)+calFaixa(3751.05,2826.65,0.15)+
                    calFaixa(base,3751.05,0.225);
        }
        else if (base >  4664.68) {
            totalImpostos = calFaixa(2826.65,1903.98,0.075)+calFaixa(3751.05,2826.65,0.15)+
                    calFaixa(4664.68,3751.05,0.225)+calFaixa(base,4664.68,0.27);
        }
        else {
            throw new BaseInvalidaException(base);

        }

        return totalImpostos;
    }
}
