package Java;

public class Kitap {
    private static int idSayaci = 1;
    private final int id;
    private String adi;
    private String yazar;
    private int sahipID = -1;
    private boolean oduncAlindi = false;
    
    public Kitap(String adi, String yazar) {
        this.id = idSayaci++;
        this.adi = adi;
        this.yazar = yazar;
    }

    public Kitap(String adi, String yazar, boolean durum, int sahipID) {
        this.id = idSayaci++;
        this.adi = adi;
        this.yazar = yazar;
        this.oduncAlindi = durum;
        this.sahipID = sahipID;
    }

    public int getId() {
        return id;
    }

    public String getAdi() {
        return adi;
    }

    public String getYazar() {
        return yazar;
    }
    
    public int getSahipID() {
        return sahipID;
    }

    public boolean isOduncAlindi() {
        return oduncAlindi;
    }

    public void setOduncAlindi(boolean oduncAlindi) {
        this.oduncAlindi = oduncAlindi;
    }
    
    public void setSahipID(int sahipID) {
        this.sahipID = sahipID;
    }
}
