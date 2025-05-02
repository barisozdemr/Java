
public class Kamyon extends Arac{
    
    public int toplamAgirlik;
    
    public Kamyon(String marka, String model, int maliyet, int uretimYili, int toplamAgirlik)
    {
        super(marka, model, maliyet, uretimYili);
        this.toplamAgirlik = toplamAgirlik;
    }
    
    @Override
    public int satisFiyatiHesapla() 
    {
        return (maliyet*2)+(uretimYili*2)+(toplamAgirlik*3);
    }
}
