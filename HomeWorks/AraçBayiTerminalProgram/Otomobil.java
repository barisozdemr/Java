
public class Otomobil extends Arac{
    
    public int silindirHacmi;
    
    public Otomobil(String marka, String model, int maliyet, int uretimYili, int silindirHacmi)
    {
        super(marka, model, maliyet, uretimYili);
        this.silindirHacmi = silindirHacmi;
    }
    
    @Override
    int satisFiyatiHesapla()
    {
        return (maliyet*2)+(uretimYili*2)+(silindirHacmi*3);
    }
}
