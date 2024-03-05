
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {   
        Scanner scanner = new Scanner(System.in);
        
        Mudur mudur1 = new Mudur("baris","ozden",50000,"marmara ceng");
        Isci isci1 = new Isci("ahmet","cemre",20000,378915);
        
        while(true)
        {
            System.out.print("""

                               ================================
                               |        Islem seciniz         |
                               ================================
                               |     1.Isci islemleri         |
                               |     2.Mudur islemleri        |
                               |     3.Cikis                  |
                               ================================
                               islem = """);

            int islem = scanner.nextInt();

            if (islem == 1)
            {
                while (true)
                {
                    System.out.print("""

                                   ================================
                                   |   (Isci) Islem seciniz       |
                                   ================================
                                   |     1.Bilgileri goster       |
                                   |     2.Cikis                  |
                                   ================================
                                   islem = """);
                    int islem2 = scanner.nextInt();
                    if (islem2 == 1)
                    {
                        System.out.println("");
                        isci1.bilgiinfo();
                    }
                    else if (islem2 == 2)
                    {
                        System.out.println("\nIsci islemlerinden cikiliyor.");
                        break;
                    }
                    else
                    {
                        System.out.println("\nHatali islem sectiniz luttfen tekrar seciniz.");
                    }
                }
            }

            else if (islem == 2)
            {
                while (true)
                {
                    System.out.print("""

                                   ================================
                                   |   (Mudur) Islem seciniz      |
                                   ================================
                                   |     1.Bilgileri goster       |
                                   |     2.Cikis                  |
                                   ================================
                                   islem = """);
                    int islem2 = scanner.nextInt();
                    if (islem2 == 1)
                    {
                        System.out.println("");
                        mudur1.bilgiinfo();
                    }
                    else if (islem2 == 2)
                    {
                        System.out.println("\nMudur islemlerinden cikiliyor.");
                        break;
                    }
                    else
                    {
                        System.out.println("\nHatali islem sectiniz luttfen tekrar seciniz.");
                    }

                }
            }

            else if (islem == 3)
            {
                System.out.println("\nrogramdan cikiliyor.");
                break;
            }

            else
            {
                System.out.println("\nHatali islem sectiniz luttfen tekrar seciniz.");
            }
        }
    }
}
