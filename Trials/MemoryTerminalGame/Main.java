

public class Main 
{
    public static void main(String[] args) throws InterruptedException
    {
        Tahta tahta = new Tahta();
        
        tahta.bilgiInfo();
        
        while (!tahta.bitisControl())
        {
            
            tahta.oyunTahtasi();
            tahta.tahminEt();
            
        }
    }
}
