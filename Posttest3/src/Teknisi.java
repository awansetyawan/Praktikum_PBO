public class Teknisi extends Data{
    private String gender;
    private String keahlian;

    // Constructor

    public Teknisi(String nama, String nohp, String gender, String keahlian) {
        super(nama, nohp);
        this.gender = gender;
        this.keahlian = keahlian;
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
}
