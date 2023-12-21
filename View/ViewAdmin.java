package View;

import java.util.Scanner;
import Controller.ControllerGame;
import Controller.ControllerUser;
import Node.NodeGames;
import Node.NodeUser;

public class ViewAdmin {
    private ControllerGame controllerGame;
    private ControllerUser controllerUser;

    public ViewAdmin(ControllerUser controllerUser, ControllerGame controllerGame) {
        this.controllerUser = controllerUser;
        this.controllerGame = controllerGame;
    }

    public void MenuAdmin() {
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true) {
            System.out.println("-------------------------");
            System.out.println("|\tMenu Admin\t|");
            System.out.println("-------------------------");
            System.out.println("|1. Tambah Game\t\t|");
            System.out.println("|2. Lihat Game\t\t|");
            System.out.println("|3. Tambah Item Game\t|");
            System.out.println("|4. Update Game\t\t|");
            System.out.println("|5. Hapus Game\t\t|");
            System.out.println("|6. Cari Game\t\t|");
            System.out.println("|7. Lihat Semua User\t|");
            System.out.println("|8. Kembali\t\t|");
            System.out.println("-------------------------");
            System.out.print("Masukkan Pilihan : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("-------------------------");
            switch (pilih) {
                case 1:
                    System.out.println("- Tambah Game -");
                    System.out.print("Masukkan Nama Game : ");
                    String namaGame = input.nextLine();
                    System.out.print("Masukkan Nama Currency : ");
                    String namaCurrency = input.nextLine();
                    controllerGame.insertGame(namaGame, namaCurrency);
                    System.out.println("Berhasil Menambahkan Game");
                    break;
                case 2:
                    System.out.println("- Menampilkan Data Game -");
                    for (NodeGames game : controllerGame.viewAllGames()) {
                        game.viewGame();
                        System.out.println("==============================");
                    }
                    break;
                case 3:
                    System.out.println("- Tambah Item Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    System.out.print("Masukkan Nama Item : ");
                    String namaItem = input.nextLine();
                    System.out.print("Masukkan Harga Item : ");
                    double harga = input.nextDouble();
                    input.nextLine();
                    controllerGame.insertItem(namaGame, namaItem, harga);
                    break;
                case 4:
                    System.out.println("- Update Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    NodeGames game = controllerGame.searchGames(namaGame);
                    if (game != null) {
                        System.out.println("Ubah Nama Currency : ");
                        String newCurrency = input.nextLine();
                        controllerGame.updateGames(namaGame, newCurrency);
                    } else {
                        System.out.println("Game Tidak Ditemukan!");
                    }
                    break;
                case 5:
                    System.out.println("- Hapus Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    controllerGame.deleteGame(namaGame);
                    break;
                case 6:
                    System.out.println("- Pencarian Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    game = controllerGame.searchGames(namaGame);
                    if (game != null) {
                        game.viewGame();
                    } else {
                        System.out.println("Game Tidak Ditemukan!");
                    }
                    break;
                case 7:
                    System.out.println("- Menampilkan Data User -");
                    for (NodeUser user : controllerUser.viewAllUser()) {
                        System.out.println("Username : " + user.email);
                        System.out.println("Password : " + user.password);
                        System.out.println("Pin\t : " + user.pin);
                        System.out.println("Saldo\t : " + user.saldo);
                        System.out.println("==============================");
                    }
                    break;
                case 8:
                    System.out.println("Kembali");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}
