import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        List<String> commands = new ArrayList<>();
        commands.add("promluv");
        commands.add("jdi");
        Hrac hrac = new Hrac();
        Lokace rivald = new Lokace("Rivald");
        List<Lokace> vsechnyLokace = new ArrayList<>();
        vsechnyLokace.add(rivald);

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
            }



            System.out.println("Command entered: " + command);
        }


    }
}