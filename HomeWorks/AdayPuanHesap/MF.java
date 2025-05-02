public class MF extends Aday 
{
    public MF(String isim, int no, int matematik, int fen, int turkce, int sosyal) 
    {
        super(isim, no, matematik, fen, turkce, sosyal);
    }
    
    @Override
    public int puanHesap()
    {
        return matematik*5 + turkce*2 + fen*5 + sosyal*2;
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
