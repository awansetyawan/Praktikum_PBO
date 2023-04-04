public final class Teknisi extends Data{
    private String gender;
    private String keahlian;

    // Constructor
    public Teknisi(String nama, String nohp, String gender, String keahlian) {
        super(nama, nohp);
        this.gender = gender;
        this.keahlian = keahlian;
    }

    // Overloading
    public Teknisi(String nama, String nohp){
        super(nama, nohp);
    }
    
    // Setter and Getter
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    // Overloading
    public void addData(String namaTeknisi){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nNama Teknisi : " + namaTeknisi);
    }

    @Override
    public void addData(){
        System.out.println("Bidang Keahlian Teknisi Adalah " + this.keahlian);
        System.out.println("\n>>>>>>>>>>>>>>>>>> Berhasil Ditambahkan <<<<<<<<<<<<<<<<<<<<<<");
    }
    
    @Override
    public void editData(int index){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nData Teknisi Service Laptop Ke - " + index);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Edit <<<<<<<<<<<<<<<<<<<<<<<<");
    }

    // Overloading
    public final void addData(int jumlah){
        System.out.println("\nJumlah Data Teknisi >> " + jumlah);
    }

}
