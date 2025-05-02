
public class Chester extends Beyblade
{
    private String kutsalCanavar;

    public Chester(String beybladeSahip, int donusHizi, int saldiriGucu, String kutsalCanavar)
    {
        super(beybladeSahip, donusHizi, saldiriGucu);
        this.kutsalCanavar = kutsalCanavar;
    }
    
    @Override
    public void kutsalCanavarCagir() 
    {
        System.out.println("\nKutsal Canavar " + kutsalCanavar + " cagiriliyor.");
    }
    
    @Override
    public void bilgiInfo()
    {
        super.bilgiInfo();
        System.out.println("\nKutsal canavar adi = "+kutsalCanavar);
    }
    
}
