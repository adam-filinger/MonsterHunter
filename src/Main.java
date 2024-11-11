import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static Hrac hrac = new Hrac();
    private static boolean hraSpustena = true;
    private static List<Lokace> vsechnyLokace = new ArrayList<>();
    private static List<Lokace> dostupneLokace = new ArrayList<>();
    private static Prikazy prikazy = new Prikazy();

    private static Scanner scanner = new Scanner(System.in);
    private static ObjectMapper mapper = new ObjectMapper();
    private static String command;

    public static void main(String[] args) {

        nactiLokace("files/locations.json");
        hrac.setUmisteni(vsechnyLokace.get(0));

        for(Lokace loc : vsechnyLokace) {
            loc.nastavNadLokaci();
            for(Lokace loc2 : loc.getpodLokace()){
                loc2.nastavNadLokaci();
            }
        }

        nastavDostupneLokace();

        while(hraSpustena){

            for(Lokace lokace : dostupneLokace) {
                System.out.println(lokace.getNazev());
            }

            System.out.println("Enter a command: ");
            command = scanner.nextLine();
            if(command.equals("promluv")){
                hrac.promluv();
            } else if(command.contains("jdi")){
                String presunuti = command.substring(4);
                if(prikazy.jdi(hrac, presunuti, dostupneLokace)){
                    nastavDostupneLokace();
                }
            } else if (command.equals("konec")) {
                hraSpustena = false;
            } else{
                System.out.println("Zadán neplatný příkaz");
            }

        }

    }

    public static void nactiLokace(String path){
        try {
            // Read the JSON file and map it to a list of Location objects
            vsechnyLokace = mapper.readValue(new File(path),
                    mapper.getTypeFactory().constructCollectionType(List.class, Lokace.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nastavDostupneLokace(){
        Lokace momentalniLokace = hrac.getUmisteni();
        dostupneLokace.clear();

        if(momentalniLokace.getNadLokace() == null){
            System.out.println("/");
            for(Lokace lokace : vsechnyLokace){
                if(!lokace.equals(momentalniLokace)){
                    dostupneLokace.add(lokace);
                }
            }
            for(Lokace podLokace : momentalniLokace.getpodLokace()){
                dostupneLokace.add(podLokace);
            }
        } else if(momentalniLokace.getpodLokace().isEmpty()){
            System.out.println("-");
            dostupneLokace.add(momentalniLokace.getNadLokace());
        } else {
            System.out.println("+");
            dostupneLokace.add(momentalniLokace.getNadLokace());
            for(Lokace loc : momentalniLokace.getpodLokace()){
                dostupneLokace.add(loc);
            }
        }
    }

}