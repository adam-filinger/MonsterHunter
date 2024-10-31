import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        String command;
        Hrac hrac = new Hrac();
        List<Lokace> vsechnyLokace = new ArrayList<>(){{
        }};

        try {
            // Read the JSON file and map it to a list of Location objects
            vsechnyLokace = mapper.readValue(new File("locations.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Lokace.class));

            // Print the hierarchy to verify loading
            for (Lokace loc : vsechnyLokace) {
                loc.vypisSeznamPodLokaci(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){


            System.out.println("Enter a command: ");
            command = scanner.nextLine();
            if(command.equals("promluv")){
                hrac.promluv();
            } else if(command.contains("jdi")){
                String presunuti = command.substring(4);
                for(Lokace loc : vsechnyLokace){
                    if(loc.getNazev().equals(presunuti)){
                        hrac.jdi(loc);
                        System.out.println(hrac.getUmisteni().getNazev());
                    }
                }
            } else{
                System.out.println("Zadán neplatný příkaz");
            }

        }


    }
}