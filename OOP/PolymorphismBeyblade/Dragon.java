
public class Dragon extends Beyblade
{
    private String kutsalCanavar;
    private  String gizliOzellik;

    public Dragon(String beybladeSahip, int donusHizi, int saldiriGucu, String kutsalCanavar, String gizliOzellik) 
    {
        super(beybladeSahip, donusHizi, saldiriGucu);
        this.kutsalCanavar = kutsalCanavar;
        this.gizliOzellik = gizliOzellik;
    }

    @Override
    public void kutsalCanavarCagir() 
    {
        System.out.println("\nKutsal canavar " + kutsalCanavar + " cagiriliyor");
    }
    
    @Override
    public void gizliOzellik()
    {
        System.out.println("\nGizli ozellik = "+gizliOzellik);
    }
    
    @Override
    public void bilgiInfo()
    {
        super.bilgiInfo();
        System.out.println("\nKutsal canavar adi = "+kutsalCanavar);
    }
}
