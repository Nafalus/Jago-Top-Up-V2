package View;

import Controller.*;
import Node.NodeGames;
import Node.NodeGames.Item;
import Node.NodeHarga;

import java.util.*;

public class ViewUser {
    private ControllerUser controllerUser;
    private ControllerGame controllerGame;
    private ControllerHarga controllerHarga;
    private Locale formatRupiah;

    public ViewUser(ControllerUser controllerUser, ControllerGame controllerGame, ControllerHarga controllerHarga){
        this.controllerUser = controllerUser;
        this.controllerGame = controllerGame;
        this.controllerHarga = controllerHarga;
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
        System.out.println("8. Logout\t\t|");
        System.out.println("-------------------------");
        System.out.print("Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("-------------------------");
            switch (pilih) {
                case 1:
                    // System.out.println("- Pencarian Game -");
                    // System.out.print("Masukkan Nama Game : ");
                    // String namaGame = input.nextLine();
                    // NodeGames game = controllerGame.searchGames(namaGame);
                    // if (game != null) {
                    //     System.out.println("Nama Game: " + game.getNamaGame());
                    //     System.out.println("Nama Currency: " + game.getNamaCurrency());
                    //     System.out.println("Items:");
                    //     for (Item item : game.getItem()) {
                    //         System.out.println("  - Nama Item: " + item.getNamaItem());
                    //         System.out.println("    Harga: " + item.getHarga());
                    //     }
                    // } else {
                    //     System.out.println("Game Tidak Ditemukan!");
                    // }
                    break;
                case 2:
                    System.out.println("- Menampilkan Data Game -");
                    for (NodeGames gameList : controllerGame.viewAllGames()) {
                        System.out.println("Nama Game: " + gameList.getNamaGame());
                        System.out.println("Nama Currency: " + gameList.getNamaCurrency());
                            System.out.println("==============================");
                        }
                        System.out.println("- Pilih Game -");
                        System.out.print("Masukkan Nama Game : ");
                        String namaGame = input.nextLine();
                        NodeGames game = controllerGame.searchGames(namaGame);
                        if (game != null) {
                            System.out.println("Items:");
                            for (Item item : game.getItem()) {
                                System.out.println("  - Nama Item: " + item.getNamaItem());
                                System.out.println("    Harga: " + item.getHarga());
                            }
                        } else {
                            System.out.println("Game Tidak Ditemukan!");
                        }
                        controllerUser.Pembelian(controllerGame.searchGames(namaGame).getItem(), Email);
                    break;
                case 3:
                    System.out.println("- Info Akun -");
                    System.out.println("Email : " + controllerUser.searchUser(Email).getEmail());;
                    System.out.println("Password : " + controllerUser.searchUser(Email).getPassword());
                    System.out.println("PIN : " + controllerUser.searchUser(Email).getPin());
                    break;
                case 4:
                    System.out.println("- Update Akun -");
                    System.out.print("Masukkan Password Baru : "); String newPass = input.nextLine(); 
                    System.out.print("Masukkan PIN Baru : "); int newPIN = input.nextInt();
                    controllerUser.updateUser(Email, newPass, newPIN);
                    break;
                case 5:
                    ArrayList<NodeHarga> hargaList = controllerHarga.viewAllHarga();
                    for (NodeHarga nodeHarga : hargaList) {
                        System.out.println(nodeHarga.getId() + ". " + String.format(formatRupiah, "Rp. %,.2f", nodeHarga.getHarga()));
                    }
                    System.out.print("Pilihan Anda : "); int pilihSaldo = input.nextInt();
                    controllerUser.isiSaldo(Email, pilihSaldo);
                    break;
                case 6:
                    System.out.println(" - Cek Saldo -");
                    System.out.println("Sisa Saldo anda tersisa : " + String.format(formatRupiah, "Rp. %,.2f", controllerUser.searchUser(Email).getSaldo()));
                    break;
                case 7:
                    //Fitur Histori Masih Belum Dibuat!!! By Nopal
                    break;
                case 8:
                    System.out.println(" - Anda Telah Logout - ");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}