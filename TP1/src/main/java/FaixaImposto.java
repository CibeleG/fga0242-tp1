public class FaixaImposto {
    private float valorMinimo;
    private float valorMaximo;
    private float aliquota;

    public FaixaImposto(float valorMinimo, float valorMaximo, float aliquota) {
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.aliquota = aliquota;
    }

    public float getValorMinimo() {
        return valorMinimo;
    }

    public float getAliquota() {
        return aliquota;
    }

    public float getValorMaximo() {
        return valorMaximo;
    }
}
