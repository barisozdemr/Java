
public abstract class Arac {
    
    public String marka;
    public String model;
    public int maliyet;
    public int uretimYili;
    public Kullanici kullanici;
    
    public Arac(String marka, String model, int maliyet, int uretimYili)
    {
        this.marka = marka;
        this.model = model;
        this.maliyet = maliyet;
        this.uretimYili = uretimYili;
    }
    
    abstract int satisFiyatiHesapla();
}
