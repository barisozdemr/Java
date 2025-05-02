
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Arac> aracList = new ArrayList<>();
        
        Arac oto1 = new Otomobil("Audi", "A3", 800000, 2021, 1500);
        Arac oto2 = new Otomobil("BMW", "320i", 1000000, 2022, 1600);
        Arac oto3 = new Otomobil("Mercedes", "E200", 1200000, 2022, 1600);
        
        Arac kam1 = new Kamyon("CAT", "797F", 2000000, 2005, 12000);
        Arac kam2 = new Kamyon("Scania", "500S", 1600000, 2018, 8000);
        Arac kam3 = new Kamyon("Volvo", "FH500", 1800000, 2022, 9000);
        
        aracList.add(oto1);
        aracList.add(oto2);
        aracList.add(oto3);
        
        aracList.add(kam1);
        aracList.add(kam2);
        aracList.add(kam3);
        
        ArrayList<Bayi> bayiList = new ArrayList<>();
        
        Bayi bayi1 = new Bayi("Cengiz Otomotiv", 1994, 356);
        Bayi bayi2 = new Bayi("Camoluk Otomotiv", 1943, 53798);
        Bayi bayi3 = new Bayi("Ari Otomotiv", 2001, 534);
        
        bayiList.add(bayi1);
        bayiList.add(bayi2);
        bayiList.add(bayi3);
        
        ArrayList<Kullanici> kulList = new ArrayList<>();
        
        Kullanici kul1 = new Kullanici("Baris", "Ozdemir");
        Kullanici kul2 = new Kullanici("Mustafa", "Ic");
        Kullanici kul3 = new Kullanici("Arda", "Sarioglu");
        
        kulList.add(kul1);
        kulList.add(kul2);
        kulList.add(kul3);
        
        Arayuz arayuz = new Arayuz(scan, aracList, bayiList, kulList);
        
        while(true)
        {
            int islem = 0;
            
            islem = arayuz.baslangicArayuz();
            
            int index;
            
            if(islem == 1)  // Bayi islemleri
            {
                while(true)
                {
                    islem = arayuz.bayiIslemleriArayuz();
                    
                    index = islem-1;

                    if(0 < islem && islem < bayiList.size()+1)  // Bayi secildi, Secilen bayi islemleri
                    {
                        while(true)
                        {
                            islem = arayuz.secilenBayiIslemiArayuz(index);

                            if(islem == 1)  // Arac ekle
                            {
                                while(true)
                                {
                                    // Eklenecek araba olup olmadiginin tespiti yapilir
                                    
                                    int g = 0;  // Tedarikte araba olmadigi varsayilir
                                    for(int i=0 ; i < aracList.size() ; i++)  // Tedarikte araba tespiti
                                    {
                                        int v=0;
                                        
                                        if(aracList.get(i).kullanici != null)  // Arabanin sahibi var mi?
                                        {
                                            continue;
                                        }
                                        
                                        for(int j=0 ; j < bayiList.size() ; j++)  // Araba bayide satilik mi?
                                        {
                                            for(int k=0 ; k < bayiList.get(j).araclar.size() ; k++)
                                            {
                                                if(aracList.get(i) == bayiList.get(j).araclar.get(k))
                                                {
                                                    v=1;
                                                    break;
                                                }
                                            }
                                            if(v==1)
                                            {
                                                break;
                                            }
                                        }
                                        if(v==1)
                                        {
                                            continue;
                                        }
                                        
                                        g=1; // Tedarikte araba var
                                        break;
                                    }

                                    if(g==0)  // Tedarikte araba yok ise
                                    {
                                        System.out.println("Eklenecek araba yok!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        break;
                                    }
                                    
                                    ArrayList<Arac> tedarik = new ArrayList<>();
                                    
                                    islem = arayuz.bayiAracEkleArayuz(tedarik);

                                    if(0 < islem && islem < tedarik.size()+1)  // Arac secildi (Ekleme)
                                    {
                                        bayiList.get(index).aracEkle(tedarik.get(islem-1));
                                        
                                        System.out.println("Arac bayiye satilik olarak eklendi!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                    }
                                    else if(islem == tedarik.size()+1)  // Geri
                                    {
                                        break;
                                    }
                                    else // Hatali giris
                                    {
                                        System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                            }
                            else if(islem == 2)  // Arac Sat
                            {
                                ArrayList<Arac> araclar = bayiList.get(index).araclar;
                                
                                while(true)
                                {
                                    if(araclar.isEmpty())  // Satilik arac yok ise
                                    {
                                        System.out.println("Satilik araba yok!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        break;
                                    }
                                    else  // Satilik arac var ise
                                    {
                                        islem = arayuz.bayiAracSatArayuz(araclar);
                                        
                                        int satis = islem;

                                        if(0 < islem && islem < araclar.size()+1)  // Arac secildi (Satis)
                                        {
                                            islem = arayuz.aracSatilacakKullaniciArayuz();
                                            
                                            bayiList.get(index).aracSat(satis-1, kulList.get(islem-1));  // Arac satis islemi
                                            
                                            System.out.println("Arac "+kulList.get(islem-1).ad+" adli kullaniciya satildi!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        else if(islem == araclar.size()+1) // Geri
                                        {
                                            break;
                                        }
                                        else  // Hatali giris
                                        {
                                            System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                            else if(islem == 3)  // Geri
                            {
                                break;
                            }
                            else  // Hatali giris
                            {
                                System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                    else if(islem == bayiList.size()+1)  // Geri
                    {
                        break;
                    }
                    else  // Hatali giris
                    {
                        System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            else if(islem == 2)  // Kullanici islemleri
            {
                while(true)
                {
                    islem = arayuz.kullaniciIslemleriArayuz();
                    
                    index = islem-1;
                    
                    if(0 < islem && islem < kulList.size()+1)  // Kullanici secildi
                    {
                        while(true)
                        {
                            islem = arayuz.secilenKullaniciIslemiArayuz(index);

                            if(islem == 1)  // Kullanici Araclari Goruntule
                            {
                                kulList.get(index).araclariGoruntule();

                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else if(islem == 2)  // Geri
                            {
                                break;
                            }
                            else  // Hatali giris
                            {
                                System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                    else if(islem == kulList.size()+1)  // Geri
                    {
                        break;
                    }
                    else  // Hatali giris
                    {
                        System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            else if(islem == 3)  // Araclari Goruntule
            {
                arayuz.araclariGoruntuleArayuz();
                
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(islem == 4)  // Arac Ekle
            {
                int g = 0;

                int tur = 0;
                String marka = null;
                String model = null;
                int maliyet = 0;
                int yil = 0;
                int silindirHacmi = 0;
                int toplamAgirlik = 0;
                
                try{
                    Wrapper wrapper = arayuz.aracEkleArayuz();
                    
                    tur = wrapper.getIntList().get(0);
                    if(tur == 1)
                    {
                        silindirHacmi = wrapper.getIntList().get(1);
                    }
                    else if(tur == 2)
                    {
                        toplamAgirlik = wrapper.getIntList().get(1);
                    }
                    maliyet = wrapper.getIntList().get(2);
                    yil = wrapper.getIntList().get(3);
                    
                    marka = wrapper.getStrList().get(0);
                    model = wrapper.getStrList().get(1);
                }
                catch(Exception e)
                {
                    scan.nextLine();  // dummy
                    g=1;
                }
                
                

                if(g==0)  // arac ekleme
                {
                    arayuz.aracEklemeIslemiArayuz(tur, marka, model, maliyet, yil, silindirHacmi, toplamAgirlik);
                    
                    System.out.println("Arac ekleniyor...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if(tur == 1)
                    {
                        aracList.add(new Otomobil(marka, model, maliyet, yil, silindirHacmi));  // Arac ekleme islemi
                    }
                    else if(tur == 2)
                    {
                        aracList.add(new Kamyon(marka, model, maliyet, yil, toplamAgirlik));  // Arac ekleme islemi
                    }

                    System.out.println("\nArac basarili bir sekilde eklendi!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(g==1)  // hata
                {
                    System.out.println("Hatali giris yaptiniz, arac ekleme islemi basarisiz oldu!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else if(islem == 5)  // Kullanici Ekle
            {
                String ad = null;
                String soyad = null;
                
                ArrayList<String> strList = arayuz.kullaniciEkleArayuz();
                
                ad = strList.get(0);
                soyad = strList.get(1);
                
                System.out.println("Kullanici ekleniyor...");
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                kulList.add(new Kullanici(ad, soyad));  // kullanici ekleme islemi
                
                System.out.println("\nKullanici basarili bir sekilde eklendi!");
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(islem == 6)  // Bayi ekle
            {
                int g = 0;
                
                String ad = null;
                int kurulusYili = 0;
                int uretilenAracSayisi = 0;
                
                try
                {
                    Wrapper wrapper = arayuz.bayiEkleArayuz();
                    
                    ad = wrapper.getStrList().get(0);
                    
                    kurulusYili = wrapper.getIntList().get(0);
                    uretilenAracSayisi = wrapper.getIntList().get(1);
                }
                catch(Exception e)
                {
                    scan.nextLine();  // dummy
                    g=1;
                }
                
                if(g==0)  // bayi ekleme islemi
                {
                    arayuz.bayiEklemeIslemiArayuz(ad, kurulusYili, uretilenAracSayisi);

                    System.out.println("Bayi ekleniyor...");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    bayiList.add(new Bayi(ad, kurulusYili, uretilenAracSayisi));  // Bayi ekleme islemi
                    
                    System.out.println("\nBayi basarili bir sekilde eklendi!");
                    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(g==1)  // hata
                {
                    System.out.println("Hatali giris yaptiniz, bayi ekleme islemi basarisiz oldu!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            else if(islem == 7)  // Geri
            {
                System.out.println("Programdan cikiliyor!");
                break;
            }
            else  // Hatali giris
            {
                System.out.println("Gecersiz islem girdiniz!\nTekrar deneyiniz.\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
