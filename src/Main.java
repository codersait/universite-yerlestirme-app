import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File dosya = new File("myFile.txt");
        ArrayList<Tercih> list = new ArrayList<>();
        puanHesapla(list, dosya);
        ArrayList<String> tumIsimler = new ArrayList<>();
        for(Tercih item:list){
            tumIsimler.add(item.getOgrenciAdi());
        }

        ArrayList<Sonuc> yerlesenler = yerlestimeYap(list);
        ArrayList<String> yerlesemeyenler = new ArrayList<>();
        ArrayList<String> yerlesenisimler = new ArrayList<>();

        for (Sonuc item:yerlesenler){
            System.out.println(item);
            yerlesenisimler.add(item.getName());
        }

        for (String item:tumIsimler){
            if(!yerlesenisimler.contains(item)){
                yerlesemeyenler.add(item);
            }
        }

        for (String name:yerlesemeyenler){
            System.out.println(name+": Yerlesemedi!!!");
        }

    }

    private static ArrayList<Sonuc> yerlestimeYap(ArrayList<Tercih> list) {
        int kontenjanIzm = 3;
        int kontenjanIst = 5;
        int kontenjanAnk = 4;

        ArrayList<Sonuc> sonucListesi = new ArrayList<>();


        while (list.size()>0) {
            double max = 0;
            Tercih ogrenci = new Tercih();

            for (Tercih item : list) {
                if (item.getPuan() > max) {
                    max = item.getPuan();
                    ogrenci = item;
                }
            }

            for (String item: ogrenci.getTercih()){
                if(item.equals("IZM") && kontenjanIzm > 0){
                    Sonuc sonuc = new Sonuc(ogrenci.getOgrenciAdi(), "IZM",ogrenci.getPuan());
                    sonucListesi.add(sonuc);
                    kontenjanIzm--;
                    break;
                } else if(item.equals("ANK") && kontenjanAnk > 0){
                    Sonuc sonuc = new Sonuc(ogrenci.getOgrenciAdi(), "ANK",ogrenci.getPuan());
                    sonucListesi.add(sonuc);
                    kontenjanAnk--;
                    break;
                }else if(item.equals("IST") && kontenjanIst > 0){
                    Sonuc sonuc = new Sonuc(ogrenci.getOgrenciAdi(), "IST",ogrenci.getPuan());
                    sonucListesi.add(sonuc);
                    kontenjanIst--;
                    break;
                }
            }
            list.remove(ogrenci);

        }
        return sonucListesi;
    }


    private static void puanHesapla(ArrayList<Tercih> list, File dosya) {
        try {
            Scanner scanner = new Scanner(dosya);

            String sayisalAnahtar = scanner.nextLine();
            String sozelAnahtar = scanner.nextLine();

            while (scanner.hasNextLine()) {
                String ogrenciSatir = scanner.nextLine();
                String[] bilgi = ogrenciSatir.split(",");
                double ogrenciPuan = 0;
                ogrenciPuan = getOgrenciPuan(sayisalAnahtar, sozelAnahtar, bilgi, ogrenciPuan);
                getOgrenciTercih(list, bilgi, ogrenciPuan);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getOgrenciTercih(ArrayList<Tercih> list, String[] bilgi, double ogrenciPuan) {
        ArrayList<String> ogrenciTercih = new ArrayList<>();
        if (bilgi[0].equals("METIN")) {
            ogrenciTercih.add("IZM");
            ogrenciTercih.add("IST");
            ogrenciTercih.add("ANK");
        } else if (bilgi[0].equals("ALI")) {
            ogrenciTercih.add("IZM");
        } else if (bilgi[0].equals("FEYYAZ")) {
            ogrenciTercih.add("ANK");
            ogrenciTercih.add("IZM");
        }
        Tercih ogrenci = new Tercih(bilgi[0], bilgi[1], bilgi[2],
                ogrenciPuan, ogrenciTercih);
        list.add(ogrenci);
    }

    private static double getOgrenciPuan(String sayisalAnahtar, String sozelAnahtar, String[] bilgi,
                                         double ogrenciPuan) {
        //matematik puan hesaplama
        for (int i = 0; i < 20; i++) {
            if (sayisalAnahtar.charAt(i) == bilgi[1].charAt(i)) {
                ogrenciPuan += 4;
            } else if (bilgi[1].charAt(i) != ' ') {
                ogrenciPuan -= 1;
            }
        }

        //fen puan hesaplama
        for (int i = 20; i < 30; i++) {
            if (sayisalAnahtar.charAt(i) == bilgi[1].charAt(i)) {
                ogrenciPuan += 3;
            } else if (bilgi[1].charAt(i) != ' ') {
                ogrenciPuan -= 0.75;
            }
        }

        //turkce puan hesaplama
        for (int i = 0; i < 20; i++) {
            if (sozelAnahtar.charAt(i) == bilgi[2].charAt(i)) {
                ogrenciPuan += 2;
            } else if (bilgi[1].charAt(i) != ' ') {
                ogrenciPuan -= 0.50;
            }
        }

        //sosyal puan hesaplama
        for (int i = 20; i < 30; i++) {
            if (sozelAnahtar.charAt(i) == bilgi[2].charAt(i)) {
                ogrenciPuan += 1;
            } else if (bilgi[1].charAt(i) != ' ') {
                ogrenciPuan -= 0.25;
            }
        }
        return ogrenciPuan;
    }

}

