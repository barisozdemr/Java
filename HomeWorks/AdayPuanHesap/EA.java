public class EA extends Aday
{
    public EA(String isim, int no, int matematik, int fen, int turkce, int sosyal) 
    {
        super(isim, no, matematik, fen, turkce, sosyal);
    }
    
    @Override
    public int puanHesap()
    {
        return matematik*5 + turkce*5 + fen*2 + sosyal*2;
    }

    @Override
    public String getIsim()
    {
        return isim;
    }

    @Override
    public int getNo() 
    {
        return no;
    }
    
}
