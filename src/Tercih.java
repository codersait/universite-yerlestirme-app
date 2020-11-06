import java.util.ArrayList;

public class Tercih {
    private String ogrenciAdi;
    private ArrayList<String> tercih;
    private double puan;
    private String sayisalCevaplari;
    private String sozelCevaplari;

    public Tercih(String ogrenciAdi,String sayisalCevaplari,
                  String sozelCevaplari,double puan,
                  ArrayList<String> tercih){
        this.ogrenciAdi = ogrenciAdi;
        this.puan = puan;
        this.tercih = tercih;
        this.sayisalCevaplari = sayisalCevaplari;
        this.sozelCevaplari = sozelCevaplari;
    }

    public Tercih(){
        this("","","",0,null);
    }

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public ArrayList<String> getTercih() {
        return tercih;
    }

    public double getPuan() {
        return puan;
    }


    public String toString(){
        return "Ogrenci: "+
                this.ogrenciAdi+"\n\tSayisal Cevaplari:"+this.sayisalCevaplari+
                "\n\tSozel Cevaplari:"+this.sozelCevaplari+"\nOgrenci Puani:"+this.puan+
                "\n\tUniversite Tercihleri:"+this.tercih+
                "\n------------------";
    }
}
