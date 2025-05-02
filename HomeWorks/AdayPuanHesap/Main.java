public class Main 
{
    public static void main(String[] args)
    {
        Aday EA1 = new EA("baris", 170423015, 31, 20, 34, 38);
        EA EA2 = new EA("ata", 170423006, 32, 21, 38, 34);
        
        MF MF1 = new MF("furkan", 170423019, 35, 39, 34, 26);
        MF MF2 = new MF("ceren", 171423004, 36, 37, 36, 30);
        
        TS TS1 = new TS("mustafa", 170423031, 15, 18, 39, 40);
        TS TS2 = new TS("arda", 170423009, 19, 16, 39, 38);
        
        Yazdirma yaz = new Yazdirma();
        
        yaz.yazdir(MF1);
        yaz.yazdir(MF2);
        
        yaz.yazdir(EA1);
        yaz.yazdir(EA2);
        
        yaz.yazdir(TS1);
        yaz.yazdir(TS2);
        
        
    }
}
