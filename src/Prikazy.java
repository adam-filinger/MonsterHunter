import java.util.List;

public class Prikazy {

    protected void jdi(Hrac hrac, String presunuti, List<Lokace> dostupneLokace){
        for(Lokace loc : dostupneLokace){
            if(loc.getNazev().contains(presunuti)){
                hrac.jdi(loc);
                System.out.println("Nacházíš se v: " + hrac.getUmisteni().getNazev());
            }
        }
    }


}
