public class Service extends Data{
    private String merek;
    private String seri;
    private String kerusakan;
    private int hargaperbaikan;
    private int teknisi;
    
    public final int pajak = 5000;

    // Constructor
    public Service(String nama, String nohp, String merek, String seri, String kerusakan, int hargaperbaikan, int teknisi) {
        super(nama, nohp);
        this.merek = merek;
        this.seri = seri;
        this.kerusakan = kerusakan;
        this.hargaperbaikan = hargaperbaikan;
        this.teknisi = teknisi;
    }

    // Overloading
    public Service(String nama, String nohp){
        super(nama, nohp);
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

    public int getPajak(){
        return pajak;
    }

    @Override
    public void addData(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nService Laptop " + this.merek + " Dengan Seri " + this.seri);
    }

    // Overloading
    public void addData(String namaTeknisi, String nomorTeknisi){
        System.out.println("Dihandle Oleh " + namaTeknisi);
        System.out.println("Hubungi : " + nomorTeknisi);
        System.out.println("\n>> Total Harga Perbaikan : " + (hargaperbaikan+pajak));
        System.out.println("Note : Harga Telah Ditambah Pajak");
        System.out.println("\n>>>>>>>>>>>>>>>>>> Berhasil Ditambahkan <<<<<<<<<<<<<<<<<<<<<<");
    }
    
    @Override
    public void editData(int index){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nData Service Laptop Ke - " + index);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Edit <<<<<<<<<<<<<<<<<<<<<<<<");
    }

    // Overloading
    public final void addData(int jumlah){
        System.out.println("\nJumlah Data Service >> " + jumlah);
    }

}
