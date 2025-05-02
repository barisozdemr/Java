
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Arayuz {
    Scanner scan;
    
    private ArrayList<Arac> aracList;
    private ArrayList<Bayi> bayiList;
    private ArrayList<Kullanici> kulList;
    
    public Arayuz(Scanner scan, ArrayList<Arac> aracList, ArrayList<Bayi> bayiList, ArrayList<Kullanici> kulList)
    {
        this.scan = scan;
        this.aracList = aracList;
        this.bayiList = bayiList;
        this.kulList = kulList;
    }
    
    public int baslangicArayuz()
    {
        System.out.println("\n===================================");
        System.out.println("|          Islem Seciniz:         |");
        System.out.println("===================================");
        System.out.println("| -Bayi sayisi: "+bayiList.size()+"                 |");
        System.out.println("| -Kullanici sayisi: "+kulList.size()+"            |");
        System.out.println("| -Arac sayisi: "+aracList.size()+"                 |");
        System.out.println("===================================");
        System.out.println("| 1.Bayi Islemleri                |");
        System.out.println("| 2.Kullanici Islemleri           |");
        System.out.println("| 3.Araclari Goruntule            |");
        System.out.println("| 4.Arac ekle                     |");
        System.out.println("| 5.Kullanici ekle                |");
        System.out.println("| 6.Bayi ekle                     |");
        System.out.println("| 7.Cikis                         |");
        System.out.println("===================================");
        System.out.print("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int bayiIslemleriArayuz()
    {
        System.out.println("\n===================================");
        System.out.println("|          Bayi Seciniz:          |");
        System.out.println("===================================");
        for(int i=0 ; i<bayiList.size() ; i++)
        {
            Bayi bayi = bayiList.get(i);
            
            System.out.println("| "+(i+1)+"-) Bayinin,                    |");
            System.out.print("| Adi: "+bayi.ad);
            for(int j=0 ; j < 27-bayi.ad.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| Kurulus Yili: "+bayi.kurulusYili);
            for(int j=0 ; j < 18-String.valueOf(bayi.kurulusYili).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| Urettigi Arac Sayisi: "+bayi.uretilenAracSayisi);
            for(int j=0 ; j < 10-String.valueOf(bayi.uretilenAracSayisi).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| Satilik Arac Sayisi: "+bayi.araclar.size());
            for(int j=0 ; j < 11-String.valueOf(bayi.araclar.size()).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.println("|\n===================================");
        }
        System.out.println("| "+(bayiList.size()+1)+".Geri                          |");
        System.out.println("===================================");
        System.out.print("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int secilenBayiIslemiArayuz(int index)
    {
        Bayi bayi = bayiList.get(index);
        
        System.out.println("\n===================================");
        System.out.println("|       Bayi Islemi Seciniz:      |");
        System.out.println("===================================");
        System.out.println("|   Secilen Bayinin,              |");
        System.out.print("| -Adi: "+bayi.ad);
        for(int j=0 ; j < 26-bayi.ad.length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| -Kurulus Yili: "+bayi.kurulusYili);
        for(int j=0 ; j < 17-String.valueOf(bayi.kurulusYili).length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| -Urettigi Arac Sayisi: "+bayi.uretilenAracSayisi);
        for(int j=0 ; j < 9-String.valueOf(bayi.uretilenAracSayisi).length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| -Satilik Arac Sayisi: "+bayi.araclar.size());
        for(int j=0 ; j < 10-String.valueOf(bayi.araclar.size()).length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.println("|\n===================================");
        System.out.println("| 1.Arac Ekle                     |");
        System.out.println("| 2.Arac Sat                      |");
        System.out.println("| 3.Geri                          |");
        System.out.println("===================================");

        System.out.print("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int bayiAracEkleArayuz(ArrayList<Arac> tedarik)
    {
        int no = 0;
        
        System.out.println("===================================");
        System.out.println("|     Eklenecek Arac Seciniz:     |");
        System.out.println("===================================");
        for(int i=0 ; i < aracList.size() ; i++)
        {
            Arac arac = aracList.get(i);
            
            // Arac durum tespiti
            int g=1;  // Tedarikte
            if(arac.kullanici != null)  // Arabanin sahibi var
            {
                g=0;
            }
            if(g==1)
            {
                for(int j=0 ; j < bayiList.size() ; j++)  // Araba bayide satilik
                {
                    for(int k=0 ; k < bayiList.get(j).araclar.size() ; k++)
                    {
                        if(arac == bayiList.get(j).araclar.get(k))
                        {
                            g=2;
                        }
                    }
                }
            }

            if(g==1)  // Araba tedarikte ise eklenebiilir
            {
                tedarik.add(arac);

                no++;

                if(aracList.get(i) instanceof Otomobil)
                {
                    System.out.println("| "+(no)+"-) Tur: Otomobil              |");
                    System.out.print("| -Silindir Hacmi: "+((Otomobil)arac).silindirHacmi);
                    for(int j=0 ; j < 14-String.valueOf(((Otomobil)arac).silindirHacmi).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                else
                {
                    System.out.println("| "+(no)+"-) Tur: Kamyon                |");
                    System.out.print("| -Toplam Agirlik: "+((Kamyon)arac).toplamAgirlik);
                    for(int j=0 ; j < 14-String.valueOf(((Kamyon)arac).toplamAgirlik).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }

                System.out.print("|\n| -Marka: "+arac.marka);
                for(int j=0 ; j < 23-arac.marka.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| -Model: "+arac.model);
                for(int j=0 ; j < 23-arac.model.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| -Uretim Yili: "+arac.uretimYili);
                for(int j=0 ; j < 17-String.valueOf(arac.uretimYili).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| -Maliyet: "+arac.maliyet);
                for(int j=0 ; j < 21-String.valueOf(arac.maliyet).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==================================");
            }
        }
        System.out.println("| "+(tedarik.size()+1)+".Geri                         |");
        System.out.println("==================================");
        System.out.print("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int bayiAracSatArayuz(ArrayList<Arac> araclar)
    {
        System.out.println("\n==================================");
        System.out.println("|        Satilik Araclar:        |");
        System.out.println("==================================");
        for(int i=0 ; i<araclar.size() ; i++)
        {
            Arac arac = araclar.get(i);

            if(arac instanceof Otomobil)
            {
                System.out.println("| "+(i+1)+"-) Tur: Otomobil              |");
                System.out.print("| -Silindir Hacmi: "+((Otomobil)arac).silindirHacmi);
                for(int j=0 ; j < 14-String.valueOf(((Otomobil)arac).silindirHacmi).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
            }
            else
            {
                System.out.println("| "+(i+1)+"-) Tur: Kamyon                |");
                System.out.print("| -Toplam Agirlik: "+((Kamyon)arac).toplamAgirlik);
                for(int j=0 ; j < 14-String.valueOf(((Kamyon)arac).toplamAgirlik).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
            }

            System.out.print("|\n| -Marka: "+arac.marka);
            for(int j=0 ; j < 23-arac.marka.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Model: "+arac.model);
            for(int j=0 ; j < 23-arac.model.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Uretim Yili: "+arac.uretimYili);
            for(int j=0 ; j < 17-String.valueOf(arac.uretimYili).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Maliyet: "+arac.maliyet);
            for(int j=0 ; j < 21-String.valueOf(arac.maliyet).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Satis Fiyati: "+arac.satisFiyatiHesapla()+" TL");
            for(int j=0 ; j < 13-String.valueOf(arac.satisFiyatiHesapla()).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.println("|\n==================================");
        }
        System.out.println("| "+(araclar.size()+1)+".Geri                         |");
        System.out.println("==================================");
        System.out.println("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int aracSatilacakKullaniciArayuz()
    {
        System.out.println("==========================================");
        System.out.println("| Aracin Satilacagi Kullaniciyi Seciniz: |");
        System.out.println("==========================================");
        for(int i=0 ; i<kulList.size() ; i++)
        {
            System.out.println("| "+(i+1)+"-) Kullanicinin,                      |");
            System.out.print("| Adi: "+kulList.get(i).ad);
            for(int j=0 ; j < 34-kulList.get(i).ad.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| Soyadi: "+kulList.get(i).soyad);
            for(int j=0 ; j < 31-kulList.get(i).soyad.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.println("|\n| Arac sayisi: "+kulList.get(i).aracSayisi+"                         |");
            System.out.println("==========================================");
        }
        System.out.println("| "+(kulList.size()+1)+".Geri                                 |");
        System.out.println("==========================================");
        System.out.println("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int kullaniciIslemleriArayuz()
    {
        System.out.println("\n===================================");
        System.out.println("|       Kullanici Seciniz:        |");
        System.out.println("===================================");
        for(int i=0 ; i<kulList.size() ; i++)
        {
            System.out.println("| "+(i+1)+"-) Kullanicinin,               |");
            System.out.print("| Adi: "+kulList.get(i).ad);
            for(int j=0 ; j < 27-kulList.get(i).ad.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| Soyadi: "+kulList.get(i).soyad);
            for(int j=0 ; j < 24-kulList.get(i).soyad.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| Sahip oldugu arac sayisi: "+kulList.get(i).aracSayisi);
            for(int j=0 ; j < 6-String.valueOf(kulList.get(i).aracSayisi).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.println("|\n===================================");
        }
        System.out.println("| "+(kulList.size()+1)+".Geri                          |");
        System.out.println("===================================");
        System.out.print("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public int secilenKullaniciIslemiArayuz(int index)
    {
        System.out.println("\n===================================");
        System.out.println("|    Kullanici islemi Seciniz:    |");
        System.out.println("===================================");
        System.out.println("|   Secilen Kullanicinin,         |");
        System.out.print("| Adi: "+kulList.get(index).ad);
        for(int j=0 ; j < 27-kulList.get(index).ad.length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Soyadi: "+kulList.get(index).soyad);
        for(int j=0 ; j < 24-kulList.get(index).soyad.length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Sahip oldugu arac sayisi: "+kulList.get(index).aracSayisi);
        for(int j=0 ; j < 6-String.valueOf(kulList.get(index).aracSayisi).length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.println("|\n===================================");
        System.out.println("| 1.Araclari Goruntule            |");
        System.out.println("| 2.Geri                          |");
        System.out.println("===================================");
        System.out.print("Islem seciniz: ");
        int islem = scan.nextInt();
        System.out.println();
        
        return islem;
    }
    
    public void araclariGoruntuleArayuz()
    {
        System.out.println("==================================");
        System.out.println("|         Arac Listesi:          |");
        System.out.println("==================================");
        for(int i=0 ; i<aracList.size() ; i++)
        {
            Arac arac = aracList.get(i);
            
            int bayiIndex = 0;
            
            // Arac durum tespiti
            int g=1;  // Tedarikte
            if(arac.kullanici != null)  // Arabanin sahibi var
            {
                g=0;
            }
            if(g==1)
            {
                for(int j=0 ; j < bayiList.size() ; j++)  // Bayide satilik
                {
                    for(int k=0 ; k < bayiList.get(j).araclar.size() ; k++)
                    {
                        if(arac == bayiList.get(j).araclar.get(k))
                        {
                            g=2;
                            bayiIndex = j;
                        }
                    }
                }
            }

            if(aracList.get(i) instanceof Otomobil)
            {
                System.out.println("| "+(i+1)+"-) Tur: Otomobil              |");
                System.out.print("| -Silindir Hacmi: "+((Otomobil)arac).silindirHacmi);
                for(int j=0 ; j < 14-String.valueOf(((Otomobil)arac).silindirHacmi).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
            }
            else
            {
                System.out.println("| "+(i+1)+"-) Tur: Kamyon                |");
                System.out.print("| -Toplam Agirlik: "+((Kamyon)arac).toplamAgirlik);
                for(int j=0 ; j < 14-String.valueOf(((Kamyon)arac).toplamAgirlik).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
            }

            System.out.print("|\n| -Marka: "+arac.marka);
            for(int j=0 ; j < 23-arac.marka.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Model: "+arac.model);
            for(int j=0 ; j < 23-arac.model.length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Uretim Yili: "+arac.uretimYili);
            for(int j=0 ; j < 17-String.valueOf(arac.uretimYili).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Maliyet: "+arac.maliyet);
            for(int j=0 ; j < 21-String.valueOf(arac.maliyet).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
            System.out.print("|\n| -Arac durumu: ");
            if(g==0)
            {
                System.out.println("Satilmis         |");
                System.out.print("| Sahibi: "+arac.kullanici.ad);
                for(int j=0 ; j < 23-arac.kullanici.ad.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|");
            }
            else if(g==1)
            {
                System.out.println("Tedarikte        |");
            }
            else if(g==2)
            {
                System.out.println("Bayide Satilik   |");
                System.out.print("| Bayi: "+bayiList.get(bayiIndex).ad);
                for(int j=0 ; j < 25-bayiList.get(bayiIndex).ad.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|");
            }
            System.out.println("==================================");
        }
    }
    
    public Wrapper aracEkleArayuz() throws Exception
    {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        
        int tur = 0;
        String marka = null;
        String model = null;
        int maliyet = 0;
        int yil = 0;
        int silindirHacmi = 0;
        int toplamAgirlik = 0;
        
        for(int i=0 ; i < 6 ; i++)
        {
            System.out.println("==============================");
            System.out.println("|        Arac Ekleme:        |");
            System.out.println("==============================");
            if(i==0)  // tur
            {
                System.out.println("| -Tur seciniz:              |");
                System.out.println("==============================");
                System.out.println("| 1.Otomobil                 |");
                System.out.println("| 2.Kamyon                   |");
                System.out.println("==============================");
                System.out.print("Islem seciniz: ");
                tur = scan.nextInt();
                System.out.println();
                
                intList.add(tur);
            }
            else if(i==1)  // ozgu ozellik
            {
                if(tur == 1)
                {
                    System.out.println("| Tur: Otomobil              |");
                    System.out.println("==============================");
                    System.out.print("Silindir Hacmi giriniz: ");
                    silindirHacmi = scan.nextInt();
                    System.out.println();

                    intList.add(silindirHacmi);
                }
                else if(tur == 2)
                {
                    System.out.println("| Tur: Kamyon                |");
                    System.out.println("==============================");
                    System.out.print("Toplam Agirlik giriniz: ");
                    toplamAgirlik = scan.nextInt();
                    System.out.println();

                    intList.add(toplamAgirlik);
                }
                else
                {
                    throw new Exception();
                }
            }
            else if(i==2)  // marka
            {
                if(tur == 1)
                {
                    System.out.println("| Tur: Otomobil              |");
                    System.out.print("| Silindir Hacmi: "+silindirHacmi);
                    for(int j=0 ; j < 11-String.valueOf(silindirHacmi).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                else if(tur == 2)
                {
                    System.out.println("| Tur: Kamyon                |");
                    System.out.print("| Toplam Agirlik: "+toplamAgirlik);
                    for(int j=0 ; j < 11-String.valueOf(toplamAgirlik).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                System.out.println("|\n==============================");
                System.out.print("Marka giriniz: ");
                scan.nextLine();  //dummy
                marka = scan.nextLine();
                System.out.println();

                strList.add(marka);
            }
            else if(i==3)  // model
            {
                if(tur == 1)
                {
                    System.out.println("| Tur: Otomobil              |");
                    System.out.print("| Silindir Hacmi: "+silindirHacmi);
                    for(int j=0 ; j < 11-String.valueOf(silindirHacmi).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                else if(tur == 2)
                {
                    System.out.println("| Tur: Kamyon                |");
                    System.out.print("| Toplam Agirlik: "+toplamAgirlik);
                    for(int j=0 ; j < 11-String.valueOf(toplamAgirlik).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print("|\n| Marka: "+marka);
                for(int j=0 ; j < 20-marka.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==============================");
                System.out.print("Model giriniz: ");
                model = scan.nextLine();
                System.out.println();

                strList.add(model);
            }
            else if(i==4)  // maliyet
            {
                if(tur == 1)
                {
                    System.out.println("| Tur: Otomobil              |");
                    System.out.print("| Silindir Hacmi: "+silindirHacmi);
                    for(int j=0 ; j < 11-String.valueOf(silindirHacmi).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                else if(tur == 2)
                {
                    System.out.println("| Tur: Kamyon                |");
                    System.out.print("| Toplam Agirlik: "+toplamAgirlik);
                    for(int j=0 ; j < 11-String.valueOf(toplamAgirlik).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print("|\n| Marka: "+marka);
                for(int j=0 ; j < 20-marka.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| Model: "+model);
                for(int j=0 ; j < 20-model.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==============================");
                System.out.print("Maliyet giriniz: ");
                maliyet = scan.nextInt();
                System.out.println();

                intList.add(maliyet);
            }
            else if(i==5)  // yil
            {
                if(tur == 1)
                {
                    System.out.println("| Tur: Otomobil              |");
                    System.out.print("| Silindir Hacmi: "+silindirHacmi);
                    for(int j=0 ; j < 11-String.valueOf(silindirHacmi).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                else if(tur == 2)
                {
                    System.out.println("| Tur: Kamyon                |");
                    System.out.print("| Toplam Agirlik: "+toplamAgirlik);
                    for(int j=0 ; j < 11-String.valueOf(toplamAgirlik).length() ; j++)  // Bosluk
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print("|\n| Marka: "+marka);
                for(int j=0 ; j < 20-marka.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| Model: "+model);
                for(int j=0 ; j < 20-model.length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| Maliyet: "+maliyet);
                for(int j=0 ; j < 18-String.valueOf(maliyet).length() ; j++)  // Bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==============================");
                System.out.print("Uretim Yili giriniz: ");
                yil = scan.nextInt();
                System.out.println();

                intList.add(yil);
            }
        }
        
        Wrapper wrapper = new Wrapper(intList, strList);
        
        return wrapper;
    }
    
    public void aracEklemeIslemiArayuz(int tur, String marka, String model, int maliyet, int yil, int silindirHacmi, int toplamAgirlik)
    {
        System.out.println("==============================");
        if(tur == 1)
        {
            System.out.println("| Tur: Otomobil              |");
            System.out.print("| Silindir Hacmi: "+silindirHacmi);
            for(int j=0 ; j < 11-String.valueOf(silindirHacmi).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
        }
        else if(tur == 2)
        {
            System.out.println("| Tur: Kamyon                |");
            System.out.print("| Toplam Agirlik: "+toplamAgirlik);
            for(int j=0 ; j < 11-String.valueOf(toplamAgirlik).length() ; j++)  // Bosluk
            {
                System.out.print(" ");
            }
        }

        System.out.print("|\n| Marka: "+marka);
        for(int j=0 ; j < 20-marka.length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Model: "+model);
        for(int j=0 ; j < 20-model.length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Maliyet: "+maliyet);
        for(int j=0 ; j < 18-String.valueOf(maliyet).length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Yil: "+yil);
        for(int j=0 ; j < 22-String.valueOf(yil).length() ; j++)  // Bosluk
        {
            System.out.print(" ");
        }
        System.out.println("|\n==============================");
    }
    
    public ArrayList<String> kullaniciEkleArayuz()
    {
        ArrayList<String> strList = new ArrayList<>();
        
        String ad = null;
        String soyad = null;
        
        for(int i=0 ; i<2 ; i++)
        {
            System.out.println("==============================");
            System.out.println("|      Kullanici Ekleme:     |");
            System.out.println("==============================");
            if(i==0)  // ad
            {
                System.out.print("Kullanici adi giriniz: ");
                scan.nextLine();  // dummy
                ad = scan.nextLine();
                System.out.println();
                
                strList.add(ad);
            }
            else if(i==1)  //soyad
            {
                System.out.print("| Ad: "+ad);
                for(int j=0 ; j < 23-ad.length() ; j++)  // bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==============================");
                System.out.print("Kullanici soyadi giriniz: ");
                soyad = scan.nextLine();
                System.out.println();
                
                strList.add(soyad);
            }
        }

        System.out.println("==============================");
        System.out.print("| Ad: "+ad);
        for(int j=0 ; j < 23-ad.length() ; j++)
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Soyad: "+soyad);
        for(int j=0 ; j < 20-soyad.length() ; j++)
        {
            System.out.print(" ");
        }
        System.out.println("|\n==============================");
        
        return strList;
    }
    
    public Wrapper bayiEkleArayuz()
    {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        
        String ad = null;
        int kurulusYili = 0;
        int uretilenAracSayisi = 0;
        
        for(int i=0 ; i<3 ; i++)
        {
            System.out.println("==================================");
            System.out.println("|          Bayi Ekleme:          |");
            System.out.println("==================================");
            if(i==0)  // ad
            {
                System.out.print("Bayi adi giriniz: ");
                scan.nextLine();  // dummy
                ad = scan.nextLine();
                System.out.println();
                
                strList.add(ad);
            }
            else if(i==1)  // kurulus yili
            {
                System.out.print("| Ad: "+ad);
                for(int j=0 ; j < 27-ad.length() ; j++)  // bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==================================");
                System.out.print("Bayi kurulus yili giriniz: ");
                kurulusYili = scan.nextInt();
                System.out.println();
                
                intList.add(kurulusYili);
            }
            else if(i==2)  // uretilen arac sayisi
            {
                System.out.print("| Ad: "+ad);
                for(int j=0 ; j < 27-ad.length() ; j++)  // bosluk
                {
                    System.out.print(" ");
                }
                System.out.print("|\n| Kurulus Yili: "+kurulusYili);
                for(int j=0 ; j < 17-String.valueOf(kurulusYili).length() ; j++)  // bosluk
                {
                    System.out.print(" ");
                }
                System.out.println("|\n==================================");
                System.out.print("Uretilen arac sayisi giriniz: ");
                uretilenAracSayisi = scan.nextInt();
                System.out.println();
                
                intList.add(uretilenAracSayisi);
            }
        }
        
        Wrapper wrapper = new Wrapper(intList, strList);
        
        return wrapper;
    }
    
    public void bayiEklemeIslemiArayuz(String ad, int kurulusYili, int uretilenAracSayisi)
    {
        System.out.println("==================================");
        System.out.print("| Ad: "+ad);
        for(int j=0 ; j < 27-ad.length() ; j++)  // bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Kurulus Yili: "+kurulusYili);
        for(int j=0 ; j < 17-String.valueOf(kurulusYili).length() ; j++)  // bosluk
        {
            System.out.print(" ");
        }
        System.out.print("|\n| Uretilen Arac Sayisi: "+uretilenAracSayisi);
        for(int j=0 ; j < 9-String.valueOf(uretilenAracSayisi).length() ; j++)  // bosluk
        {
            System.out.print(" ");
        }
        System.out.println("|\n==================================");
    }
}
