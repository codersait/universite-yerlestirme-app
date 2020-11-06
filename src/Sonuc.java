import java.util.ArrayList;

public class Sonuc {
    private String name;
    private String universite;
    private double puan;

    public Sonuc(String name, String universite,double puan) {
        this.name = name;
        this.universite = universite;
        this.puan = puan;
    }

    private String rename(String item){
        if(item.equals("IZM")){
            return "IZMIR UNIVERSITESI";
        } else if (item.equals("IST")){
            return "ISTANBUL UNIVERSITESI";
        } else if (item.equals("ANK")){
            return "ANKARA UNIVERSITESI";
        }
        return "";
    }

    public String toString(){
        return name + " "+puan+" puan ile "+rename(this.universite)+"' ni kazandiniz.Tebrikler!!!";
    }

    public String getName() {
        return name;
    }
}
