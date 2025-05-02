
public class BeybladeConst
{
    public Beyblade constUret(String beybladeIsmi)
    {
        if (beybladeIsmi.equals("Dragon") || beybladeIsmi.equals("dragon"))
        {
            return new Dragon("Rei",700,800,"KirmiziEjder","Kutsal Konusma");
        }
        else if (beybladeIsmi.equals("Drakula") || beybladeIsmi.equals("drakula"))
        {
            return new Drakula("Max",1200,300);
        }
        else if (beybladeIsmi.equals("Chester") || beybladeIsmi.equals("chester"))
        {
            return new Chester("Tyron",600,1000,"Kara Kaplan");
        }
        else
        {
            System.out.println("Yanlis beyblade ismi girdiniz.");
            return null;
        }
    }
}
