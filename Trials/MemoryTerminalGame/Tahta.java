import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tahta 
{
    Kart[][] kart = new Kart[4][4];
    
    public void bilgiInfo()
    {
        Random rand = new Random();
        
        ArrayList<Character> chars = new ArrayList<Character>();
        
        chars.add('A');
        chars.add('B');
        chars.add('C');
        chars.add('D');
        
        chars.add('E');
        chars.add('F');
        chars.add('G');
        chars.add('H');
        
        char a = chars.get(rand.nextInt(8));
        char b = chars.get(rand.nextInt(8));
        while (b == a)
        {
            b = chars.get(rand.nextInt(8));
        }
        
        char c = chars.get(rand.nextInt(8));
        while (c == b || c == a)
        {
            c = chars.get(rand.nextInt(8));
        }
        
        char d = chars.get(rand.nextInt(8));
        while (d == b || d == a || d == c)
        {
            d = chars.get(rand.nextInt(8));
        }
        
        char e = chars.get(rand.nextInt(8));
        while (e == b || e == a || e == c || e == d)
        {
            e = chars.get(rand.nextInt(8));
        }
        
        char f = chars.get(rand.nextInt(8));
        while (f == b || f == a || f == c || f == d || f == e)
        {
            f = chars.get(rand.nextInt(8));
        }
        
        char g = chars.get(rand.nextInt(8));
        while (g == b || g == a || g == c || g == d || g == e || g == f)
        {
            g = chars.get(rand.nextInt(8));
        }
        
        char h = chars.get(rand.nextInt(8));
        while (h == b || h == a || h == c || h == d || h == e || h == f || h == g)
        {
            h = chars.get(rand.nextInt(8));
        }
        
        //----------------------------------------------------------------------------
        //----------------------------------------------------------------------------
        //----------------------------------------------------------------------------
        
        char xa = chars.get(rand.nextInt(8));
        char xb = chars.get(rand.nextInt(8));
        while (xb == xa)
        {
            xb = chars.get(rand.nextInt(8));
        }
        
        char xc = chars.get(rand.nextInt(8));
        while (xc == xb || xc == xa)
        {
            xc = chars.get(rand.nextInt(8));
        }
        
        char xd = chars.get(rand.nextInt(8));
        while (xd == xb || xd == xa || xd == xc)
        {
            xd = chars.get(rand.nextInt(8));
        }
        
        char xe = chars.get(rand.nextInt(8));
        while (xe == xb || xe == xa || xe == xc || xe == xd)
        {
            xe = chars.get(rand.nextInt(8));
        }
        
        char xf = chars.get(rand.nextInt(8));
        while (xf == xb || xf == xa || xf == xc || xf == xd || xf == xe)
        {
            xf = chars.get(rand.nextInt(8));
        }
        
        char xg = chars.get(rand.nextInt(8));
        while (xg == xb || xg == xa || xg == xc || xg == xd || xg == xe || xg == xf)
        {
            xg = chars.get(rand.nextInt(8));
        }
        
        char xh = chars.get(rand.nextInt(8));
        while (xh == xb || xh == xa || xh == xc || xh == xd || xh == xe || xh == xf || xh == xg)
        {
            xh = chars.get(rand.nextInt(8));
        }
        
        kart[0][0] = new Kart(a);
        kart[0][1] = new Kart(xa);
        kart[0][2] = new Kart(b);
        kart[0][3] = new Kart(xb);
        
        kart[1][0] = new Kart(c);
        kart[1][1] = new Kart(xc);
        kart[1][2] = new Kart(d);
        kart[1][3] = new Kart(xd);
        
        kart[2][0] = new Kart(e);
        kart[2][1] = new Kart(xe);
        kart[2][2] = new Kart(f);
        kart[2][3] = new Kart(xf);
        
        kart[3][0] = new Kart(g);
        kart[3][1] = new Kart(xg);
        kart[3][2] = new Kart(h);
        kart[3][3] = new Kart(xh);
    }
    
    public void oyunTahtasi()
    {
        System.out.println("    1     2     3     4");
        for(int i=0 ; i<4 ; i++)
        {            
            System.out.print((i+1)+"= ");
            for(int j=0 ; j<4 ; j++)
            {
                if (kart[i][j].getTahmin())
                {
                    System.out.print("|"+kart[i][j].getDeger()+"| - ");
                }
                else
                {
                    System.out.print("| | - ");
                }
            }
            System.out.println("\n--------------------------");
        }
    }
    
    
    public void tahminEt() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nSecmek istediginiz karti bosluklu giriniz(Ornek:2 3) = ");
        int a = scanner.nextInt()-1;
        int b = scanner.nextInt()-1;
        
        while (a<0 || a>3 || b<0 || b>3 || kart[a][b].getTahmin())
        {
            System.out.print("\nGecersiz kart! \nTekrar kart secin = ");
            a = scanner.nextInt()-1;
            b = scanner.nextInt()-1;
        }
        
        kart[a][b].setTahmin(true);
        System.out.println("\n--------------------------");
        oyunTahtasi();
        
        System.out.print("\nSecmek istediginiz 2. karti bosluklu giriniz(Ornek:2 3) = ");
        int c = scanner.nextInt()-1;
        int d = scanner.nextInt()-1;
        
        while (a<0 || a>3 || b<0 || b>3 || kart[c][d].getTahmin() || (a == c && b == d))
        {
            System.out.print("Gecersiz kart!\nTekrar kart secin = ");
            c = scanner.nextInt()-1;
            d = scanner.nextInt()-1;
        }
        
        kart[c][d].setTahmin(true);
        System.out.println("\n--------------------------");
        oyunTahtasi();
        
        if (kart[a][b].getDeger() == kart[c][d].getDeger())
        {
            System.out.println("\nTebrikler dogru tahmin!");
        }
        else
        {
            System.out.println("\nYanlis tahmin! Tekrar Deneyiniz.");
            kart[a][b].setTahmin(false);
            kart[c][d].setTahmin(false);
        }
        Thread.sleep(2500);
        System.out.println("\n--------------------------");
    }
    
    
    public boolean bitisControl()
    {
        for (int i = 0 ; i<4 ; i++)
        {
            for (int j = 0 ; j<4 ; j++)
            {
                if (!kart[i][j].getTahmin())
                {
                    return false;
                }
            }
        }
        System.out.println("Tebrikler oyunu bitirdiniz.");
        return true;
    }
}
