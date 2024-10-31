import java.util.ArrayList;
import java.util.List;

public class Hrac {

    private List<Predmet> batoh = new ArrayList<>();
    //Zapisnik - mozna .txt soubor
    private String zapisnik;
    private Lokace umisteni;

    public Lokace getUmisteni() {
        return umisteni;
    }

    public void setUmisteni(Lokace umisteni) {
        this.umisteni = umisteni;
    }

    public void jdi(Lokace loc){
        umisteni = loc;
    }

    public void promluv(Postava npc){
    }

    public void zautoc(){
    }

    public void obrana(){
    }

    public void vypij(Predmet p){
    }

    public void otevriBatoh(){
    }

    public void prectiZapisnik(){
    }

    public void zapis(){
    }

    public void mapa(){

    }

    public void promluv(){
        System.out.println("Hello World");
    }


}
