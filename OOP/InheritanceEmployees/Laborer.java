
public class Isci extends Calisanlar
{
    
    private int id;

    public Isci(String ad, String soyad, int maas, int id) 
    {
        super(ad, soyad, maas);
        this.id = id;
    }
    
    @Override
    public void bilgiinfo()
    {
        System.out.println("ISCI");
        super.bilgiinfo();
        System.out.println("Isci id = "+id);
    }   
}