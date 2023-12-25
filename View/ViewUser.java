package View;

import Controller.ControllerUser;
import Controller.ControllerGame;
import Node.NodeGames;

import java.util.Locale;
import java.util.Scanner;

public class ViewUser {
    private ControllerUser controllerUser;
    private ControllerGame controllerGame;
    private Locale formatRupiah;

    public ViewUser(ControllerUser controllerUser, ControllerGame controllerGame){
        this.controllerUser = controllerUser;
        this.controllerGame = controllerGame;
        this.formatRupiah = new Locale("id", "ID");
    }

    public void MenuUser(String Email){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
        System.out.println("-------------------------");
        System.out.println("|\tMenu User\t|");
        System.out.println("-------------------------");
        System.out.println("1. Cari Game\t\t|");
        System.out.println("2. Lihat Game\t\t|");
        System.out.println("3. Info Akun\t\t|");
        System.out.println("4. Update Akun\t\t|");
        System.out.println("5. Isi Saldo\t\t|");
        System.out.println("6. Cek Saldo\t\t|");
        System.out.println("7. Histori Top Up\t|");
        System.out.println("8. Kembali\t\t|");
        System.out.println("-------------------------");
        System.out.print("Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("-------------------------");
            switch (pilih) {
                case 1:
                System.out.println("- Pencarian Game -");
                    System.out.print("Masukkan Nama Game : ");
                    String namaGame = input.nextLine();
                    NodeGames game = controllerGame.searchGames(namaGame);
                    if (game != null) {
                        game.viewGame();
                    } else {
                        System.out.println("Game Tidak Ditemukan!");
                    }
                    break;
                case 2:
                    System.out.println("- Menampilkan Data Game -");
                    for (NodeGames gameList : controllerGame.viewAllGames()) {
                        gameList.viewGame();
                        System.out.println("==============================");
                    }
                    break;
                case 3:
                    System.out.println("- Info Akun -");
                    controllerUser.searchUser(Email).viewUser();
                    break;
                case 4:
                    System.out.println("- Update Akun -");
                    System.out.print("Masukkan Password Baru : "); String newPass = input.nextLine(); 
                    System.out.print("Masukkan PIN Baru : "); int newPIN = input.nextInt();
                    controllerUser.updateUser(Email, newPass, newPIN);
                    break;
                case 5:
                    System.out.println(" - Isi Saldo -");
                    System.out.println("1. Rp. 5.000");
                    System.out.println("2. Rp. 10.000");
                    System.out.println("3. Rp. 15.000");
                    System.out.println("4. Rp. 20.000");
                    System.out.println("5. Rp. 30.000");
                    System.out.println("6. Rp. 50.000");
                    System.out.println("7. Rp. 100.000");
                    System.out.println("8. Rp. 200.000");
                    System.out.print("Pilihan Anda : "); int pilihSaldo = input.nextInt();
                    controllerUser.isiSaldo(Email, pilihSaldo);
                    break;
                case 6:
                    System.out.println(" - Cek Saldo -");
                    System.out.println("Sisa Saldo anda tersisa : " + String.format(formatRupiah, "Rp. %,.2f", controllerUser.searchUser(Email).getSaldo()));
                    break;
                case 7:
                    //Fitur Histori Masih Belum Dibuat!!!
                    break;
                case 8:
                    System.out.println("Program berakhir");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}