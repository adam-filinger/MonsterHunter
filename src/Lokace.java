import java.util.Set;

public class Lokace {

    private String nazev;

    private Set<Lokace> obsahuje;

    public Lokace(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }
}
