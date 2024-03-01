import java.util.Scanner;
        
public class denemeClass 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String sifre = "1234";
        int bakiye = 100;
        System.out.print("Sifrenizi giriniz (ilk sifreniz = 1234) = ");
        int c = 1;
        for(int i = 1; i<4; i++)
        {
            if (c == 0)
            {
                break;
            }
            String sgirdi = scanner.nextLine();
            if(sgirdi.equals(sifre))
            {
                while (true)
                {
                    if (c == 0)
                    {
                        break;
                    }
                    System.out.println("""
                    \n===========================
                    |      Islem Seciniz      |
                    ===========================
                    | (1) Bakiye sorgula      |
                    | (2) Para Yatir          |
                    | (3) Para Cek            |
                    | (4) Cikis / Kart Iade   |
                    | (5) Sifre Degistir      |
                    ===========================
                               """);
                    int islem = scanner.nextInt();
                    switch (islem)
                    {
                        case 1 -> System.out.println("Bakiyeniz = "+bakiye+" TL");
                        case 2 -> 
                            {
                                System.out.println("Ne kadar para yatirmak istiyorsunuz? = ");
                                int yatirma = scanner.nextInt();
                                bakiye += yatirma;
                                System.out.println("Para yatirma isleminiz gerceklesti.");
                            }
                        case 3 ->
                            {
                                System.out.println("Ne kadar para cekmek istiyorsunuz? = ");
                                int cekme = scanner.nextInt();
                                if (cekme>bakiye)
                                    {
                                        System.out.println("Yetersiz bakiye.");
                                    }
                                else
                                    {
                                        System.out.println("Para cekme isleminiz gerceklesti.");
                                        bakiye -= cekme;
                                    }
                            }
                        case 4 -> 
                            {
                                System.out.println("Cikis yapildi. Kartinizi almayi unutmayin.");
                                c = 0;
                                i = 1;
                            }
                        case 5 -> 
                            {
                                System.out.println("Lutfen eski sifrenizi girin = ");
                                String d = scanner.nextLine(); // dummy
                                String sdegis = scanner.nextLine();
                                
                                if (sdegis.equals(sifre))
                                    {
                                        System.out.println("Lutfen yeni sifrenizi girin = ");
                                        sifre = scanner.nextLine();
                                        System.out.println("Sifreniz basariyla degisti.");
                                    }
                                else
                                    {
                                        System.out.println("Eski sifrenizi hatali girdiniz, lutfen tekrar deneyin.");
                                    }
                            }
                    }
                }
            }
            else
            {
                System.out.println("Hatali sifre girdiniz, tekrar deneyiniz.");
                System.out.println(3-i+" Deneme hakkiniz kaldi.");
            }
        }
        
        if (c==1)
        {
            System.out.println("3 kere hatali sifre girdiginiz icin kart kilitlendi.");
        }
    }
}
