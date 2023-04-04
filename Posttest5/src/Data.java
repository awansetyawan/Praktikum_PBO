public abstract class Data {
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
    public abstract void addData();

    // Overriding
    public abstract void editData(int index);

}
