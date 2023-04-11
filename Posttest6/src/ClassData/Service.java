package ClassData;

import Interface.Interface2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Service extends Data implements Interface2 {
    static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Service> DataLaptop = new ArrayList<Service>();

    static Teknisi TeknisiContent = new Teknisi(null, null, null, null);
    
    // Property
    private String merek;
    private String seri;
    private String kerusakan;
    private int hargaperbaikan;
    private int teknisi;
    
    public final static int pajak = 5000;

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
    
    // Overloading
    public final static void addData(int jumlah){
        System.out.println("\nJumlah Data Service >> " + jumlah);
    }

    @Override
    public void editData(int index){
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nData Service Laptop Ke - " + index);
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

    // Implements Method Interface2

    @Override
    public void createService() throws IOException {
        int JumlahTeknisi = Teknisi.DataTeknisi.size();
        clearscreen();

        System.out.println("|======================= Tambah Data ========================|");
        System.out.print("\nMasukkan Merek Laptop     : ");
        String addmerek = input.readLine();
        System.out.print("Masukkan Seri Laptop      : ");
        String addseri = input.readLine();
        System.out.print("Masukkan Nama Pemilik     : ");
        String addpemilik = input.readLine();
        System.out.print("Masukkan Nomor HP Pemilik : ");
        String addnohp = input.readLine();
        System.out.print("Kerusakan Yang Dialami    : ");
        String addkerusakan = input.readLine();
        System.out.print("Masukkan Harga Perbaikan  : ");
        int addharga = Integer.parseInt(input.readLine());
        
        if (JumlahTeknisi <= 0) {
            System.out.print("\n>> Note : Teknisi Tidak Ada Tambahkan Data Teknisi Dahulu !!!\n");

            int pilihteknisi = 0;

            Service service = new Service(addpemilik, addnohp, addmerek, addseri, addkerusakan, addharga, pilihteknisi);
            DataLaptop.add(service);
        }else{
            TeknisiContent.readTeknisi();
            System.out.print("\nPilih Data Teknisi           : ");
            int pilihteknisi = Integer.parseInt(input.readLine());

            Service service = new Service(addpemilik, addnohp, addmerek, addseri, addkerusakan, addharga, pilihteknisi);
            DataLaptop.add(service);
    
            press();
    
            clearscreen();
            
            if (pilihteknisi < JumlahTeknisi || pilihteknisi > JumlahTeknisi){
                System.out.print("\n>> Note : Data Teknisi Yang Dipilih Tidak Ada !!!\n");
            }else{
                // Overriding
                service.addData();
        
                int jumlah = DataLaptop.size();
                
                int dataindex = (DataLaptop.get(jumlah-1).getTeknisi())-1;
                String namateknisi = Teknisi.DataTeknisi.get(dataindex).getNama();
                String noteknisi = Teknisi.DataTeknisi.get(dataindex).getNohp();
        
                // Overloading
                service.addData(namateknisi, noteknisi);
                
                // Overloading
                Service.addData(jumlah);
            }
        }

        press();
    }

    @Override
    public void editService() throws IOException {
        int JumlahTeknisi = Teknisi.DataTeknisi.size();
        int pilihteknisi;

        clearscreen();

        int jumlah = DataLaptop.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readService();    
            
            System.out.print("\nMasukkan Indeks >>> ");
            int idx = Integer.parseInt(input.readLine());

            if (idx <= jumlah && idx > 0){
                System.out.print("\nMasukkan Merek Laptop     : ");
                String addmerek = input.readLine();
                System.out.print("Masukkan Seri Laptop      : ");
                String addseri = input.readLine();
                System.out.print("Masukkan Nama Pemilik     : ");
                String addpemilik = input.readLine();
                System.out.print("Masukkan Nomor HP Pemilik : ");
                String addnohp = input.readLine();
                System.out.print("Kerusakan Yang Dialami    : ");
                String addkerusakan = input.readLine();
                System.out.print("\n>> Note : Masukkan Harga Tanpa Penambahan Pajak (5000)");
                System.out.print("\nMasukkan Harga Perbaikan  : ");
                int addharga = Integer.parseInt(input.readLine());
                
                        
                if (JumlahTeknisi <= 0) {
                    System.out.print("\n>> Note : Teknisi Tidak Ada Tambahkan Data Teknisi Dahulu !!!\n");

                    pilihteknisi = 0;

                }else{
                    TeknisiContent.readTeknisi();
                    System.out.print("\nPilih Data Teknisi           : ");
                    pilihteknisi = Integer.parseInt(input.readLine());
                }

                // Mengedit private atribut (Encapsulation)

                DataLaptop.get(idx-1).setMerek(addmerek);
                DataLaptop.get(idx-1).setSeri(addseri);
                DataLaptop.get(idx-1).setNama(addpemilik);
                DataLaptop.get(idx-1).setNohp(addnohp);
                DataLaptop.get(idx-1).setKerusakan(addkerusakan);
                DataLaptop.get(idx-1).setHargaperbaikan(addharga);
                DataLaptop.get(idx-1).setTeknisi(pilihteknisi);

                press();

                clearscreen();
                
                Service service = new Service(addpemilik, addnohp, addmerek, addseri, addkerusakan, addharga, pilihteknisi);

                // Overloading
                service.editData(idx);
            }else{
                System.out.println("\nData tidak ada");
            }

        }

        press();
    }

    @Override
    public void deleteService() throws IOException {
        clearscreen();

        int jumlah = DataLaptop.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readService();
    
            System.out.print("\nMasukkan Indeks >>> ");
            int idx = Integer.parseInt(input.readLine());
    
            if (idx <= jumlah && idx > 0){
                DataLaptop.remove(idx - 1);

                press();

                clearscreen();

                System.out.println("--------------------------------------------------------------");
                System.out.println("\nData Service Laptop Ke - " + idx);                
                System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Hapus <<<<<<<<<<<<<<<<<<<<<<<");

                // Overloading
                Service.addData(jumlah-1);
            }else{
                System.out.println("\nData tidak ada");
            }
        }

        press();
    }
 
    @Override
    public void readService() throws IOException {
        clearscreen();

        int jumlah = DataLaptop.size();
        int TotalHarga;

        Service Pajak = new Service(null, null);

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            System.out.println("|======================= Data Service =======================|");
    
            for (int i = 0; i < DataLaptop.size(); i++){
                System.out.println("\n>>> Data Service Ke - " + (i+1));
                System.out.println("--------------------------------------------------------------");
                
                int indexharga = (DataLaptop.get(i).getTeknisi());
                
                if (indexharga <= 0 || indexharga > Teknisi.DataTeknisi.size()) {
                    TotalHarga = DataLaptop.get(i).getHargaperbaikan();
                }else{
                    // Menghitung Total Harga = Harga Awal + Pajak
                    TotalHarga = DataLaptop.get(i).getHargaperbaikan() + Pajak.getPajak();
                }
                
                // Mengakses private atribut (Encapsulation)
                System.out.println("Merek Laptop    : " + DataLaptop.get(i).getMerek());
                System.out.println("Seri Laptop     : " + DataLaptop.get(i).getSeri());
                System.out.println("Pemilik Laptop  : " + DataLaptop.get(i).getNama());
                System.out.println("No HP Pemilik   : " + DataLaptop.get(i).getNohp());
                System.out.println("Kerusakan       : " + DataLaptop.get(i).getKerusakan());
                System.out.println("Harga Perbaikan : " + TotalHarga);
                System.out.println(">>> Teknisi Yang Memperbaiki");
                
                int indexteknisi = (DataLaptop.get(i).getTeknisi())-1;

                if (indexteknisi < 0 || indexteknisi >= Teknisi.DataTeknisi.size()) {
                    System.out.println("Nama Teknisi                 : ");
                    System.out.println("Gender (Laki-laki/Perempuan) : ");
                    System.out.println("Keahlian (Hardware/Software) : ");
                    System.out.println("Nomor HP Teknisi             : ");
                }else{
                    System.out.println("Nama Teknisi                 : " + Teknisi.DataTeknisi.get(indexteknisi).getNama());
                    System.out.println("Gender (Laki-laki/Perempuan) : " + Teknisi.DataTeknisi.get(indexteknisi).getGender());
                    System.out.println("Keahlian (Hardware/Software) : " + Teknisi.DataTeknisi.get(indexteknisi).getKeahlian());
                    System.out.println("Nomor HP Teknisi             : " + Teknisi.DataTeknisi.get(indexteknisi).getNohp());
                }
                System.out.println("--------------------------------------------------------------");
            }
        }

        press();
    }
    
    @Override
    public void menuService() throws IOException {
        boolean stop = false;
        while (stop == false){
            clearscreen();
            System.out.println("------------------------------------------");
            System.out.println(">>>>>>>>>>>>> DATA INFORMASI <<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>> SERVICE LAPTOP <<<<<<<<<<<<<");
            System.out.println("------------------------------------------");
            System.out.println("1. Tambah Data Service");
            System.out.println("2. Lihat Data Service");
            System.out.println("3. Perbarui Data Service");
            System.out.println("4. Hapus Data Service");
            System.out.println("5. Kembali");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan){
                case 1:
                    createService();
                    break;
                case 2:
                    readService();
                    break;
                case 3:
                    editService();
                    break;
                case 4:
                    deleteService();
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
