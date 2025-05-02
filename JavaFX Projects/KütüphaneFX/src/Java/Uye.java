package Java;

public class Uye {
    private static int idSayaci = 1;
    private final int id;
    private String ad;
    private String soyad;

    public Uye(String ad, String soyad) {
        this.id = idSayaci++;
        this.ad = ad;
        this.soyad = soyad;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }
}
