public class Data {
    private String nama;
    private String nohp;

    // Constructor

    public Data(String nama, String nohp) {
        this.nama = nama;
        this.nohp = nohp;
    }

    // Setter and Getter
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    // Overriding
    public void addData(){
        System.out.println("Data Dengan Nama " + this.nama + " Berhasil Ditambahkan");
    }

    // Overriding
    public void editData(int index){
        System.out.println("Data Dengan Index " + index + " Berhasil Diedit");
    }

}
