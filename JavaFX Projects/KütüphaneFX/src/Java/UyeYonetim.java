package Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UyeYonetim {
    private static final List<Uye> uyeListesi = new ArrayList<>();
    
    public static void dosyayaKaydet()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/uyeler.txt"))) {
            for (Uye uye : uyeListesi)
            {
                String line = uye.getAd()+";"+uye.getSoyad();
                
                writer.write(line);
                writer.newLine(); // Yeni satıra geç
            }
            System.out.println("Üyeler başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }
    
    public static void dosyadanOku()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/uyeler.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";"); // Satırı ; ile ayır
                
                if (parts.length == 2)
                {
                    String ad = parts[0];
                    String soyad = parts[1];
                    uyeEkle(ad, soyad);
                }
            }
            System.out.println("Üyeler başarıyla dosyadan okundu.");
        } catch (IOException e) {
            System.err.println("Dosyadan okuma hatası: " + e.getMessage());
        }
    }

    public static void uyeEkle(String ad, String soyad) {
        Uye yeniUye = new Uye(ad, soyad);
        uyeListesi.add(yeniUye);
        dosyayaKaydet();
        System.out.println("Üye başarıyla eklendi.");
        System.out.println("Yeni üye ID'si: " + yeniUye.getId());
    }

    public static void uyeSil(int id) {
        Uye silinecekUye = null;
        for (Uye uye : uyeListesi) {
            if (uye.getId() == id) {
                silinecekUye = uye;
                break;
            }
        }
        if (silinecekUye != null) {
            uyeListesi.remove(silinecekUye);
            dosyayaKaydet();
            System.out.println("Üye başarıyla silindi.");
        } else {
            System.out.println("Üye bulunamadı.");
        }
    }
    
    public static List<Uye> getUyeListesi() {
        return uyeListesi;
    }
}

