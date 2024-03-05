
public class Mudur extends Calisanlar
{
    
    private String diploma;

    public Mudur(String ad, String soyad, int maas, String diploma) 
    {
        super(ad, soyad, maas);
        this.diploma = diploma;
    }
    
    @Override
    public void bilgiinfo()
    {
        System.out.println("MUDUR");
        super.bilgiinfo();
        System.out.println("Mudur diplomasi = "+diploma);
    }
}