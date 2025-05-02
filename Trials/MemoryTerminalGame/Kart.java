
public class Kart 
{
    private char deger;
    private boolean tahmin = false;
    
    public Kart(char deger)
    {
        this.deger = deger;
    }
    
    
    public void setDeger(char deger)
    {
        this.deger = deger;
    }
    
    public char getDeger()
    {
        return deger;
    }
    
    public void setTahmin(boolean deger)
    {
        this.tahmin = deger;
    }
    
    public boolean getTahmin()
    {
        return tahmin;
    }
}
