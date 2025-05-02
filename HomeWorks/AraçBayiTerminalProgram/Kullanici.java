
import java.util.ArrayList;


public class Kullanici {
    
    public String ad;
    public String soyad;
    public int aracSayisi = 0;
    public ArrayList<Arac> satinAlinanlar = new ArrayList<>();
    
    public Kullanici(String ad, String soyad)
    {
        this.ad = ad;
        this.soyad = soyad;
    }
    
    public void aracSatinAl(Arac arac)
    {
        satinAlinanlar.add(arac);
        aracSayisi++;
    }
    
    public void araclariGoruntule()
    {
        if(satinAlinanlar.size() == 0)
        {
            System.out.println(ad+" adli kullanici araba sahibi degil!");
        }
        else
        {
            int size = ad.length();

            for(int i=0 ; i<44+size ; i++)  // satir
            {
                System.out.print("=");
            }
            System.out.println("\n| "+ad+" Adli Kullanicinin Sahip Oldugu Araclar: |");
            for(int i=0 ; i<44+size ; i++)  // satir
            {
                System.out.print("=");
            }
            System.out.println();

            for(int i=0 ; i<satinAlinanlar.size() ; i++)
            {
                Arac arac = satinAlinanlar.get(i);

                if(arac instanceof Otomobil)
                {
                    System.out.print("| "+(i+1)+"-) Tur: Otomobil");
                    for(int j=0 ; j < 24+size ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|\n| -Silindir Hacmi: "+((Otomobil)arac).silindirHacmi);
                    for(int j=0 ; j < (24+size)-String.valueOf(((Otomobil)arac).silindirHacmi).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                else
                {
                    System.out.print("| "+(i+1)+"-) Tur: Kamyon");
                    for(int j=0 ; j < 26+size ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|\n| -Toplam Agirlik: "+((Kamyon)arac).toplamAgirlik);
                    for(int j=0 ; j < (24+size)-String.valueOf(((Kamyon)arac).toplamAgirlik).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }

                System.out.print("|\n| -Marka: "+arac.marka);
                for(int j=0 ; j < (33+size)-arac.marka.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| -Model: "+arac.model);
                for(int j=0 ; j < (33+size)-arac.model.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| -Uretim Yili: "+arac.uretimYili);
                for(int j=0 ; j < (27+size)-String.valueOf(arac.uretimYili).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| -Maliyet: "+arac.maliyet);
                for(int j=0 ; j < (31+size)-String.valueOf(arac.maliyet).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|");
                for(int j=0 ; j < 44+size ; j++)  // satir
                {
                    System.out.print("=");
                }
                System.out.println();
            }
        }
    }
}
