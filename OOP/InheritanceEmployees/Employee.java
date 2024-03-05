
public class Calisanlar 
{
    private String ad;
    private String soyad;
    private int maas;

    public Calisanlar(String ad, String soyad, int maas) 
    {
        this.ad = ad;
        this.soyad = soyad;
        this.maas = maas;
    }

    
    public void bilgiinfo()
    {
        System.out.println("Calisan ismi = "+ad);
        System.out.println("Calisan soy ismi = "+soyad);
        System.out.println("Calisan maasi = "+maas);
    }
    
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }
}
