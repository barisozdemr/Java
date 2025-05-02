public class Yazdirma<E extends Aday>
{
    public void yazdir(E e)
    {
        System.out.println(e.getIsim()+" isimli, "+e.getNo()+" no'lu adayin puani = "+e.puanHesap());
    }
}
