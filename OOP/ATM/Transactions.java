
import java.util.Scanner;


public class Islemler 
{
    public void atm(Hesap hesap)
    {
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                               
                               ==============================
                               |       Islem Seciniz        |
                               ==============================
                               |   1.Bakiye Sorgula         |
                               |   2.Para Yatir             |
                               |   3.Para Cek               |
                               |   4.Cikis / Kart Iade      |
                               ==============================
                               
                               """);
            String islem = scanner.nextLine();
            switch (islem)
            {
                case "1" -> System.out.println("\nBakiyeniz = "+hesap.getBakiye());
                case "2" -> 
                {
                    System.out.print("\nNe kadar para yatirmak istiyorsunuz? = ");
                    double tutar = scanner.nextDouble();
                    scanner.nextLine(); //dummy
                    hesap.setBakiye(hesap.getBakiye() + tutar);
                    System.out.println("Para yatirma isleminiz gerceklesti.");
                }
                case "3" ->
                {
                    System.out.print("\nNe kadar para cekmek istiyorsunuz? = ");
                    double tutar = scanner.nextDouble();
                    scanner.nextLine(); //dummy
                    if(tutar > hesap.getBakiye())
                    {
                        System.out.println("Yetersiz Bakiye.");
                    }
                    else
                    {
                        hesap.setBakiye(hesap.getBakiye() - tutar);
                        System.out.println("Para cekme isleminiz gerceklesti.");
                    }
                }
                case "4" ->
                {
                    System.out.println("\nProgramdan Cikiliyor.");
                    return;
                }
            }
        }
    }
}
