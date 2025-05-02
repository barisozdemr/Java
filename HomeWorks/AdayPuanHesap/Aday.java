public abstract class Aday
{
    public String isim;
    public int no;
    
    public int matematik;
    public int fen;
    public int turkce;
    public int sosyal;

    public Aday(String isim, int no, int matematik, int fen, int turkce, int sosyal) {
        this.isim = isim;
        this.no = no;
        this.matematik = matematik;
        this.fen = fen;
        this.turkce = turkce;
        this.sosyal = sosyal;
    }
    
    public abstract int puanHesap();
    
    public abstract String getIsim();
    
    public abstract int getNo();
}
