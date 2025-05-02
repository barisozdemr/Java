
import java.util.ArrayList;


public class Bayi {
    
    public String ad;
    public int kurulusYili;
    public int uretilenAracSayisi;
    public ArrayList<Arac> araclar = new ArrayList<>();
    
    public Bayi(String ad, int kurulusYili, int uretilenAracSayisi)
    {
        this.ad = ad;
        this.kurulusYili = kurulusYili;
        this.uretilenAracSayisi = uretilenAracSayisi;
    }
    
    public void aracEkle(Arac arac)
    {
        araclar.add(arac);
    }
    
    public void aracSat(int index, Kullanici kullanici)
    {
        kullanici.aracSatinAl(araclar.get(index));
        araclar.get(index).kullanici = kullanici;
        araclar.remove(index);
    }
}
