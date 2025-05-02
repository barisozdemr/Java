
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Beyblade ismi giriniz = ");
        String isim = scanner.nextLine();
        
        BeybladeConst constructor = new BeybladeConst();
        Beyblade beyblade = constructor.constUret(isim);
        
        while(beyblade == null)
        {
            System.out.print("Beyblade ismi giriniz = ");
            isim = scanner.nextLine();
            beyblade = constructor.constUret(isim);
        }
        
        beyblade.bilgiInfo();
        beyblade.saldir();
        beyblade.kutsalCanavarCagir();
        beyblade.gizliOzellik();
    }
}
