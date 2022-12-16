import java.lang.reflect.Array;
import java.util.*;

public class SimuladorIRPF {
    ArrayList<Float> pensoes;
    SimuladorIRPF(){
        pensoes = new ArrayList<>();
    }
    public void cadastrarPensaoAlimenticia(float valor) {
        pensoes.add(valor);
    }

    public float getTotalPensoes() {
        float valorTotal = 0;
        for(float valor: pensoes){
            valorTotal += valor;
        }
        return valorTotal;
    }
}
