
public class Main 
{
    public static void main(String[] args) 
    {
        Hesap hesap1 = new Hesap("baris","1234",1000);
        
        Islemler islem = new Islemler();
        
        Login logininfo = new Login();
        
        if (logininfo.guvenlik(hesap1))
        {
            islem.atm(hesap1);
        }
    }
}