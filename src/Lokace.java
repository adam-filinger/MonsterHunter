import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lokace {
    @JsonProperty("nazev")
    private String nazev;
    @JsonProperty("podLokace")
    private List<Lokace> podLokace;
    @JsonProperty
    private Lokace nadLokace;

    public Lokace() {
        this.podLokace = new ArrayList<>();
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setpodLokace(ArrayList<Lokace> seznam) {
        podLokace = seznam;
    }

    public void setNadLokace(Lokace nadLokace) {
        this.nadLokace = nadLokace;
    }

    public Lokace getNadLokace() {
        return nadLokace;
    }

    public void addpodLokace(Lokace seznam) {
        podLokace.add(seznam);
    }

    public List<Lokace> getpodLokace() {
        return podLokace;
    }

    public void vypisSeznamPodLokaci(String indent){
        System.out.println(indent + nazev);
        for(Lokace seznam : podLokace){
            seznam.vypisSeznamPodLokaci(" " + indent);
        }
    }

    public void nastavNadLokaci(){
        for(Lokace loc : podLokace){
            loc.setNadLokace(this);
        }
    }

}
