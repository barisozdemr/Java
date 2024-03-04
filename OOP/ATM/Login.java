import java.util.Scanner;

public class Login 
{
    public boolean guvenlik(Hesap hesap)
    {
        Scanner scanner = new Scanner(System.in);
        int girisHakki = 3;
        while(true)
        {
            if(girisHakki == 0)
            {
                System.out.println("3 kere giris yapamadiginiz icin programdan cikiliyor.");
                return false;
            }
            System.out.print("Lutfen Kullanici Adinizi Girin = ");
            String adgiris = scanner.nextLine();
            System.out.print("Lutfen Parolanizi Girin = ");
            String parolagiris = scanner.nextLine();

            if (hesap.getKullaniciAdi().equals(adgiris) && hesap.getParola().equals(parolagiris))
            {
                return true;
            }
            else
            {
                girisHakki -= 1;
                System.out.println("Kullanici adiniz veya parolaniz yanlis, Lutfen tekrar deneyin");
                System.out.println("Kalan giris hakkiniz = " + girisHakki + "\n");
            }
        }
    }
}