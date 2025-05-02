
public class Beyblade 
{
    private String beybladeSahip;
    private int donusHizi;
    private int saldiriGucu;

    public Beyblade(String beybladeSahip, int donusHizi, int saldiriGucu)
    {
        this.beybladeSahip = beybladeSahip;
        this.donusHizi = donusHizi;
        this.saldiriGucu = saldiriGucu;
    }

    public String getBeybladeSahip() {
        return beybladeSahip;
    }

    public void setBeybladeSahip(String beybladeSahip) {
        this.beybladeSahip = beybladeSahip;
    }

    public int getDonusHizi() {
        return donusHizi;
    }

    public void setDonusHizi(int donusHizi) {
        this.donusHizi = donusHizi;
    }

    public int getSaldiriGucu() {
        return saldiriGucu;
    }

    public void setSaldiriGucu(int saldiriGucu) {
        this.saldiriGucu = saldiriGucu;
    }
    
    public void saldir()
    {
        System.out.println("\n"+beybladeSahip+" "+donusHizi+" donus hizi ve "+saldiriGucu+" saldiri gucu ile saldiriyor.");
    }
    
    public void kutsalCanavarCagir()
    {
        System.out.println("\nBu beyblade'in kutsal canavari yok.");
    }
    
    public void bilgiInfo()
    {
        System.out.println("\nBeybladeci ismi = "+beybladeSahip);
        System.out.println("Donus hizi = "+donusHizi);
        System.out.println("Saldiri gucu = "+saldiriGucu);
    }
    
    public void gizliOzellik()
    {
        System.out.println("\nBu beyblade'in gizli ozelligi bulunmuyor.");
    }
}
