package Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KitapYonetim {
    private static final List<Kitap> kitapListesi = new ArrayList<>();
    
    public static void dosyayaKaydet()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/kitaplar.txt"))) {
            for (Kitap kitap : kitapListesi)
            {
                String durum;
                if(kitap.isOduncAlindi())
                {
                    durum = "mevcutDegil";
                }
                else{
                    durum = "mevcut";
                    System.out.println("mevcut");
                }
                
                String line = kitap.getAdi()+";"+kitap.getYazar()+";"+durum+";"+kitap.getSahipID();
                
                writer.write(line);
                writer.newLine(); // Yeni satıra geç
            }
            System.out.println("Kitaplar başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }
    
    public static void dosyadanOku()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/kitaplar.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";"); // Satırı ; ile ayır
                
                if (parts.length == 4)
                {
                    String ad = parts[0];
                    String soyad = parts[1];
                    String sahipID = parts[3];
                    boolean durum;
                    if(parts[2].equals("mevcut"))
                    {
                        durum = false;
                    }
                    else{
                        durum = true;
                    }
                    kitapEkle(ad, soyad, durum, Integer.parseInt(sahipID));
                }
            }
            System.out.println("Kitaplar başarıyla dosyadan okundu.");
        } catch (IOException e) {
            System.err.println("Dosyadan okuma hatası: " + e.getMessage());
        }
    }

    public static void kitapEkle(String adi, String yazar) {
        Kitap yeniKitap = new Kitap(adi, yazar);
        kitapListesi.add(yeniKitap);
        dosyayaKaydet();
        System.out.println("Kitap başarıyla eklendi.");
        System.out.println("Yeni kitap ID'si: " + yeniKitap.getId());
    }
    
    public static void kitapEkle(String adi, String yazar, boolean durum, int sahipID) {
        Kitap yeniKitap = new Kitap(adi, yazar, durum, sahipID);
        kitapListesi.add(yeniKitap);
        dosyayaKaydet();
        System.out.println("Kitap başarıyla eklendi.");
        System.out.println("Yeni kitap ID'si: " + yeniKitap.getId());
    }

    public static void kitapSil(int id) {
        Kitap silinecekKitap = null;
        for (Kitap kitap : kitapListesi) {
            if (kitap.getId() == id) {
                silinecekKitap = kitap;
                break;
            }
        }
        if (silinecekKitap != null) {
            kitapListesi.remove(silinecekKitap);
            dosyayaKaydet();
            System.out.println("Kitap başarıyla silindi.");
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public static void kitapOduncAl(int uyeId, int kitapId) {
        Uye uye = null;
        for (Uye u : UyeYonetim.getUyeListesi()) {
            if (u.getId() == uyeId) {
                uye = u;
                break;
            }
        }
        if (uye == null) {
            System.out.println("Üye bulunamadı.");
            return;
        }

        Kitap kitap = null;
        for (Kitap k : kitapListesi) {
            if (k.getId() == kitapId) {
                kitap = k;
                break;
            }
        }

        if (kitap == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }

        if (kitap.isOduncAlindi()) {
            System.out.println("Bu kitap zaten ödünç alınmış.");
        } else {
            kitap.setOduncAlindi(true);
            kitap.setSahipID(uyeId);
            dosyayaKaydet();
            System.out.println(uye.getAd() + " " + uye.getSoyad() + " şu kitabı ödünç aldı: " + kitap.getAdi());
        }
    }
    
    public static void kitapIadeEt(int kitapId) {
        Kitap kitap = null;
        for (Kitap k : kitapListesi) {
            if (k.getId() == kitapId) {
                kitap = k;
                break;
            }
        }

        if (kitap == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }

        if (!kitap.isOduncAlindi()) {
            System.out.println("Bu kitap zaten iade edilmiştir veya hiç ödünç alınmamıştır.");
        } else {
            kitap.setOduncAlindi(false);
            kitap.setSahipID(-1);
            dosyayaKaydet();
            System.out.println("şu kitap iade edildi: " + kitap.getAdi());
        }
    }

    public static List<Kitap> getKitapListesi() {
        return kitapListesi;
    }
}
