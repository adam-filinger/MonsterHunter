import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static boolean hraSpustena = true;
    private static List<Lokace> dostupneLokace = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        String command;
        Hrac hrac = new Hrac();

        List<Lokace> vsechnyLokace = new ArrayList<>(){{
        }};

        try {
            // Read the JSON file and map it to a list of Location objects
            vsechnyLokace = mapper.readValue(new File("files/locations.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Lokace.class));

        } catch (IOException e) {
            e.printStackTrace();
        }

        hrac.setUmisteni(vsechnyLokace.get(0));
        for(Lokace loc : vsechnyLokace) {
            loc.nastavNadLokaci();
        }

        while(hraSpustena) {
            dostupneLokace.clear();
            if(hrac.getUmisteni().getNadLokace() == null){
                dostupneLokace = hrac.getUmisteni().getpodLokace();
                for(Lokace loc : vsechnyLokace){
                    if(!loc.equals(hrac.getUmisteni())){
                        dostupneLokace.add(loc);
                    }
                }
            }else if(hrac.getUmisteni().getpodLokace().isEmpty()){
                dostupneLokace.add(hrac.getUmisteni().getNadLokace());
            }else{
                dostupneLokace = hrac.getUmisteni().getpodLokace();
                dostupneLokace.add(hrac.getUmisteni().getNadLokace());
            }
            for(Lokace lokace : dostupneLokace) {
                System.out.println(lokace.getNazev());
            }

            System.out.println("Enter a command: ");
            command = scanner.nextLine();
            if(command.equals("promluv")){
                hrac.promluv();
            } else if(command.contains("jdi")){
                String presunuti = command.substring(4);
                for(Lokace loc : dostupneLokace){
                    if(loc.getNazev().contains(presunuti)){
                        hrac.jdi(loc);
                        System.out.println("Nacházíš se v: " + hrac.getUmisteni().getNazev());
                    }
                }
            } else if (command.equals("konec")) {
                hraSpustena = false;
            } else{
                System.out.println("Zadán neplatný příkaz");
            }

        }


    }
}