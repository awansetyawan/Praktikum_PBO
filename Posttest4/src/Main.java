import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Service> DataLaptop = new ArrayList<Service>();
    static ArrayList<Teknisi> DataTeknisi = new ArrayList<Teknisi>();
    
    // Fungsi Main
    public static void main(String[] args) throws Exception {
        
        while (true){

            clearscreen();

            System.out.println("------------------------------------------");
            System.out.println(">>>>>>>>>>> PENDATAAN INFORMASI <<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>> SERVICE LAPTOP <<<<<<<<<<<<");
            System.out.println("------------------------------------------");
            System.out.println("Pembuat : Awan - 002");
            System.out.println("Catatan >> Tambahkan Teknisi Dahulu !!!");
            System.out.println("\n1. Kelola Data Service");
            System.out.println("2. Kelola Data Teknisi");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = Integer.parseInt(br.readLine());


            switch (pilihan){
                case 1:
                    menuService();
                    break;
                case 2:
                    menuTeknisi();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Tidak Ada");
                    break;
            }
        }
    }

    // Fungsi Clearscreen
    public static void clearscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Fungsi Tekan Enter
    public static void press() throws IOException {
        System.out.print("\n>> Press enter to continue");
        br.readLine();
    }

    // Menu Service
    public static void menuService() throws IOException{
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
            int pilihan = Integer.parseInt(br.readLine());

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

    // Menambahkan Data Service
    public static void createService() throws IOException{
        clearscreen();

        System.out.println("|======================= Tambah Data ========================|");
        System.out.print("\nMasukkan Merek Laptop     : ");
        String addmerek = br.readLine();
        System.out.print("Masukkan Seri Laptop      : ");
        String addseri = br.readLine();
        System.out.print("Masukkan Nama Pemilik     : ");
        String addpemilik = br.readLine();
        System.out.print("Masukkan Nomor HP Pemilik : ");
        String addnohp = br.readLine();
        System.out.print("Kerusakan Yang Dialami    : ");
        String addkerusakan = br.readLine();
        System.out.print("Masukkan Harga Perbaikan  : ");
        int addharga = Integer.parseInt(br.readLine());
        
        readTeknisi();
        System.out.print("\nPilih Data Teknisi           : ");
        int pilihteknisi = Integer.parseInt(br.readLine());

        Service service = new Service(addpemilik, addnohp, addmerek, addseri, addkerusakan, addharga, pilihteknisi);
        DataLaptop.add(service);

        press();

        clearscreen();

        // Overriding
        service.addData();

        int jumlah = DataLaptop.size();
        
        int dataindex = (DataLaptop.get(jumlah-1).getTeknisi())-1;
        String namateknisi = DataTeknisi.get(dataindex).getNama();
        String noteknisi = DataTeknisi.get(dataindex).getNohp();

        // Overloading
        service.addData(namateknisi, noteknisi);
        
        // Overloading
        service.addData(jumlah);

        press();
    }

    // Melihat Data Service
    public static void readService() throws IOException{
        clearscreen();

        int jumlah = DataLaptop.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            System.out.println("|======================= Data Service =======================|");
    
            for (int i = 0; i < DataLaptop.size(); i++){
                System.out.println("\n>>> Data Service Ke - " + (i+1));
                System.out.println("--------------------------------------------------------------");

                // Mengakses private atribut (Encapsulation)
                System.out.println("Merek Laptop    : " + DataLaptop.get(i).getMerek());
                System.out.println("Seri Laptop     : " + DataLaptop.get(i).getSeri());
                System.out.println("Pemilik Laptop  : " + DataLaptop.get(i).getNama());
                System.out.println("No HP Pemilik   : " + DataLaptop.get(i).getNohp());
                System.out.println("Kerusakan       : " + DataLaptop.get(i).getKerusakan());
                System.out.println("Harga Perbaikan : " + DataLaptop.get(i).getHargaperbaikan());
                System.out.println(">>> Teknisi Yang Memperbaiki");

                int dataindex = (DataLaptop.get(i).getTeknisi())-1;

                if (dataindex < 0 || dataindex >= DataTeknisi.size()) {
                    System.out.println("Nama Teknisi                 : ");
                    System.out.println("Gender (Laki-laki/Perempuan) : ");
                    System.out.println("Keahlian (Hardware/Software) : ");
                    System.out.println("Nomor HP Teknisi             : ");
                }else{
                    System.out.println("Nama Teknisi                 : " + DataTeknisi.get(dataindex).getNama());
                    System.out.println("Gender (Laki-laki/Perempuan) : " + DataTeknisi.get(dataindex).getGender());
                    System.out.println("Keahlian (Hardware/Software) : " + DataTeknisi.get(dataindex).getKeahlian());
                    System.out.println("Nomor HP Teknisi             : " + DataTeknisi.get(dataindex).getNohp());
                }
                System.out.println("--------------------------------------------------------------");
            }
        }

        press();

    }

    // Mengedit Data Service
    public static void editService() throws IOException{
        clearscreen();

        int jumlah = DataLaptop.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readService();    
            
            System.out.print("\nMasukkan Indeks >>> ");
            int idx = Integer.parseInt(br.readLine());

            if (idx <= jumlah && idx > 0){
                System.out.print("\nMasukkan Merek Laptop     : ");
                String addmerek = br.readLine();
                System.out.print("Masukkan Seri Laptop      : ");
                String addseri = br.readLine();
                System.out.print("Masukkan Nama Pemilik     : ");
                String addpemilik = br.readLine();
                System.out.print("Masukkan Nomor HP Pemilik : ");
                String addnohp = br.readLine();
                System.out.print("Kerusakan Yang Dialami    : ");
                String addkerusakan = br.readLine();
                System.out.print("Masukkan Harga Perbaikan  : ");
                int addharga = Integer.parseInt(br.readLine());
    
                readTeknisi();
                System.out.print("\nPilih Data Teknisi           : ");
                int pilihteknisi = Integer.parseInt(br.readLine());

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

    // Menghapus Data Service
    public static void deleteService() throws IOException{
        clearscreen();

        int jumlah = DataLaptop.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readService();
    
            System.out.print("\nMasukkan Indeks >>> ");
            int idx = Integer.parseInt(br.readLine());
    
            if (idx <= jumlah && idx > 0){
                DataLaptop.remove(idx - 1);

                press();

                clearscreen();

                System.out.println("--------------------------------------------------------------");
                System.out.println("\nData Service Laptop Ke - " + idx);                
                System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Hapus <<<<<<<<<<<<<<<<<<<<<<<");
                
                Service service = new Service(null, null);

                // Overloading
                service.addData(jumlah-1);
            }else{
                System.out.println("\nData tidak ada");
            }
        }

        press();
    }

    // Menu Teknisi
    public static void menuTeknisi() throws IOException{
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
            int pilihan = Integer.parseInt(br.readLine());

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

    // Menambahkan Data Teknisi
    public static void createTeknisi() throws IOException{
        clearscreen();

        System.out.println("|======================= Tambah Data ========================|");
        System.out.print("\nMasukkan Nama Teknisi        : ");
        String addnama = br.readLine();
        System.out.print("Gender (Laki-laki/Perempuan) : ");
        String addgender = br.readLine();
        System.out.print("Keahlian (Hardware/Software) : ");
        String addkeahlian = br.readLine();
        System.out.print("Masukkan Nomor HP Teknisi    : ");
        String addnohpteknisi = br.readLine();

        Teknisi teknisi = new Teknisi(addnama, addnohpteknisi, addgender, addkeahlian);
        DataTeknisi.add(teknisi);

        press();

        clearscreen();

        // Overloading
        teknisi.addData(addnama);

        // Overriding
        teknisi.addData();

        int jumlah = DataTeknisi.size();

        // Overloading
        teknisi.addData(jumlah);

        press();
    }

    // Melihat Data Teknisi
    public static void readTeknisi() throws IOException{

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

    // Mengedit Data Teknisi
    public static void editTeknisi() throws IOException{
        clearscreen();

        int jumlah = DataTeknisi.size();

        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readTeknisi();
    
            System.out.print("\nMasukkan Indeks >>> ");
            int idx = Integer.parseInt(br.readLine());
    
            if (idx <= jumlah && idx > 0){
                System.out.print("\nMasukkan Nama Teknisi        : ");
                String addnama = br.readLine();
                System.out.print("Gender (Laki-laki/Perempuan) : ");
                String addgender = br.readLine();
                System.out.print("Keahlian (Hardware/Software) : ");
                String addkeahlian = br.readLine();
                System.out.print("Masukkan Nomor HP Teknisi    : ");
                String addnohpteknisi = br.readLine();

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

    // Menghapus Data Teknisi
    public static void deleteTeknisi() throws IOException{
        clearscreen();

        int jumlah = DataTeknisi.size();
        
        if (jumlah <= 0){
            System.out.println("\nData tidak ada");
        }else{
            readTeknisi();
    
            System.out.print("\nMasukkan Indeks >>> ");
    
            int idx = Integer.parseInt(br.readLine());
    
            if (idx <= jumlah && idx > 0){
                DataTeknisi.remove(idx - 1);

                press();

                clearscreen();

                System.out.println("--------------------------------------------------------------");
                System.out.println("\nData Teknisi Service Laptop Ke - " + idx);                
                System.out.println("\n>>>>>>>>>>>>>>>>>>>> Berhasil Di Hapus <<<<<<<<<<<<<<<<<<<<<<<");

                Teknisi teknisi = new Teknisi(null, null);
    
                // Overloading
                teknisi.addData(jumlah-1);
            }else{
                System.out.println("\nData tidak ada");
            }
        }

        press();
    }
}