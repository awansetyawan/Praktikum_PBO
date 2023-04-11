import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ClassAkun.Login;
import ClassData.*;

public final class Main {

    static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Login> login = new ArrayList<Login>();
    
    // Fungsi Main
    public static void main(String[] args) throws Exception {

        Service service = new Service(null, null, null, null, null, 0, 0);
        Teknisi teknisi = new Teknisi(null, null, null, null);

        while (true){

            Boolean stop = false;

            Service.clearscreen();
            Login admin = new Login("Awan", "123");
            System.out.println("------------------------------------------");
            System.out.println("|                Login Akun              |");
            System.out.println("------------------------------------------");
            System.out.print("- Username     : ");
            String username = input.readLine();
            System.out.print("- Password     : ");
            String password = input.readLine();
            
            while (stop == false){
    
                if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    Service.clearscreen();
    
                    System.out.println("------------------------------------------");
                    System.out.println(">>>>>>>>>>> PENDATAAN INFORMASI <<<<<<<<<<");
                    System.out.println(">>>>>>>>>>>>>> SERVICE LAPTOP <<<<<<<<<<<<");
                    System.out.println("------------------------------------------");
                    System.out.println("Admin : " + admin.getUsername());
                    System.out.println("Catatan >> Tambahkan Teknisi Dahulu !!!");
                    System.out.println("\n1. Kelola Data Service");
                    System.out.println("2. Kelola Data Teknisi");
                    System.out.println("3. Logout");
                    System.out.print("Masukkan Pilihan : ");
                    int pilihan = Integer.parseInt(input.readLine());
        
                    switch (pilihan){
                        case 1:
                            service.menuService();
                            break;
                        case 2:
                            teknisi.menuTeknisi();
                            break;
                        case 3:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Pilihan Tidak Ada");
                            break;
                    }
                }else{
                    System.out.println(">>>> WARNING: USERNAME/PASSWORD SALAH <<<<");
                    Service.press();
                    stop = true;
                }
            }
        }
    }
}