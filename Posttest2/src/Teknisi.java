public class Teknisi {
    private String nama;
    private String gender;
    private String nomorhp;

    // Setter and Getter nama, gender, dan nomorhp

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNomorhp() {
        return nomorhp;
    }

    public void setNomorhp(String nomorhp) {
        this.nomorhp = nomorhp;
    }

    // Constructor (Method Khusus)
    public Teknisi (String nama, String gender, String nomorhp){
        this.nama = nama;
        this.gender = gender;
        this.nomorhp = nomorhp;
    }
}
