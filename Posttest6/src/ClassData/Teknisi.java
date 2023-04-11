package ClassData;

import Interface.Interface1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class Teknisi extends Data implements Interface1{
    static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Teknisi> DataTeknisi = new ArrayList<Teknisi>();
    
    // Property
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
    
    @Override
    public void addData(){
        System.out.println("Bidang Keahlian Teknisi Adalah " + this.keahlian);
        System.out.println("\n>>>>>>>>>>>>>>>>>> Berhasil Ditambahkan <<<<<<<<<<<<<<<<<<<<<<");
    }
    
    // Overloading
    public static void addData(String namaTeknisi){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nNama Teknisi : " + namaTeknisi);
    }

    // Overloading
    public final static void addData(int jumlah){
        System.out.println("\nJumlah Data Teknisi >> " + jumlah);
    }

    @Override
    public void editData(int index){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nData Teknisi Service Laptop Ke - " + index);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Edit <<<<<<<<<<<<<<<<<<<<<<<<");
    }

    // Fungsi Clearscreen
    public final static void clearscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Fungsi Tekan Enter
    public static void press() throws IOException {
        System.out.print("\n>> Press enter to continue");
        input.readLine();
    }

    // Implements Method Interface1
    
    @Override
    public void createTeknisi() throws IOException {
        clearscreen();

        System.out.println("|======================= Tambah Data ========================|");
        System.out.print("\nMasukkan Nama Teknisi        : ");
        String addnama = input.readLine();
        System.out.print("Gender (Laki-laki/Perempuan) : ");
        String addgender = input.readLine();
        System.out.print("Keahlian (Hardware/Software) : ");
        String addkeahlian = input.readLine();
        System.out.print("Masukkan Nomor HP Teknisi    : ");
        String addnohpteknisi = input.readLine();

        Teknisi teknisi = new Teknisi(addnama, addnohpteknisi, addgender, addkeahlian);
        DataTeknisi.add(teknisi);

        press();

        clearscreen();

        // Overloading
        Teknisi.addData(addnama);

        // Overriding
        teknisi.addData();

        int jumlah = DataTeknisi.size();

        // Overloading
        Teknisi.addData(jumlah);

        press();
    }

    @Override
    public void editTeknisi() throws IOException {
        clearscreen();

        int jumlah = DataTeknisi.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readTeknisi();
    
            System.out.print("\nMasukkan Indeks >>> ");
            int idx = Integer.parseInt(input.readLine());
    
            if (idx <= jumlah && idx > 0){
                System.out.print("\nMasukkan Nama Teknisi        : ");
                String addnama = input.readLine();
                System.out.print("Gender (Laki-laki/Perempuan) : ");
                String addgender = input.readLine();
                System.out.print("Keahlian (Hardware/Software) : ");
                String addkeahlian = input.readLine();
                System.out.print("Masukkan Nomor HP Teknisi    : ");
                String addnohpteknisi = input.readLine();

                // Mengedit private atribut (Encapsulation)
                DataTeknisi.get(idx-1).setNama(addnama);
                DataTeknisi.get(idx-1).setGender(addgender);
                DataTeknisi.get(idx-1).setKeahlian(addkeahlian);
                DataTeknisi.get(idx-1).setNohp(addnohpteknisi);

                press();

                clearscreen();

                Teknisi teknisi = new Teknisi(addnama, addnohpteknisi, addgender, addkeahlian);

                // Overloading
                teknisi.editData(idx);
            }else{
                System.out.println("\nData tidak ada");
            }
        }

        press();
    }

    @Override
    public void deleteTeknisi() throws IOException {
        clearscreen();

        int jumlah = DataTeknisi.size();
        
        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readTeknisi();
    
            System.out.print("\nMasukkan Indeks >>> ");
    
            int idx = Integer.parseInt(input.readLine());
    
            if (idx <= jumlah && idx > 0){
                DataTeknisi.remove(idx - 1);

                press();

                clearscreen();

                System.out.println("--------------------------------------------------------------");
                System.out.println("\nData Teknisi Service Laptop Ke - " + idx);                
                System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Hapus <<<<<<<<<<<<<<<<<<<<<<<");
    
                // Overloading
                Teknisi.addData(jumlah-1);
            }else{
                System.out.println("\nData tidak ada");
            }
        }

        press();
    }

    @Override
    public void readTeknisi() throws IOException {
        int jumlah = DataTeknisi.size();
        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            System.out.println("\n|======================= Data Teknisi =======================|");
    
            for (int i = 0; i < DataTeknisi.size(); i++){
                System.out.println("\nData Teknisi Ke - " + (i+1));
                System.out.println("--------------------------------------------------------------");

                // Mengakses private atribut (Encapsulation)
                System.out.println("Nama Teknisi                 : " + DataTeknisi.get(i).getNama());
                System.out.println("Gender (Laki-laki/Perempuan) : " + DataTeknisi.get(i).getGender());
                System.out.println("Keahlian (Hardware/Software) : " + DataTeknisi.get(i).getKeahlian());
                System.out.println("Nomor HP Teknisi             : " + DataTeknisi.get(i).getNohp());
            }
        }
    }

    @Override
    public void menuTeknisi() throws IOException {
        boolean stop = false;
        while(stop == false){
            clearscreen();
            System.out.println("------------------------------------------");
            System.out.println(">>>>>>>>>>>>>> DATA TEKNISI <<<<<<<<<<<<<<");
            System.out.println("------------------------------------------");
            System.out.println("1. Tambah Data Teknisi");
            System.out.println("2. Lihat Data Teknisi");
            System.out.println("3. Perbarui Data Teknisi");
            System.out.println("4. Hapus Data Teknisi");
            System.out.println("5. Kembali");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan){
                case 1:
                    createTeknisi();
                    break;
                case 2:
                    clearscreen();
                    readTeknisi();
                    press();
                    break;
                case 3:
                    editTeknisi();
                    break;
                case 4:
                    deleteTeknisi();
                    break;
                case 5:
                    stop = true;
                    break;
                default:
                    System.out.println("Pilihan Tidak Ada");
                    break;
            }
        }
    }
    
}
