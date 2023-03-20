public class Service extends Data{
    private String merek;
    private String seri;
    private String kerusakan;
    private int hargaperbaikan;
    private int teknisi;

    // Constructor

    public Service(String nama, String nohp, String merek, String seri, String kerusakan, int hargaperbaikan, int teknisi) {
        super(nama, nohp);
        this.merek = merek;
        this.seri = seri;
        this.kerusakan = kerusakan;
        this.hargaperbaikan = hargaperbaikan;
        this.teknisi = teknisi;
    }

    // Setter and Getter
    
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

}
