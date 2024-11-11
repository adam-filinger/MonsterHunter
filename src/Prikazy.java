import java.util.List;

public class Prikazy {

    protected boolean jdi(Hrac hrac, String presunuti, List<Lokace> dostupneLokace){
        for(Lokace loc : dostupneLokace){
            if(loc.getNazev().contains(presunuti)){
                hrac.jdi(loc);
                System.out.println("-----------");
                System.out.println("Nacházíš se v: " + hrac.getUmisteni().getNazev());
                System.out.println("----------");
                return true;
            }
            if(dostupneLokace.indexOf(loc) == dostupneLokace.size()-1){
                System.out.println("------------");
                System.out.println("Lokace není dostupná");
                System.out.println("-------------");
            }
        }
        return false;
    }


}
