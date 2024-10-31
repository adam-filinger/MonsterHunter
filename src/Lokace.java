import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Lokace {
    @JsonProperty("nazev")
    private String nazev;
    @JsonProperty("podLokace")
    private Set<Lokace> podLokace;

    public Lokace() {
        this.podLokace = new HashSet<>();
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setpodLokace(HashSet<Lokace> seznam) {
        podLokace = seznam;
    }

    public void addpodLokace(Lokace seznam) {
        podLokace.add(seznam);
    }

    public Set<Lokace> getpodLokace() {
        return podLokace;
    }

    public void vypisSeznamPodLokaci(String indent){
        System.out.println(indent + nazev);
        for(Lokace seznam : podLokace){
            seznam.vypisSeznamPodLokaci(" " + indent);
        }
    }

}
