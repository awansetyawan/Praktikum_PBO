public class Laptop {
    private String merek;
    private String seri;
    private String namapemilik;
    private String nomorhp;
    private String kerusakan;
    private int hargaperbaikan;
    private int teknisi;

    // Setter and Getter merek, seri, namapemilik, nomorhp, kerusakan, hargaperbaikan, dan teknisi

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getNamapemilik() {
        return namapemilik;
    }

    public void setNamapemilik(String namapemilik) {
        this.namapemilik = namapemilik;
    }

    public String getNomorhp() {
        return nomorhp;
    }

    public void setNomorhp(String nomorhp) {
        this.nomorhp = nomorhp;
    }

    public String getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }

    public int getHargaperbaikan() {
        return hargaperbaikan;
    }

    public void setHargaperbaikan(int hargaperbaikan) {
        this.hargaperbaikan = hargaperbaikan;
    }

    public int getTeknisi() {
        return teknisi;
    }

    public void setTeknisi(int teknisi) {
        this.teknisi = teknisi;
    }

    // Constructor (Method Khusus)
    public Laptop(String merek, String seri, String namapemilik, String nomorhp, String kerusakan, int hargaperbaikan, int teknisi){
        this.merek = merek;
        this.seri = seri;
        this.namapemilik = namapemilik;
        this.nomorhp = nomorhp;
        this.kerusakan = kerusakan;
        this.hargaperbaikan = hargaperbaikan;
        this.teknisi = teknisi;
    }
}
