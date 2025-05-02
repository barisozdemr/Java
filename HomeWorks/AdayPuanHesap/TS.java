public class TS extends Aday
{
    public TS(String isim, int no, int matematik, int fen, int turkce, int sosyal) 
    {
        super(isim, no, matematik, fen, turkce, sosyal);
    }
    
    @Override
    public int puanHesap()
    {
        return matematik*2 + turkce*5 + fen*2 + sosyal*5;
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
