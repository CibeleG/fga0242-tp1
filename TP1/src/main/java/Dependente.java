import java.util.GregorianCalendar;

public class Dependente {
    private GregorianCalendar birthDate;
    private String name;

    public Dependente(String name, GregorianCalendar birthDate) throws NomeEmBrancoException {
        if(name.split(" ").length == 0)
            throw new NomeEmBrancoException("Nome em branco");
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }
}
