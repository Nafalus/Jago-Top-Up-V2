package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.*;
import Node.*;
import Node.NodeGames.Item;

public class ViewAdmin {
    private ControllerGame controllerGame;
    private ControllerUser controllerUser;
    private ControllerHarga controllerHarga;

    public ViewAdmin(ControllerUser controllerUser, ControllerGame controllerGame, ControllerHarga controllerHarga) {
        this.controllerUser = controllerUser;
        this.controllerGame = controllerGame;
        this.controllerHarga = controllerHarga;
    }

    public void MenuAdmin() {
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true) {
            System.out.println("--------------------------------");
            System.out.println("|\tMenu Admin\t\t|");
            System.out.println("--------------------------------");
            System.out.println("|1. Tambah Game\t\t\t|");
            System.out.println("|2. Lihat Game\t\t\t|");
            System.out.println("|3. Tambah Item Game\t\t|");
            System.out.println("|4. Update Item Game\t\t|");
            System.out.println("|5. Update Game\t\t\t|");
            System.out.println("|6. Delete Game\t\t\t|");
            System.out.println("|7. Cari Game\t\t\t|");
            System.out.println("|8. Lihat Semua User\t\t|");
            System.out.println("|9. Update User\t\t\t|");
            System.out.println("|10. Delete User\t\t|");
            System.out.println("|11. View Daftar Harga\t\t|");
            System.out.println("|12. Tambah Daftar Harga\t|");
            System.out.println("|13. Update List Harga\t\t|");
            System.out.println("|14. Delete List Harga\t\t|");
            System.out.println("|15. Logout\t\t\t|");
            System.out.println("--------------------------------");
            System.out.print("Masukkan Pilihan : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("--------------------------------");
            switch (pilih) {
                case 1:
                    System.out.println("- Tambah Game -");
                    System.out.print("Masukkan Nama Game : ");
                    String addNamaGame = input.nextLine();
                    System.out.print("Masukkan Nama Currency : ");
                    String namaCurrency = input.nextLine();
                    controllerGame.insertGame(addNamaGame, namaCurrency);
                    System.out.println("Berhasil Menambahkan Game");
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
                            for (Item item : game.getAllItem()) {
                                System.out.println(item.getId() + ". " + item.getNamaItem());
                                System.out.println("   Harga: " + item.getHarga());
                            }
                        } else {
                            System.out.println("Game Tidak Ditemukan!");
                        }
                    // System.out.println("- Menampilkan Data Game -");
                    // for (NodeGames game : controllerGame.viewAllGames()) {
                    //     game.viewGame();
                    //     System.out.println("==============================");
                    // }
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
                    System.out.println("- Update Item Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    System.out.print("Masukkan Nama Item Yang ingin Diubah : ");
                    String prevItemName = input.nextLine();
                    System.out.print("Masukkan Nama item Baru : ");
                    String newItemName = input.nextLine();
                    System.out.print("Masukkan Harga Baru : ");
                    double hargabaru = input.nextDouble();
                    controllerGame.updateItem(namaGame, prevItemName, newItemName, hargabaru);
                    break;
                case 5:
                    System.out.println("- Update Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    NodeGames gameUpdate = controllerGame.searchGames(namaGame);
                    if (gameUpdate != null) {
                        System.out.println("Ubah Nama Currency : ");
                        String newCurrency = input.nextLine();
                        controllerGame.updateGames(namaGame, newCurrency);
                    } else {
                        System.out.println("Game Tidak Ditemukan!");
                    }
                    break;
                case 6:
                    System.out.println("- Hapus Game -");
                    System.out.print("Masukkan Nama Game : ");
                    namaGame = input.nextLine();
                    controllerGame.deleteGame(namaGame);
                    break;
                case 7:
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
                case 8:
                    System.out.println("- Menampilkan Data User -");
                    for (NodeUser user : controllerUser.viewAllUser()) {
                        System.out.println("Email : " + user.getEmail());
                        System.out.println("Password : " + user.getPassword());
                        System.out.println("Pin\t : " + user.getPin());
                        System.out.println("Saldo\t : " + user.getSaldo());
                        System.out.println("==============================");
                    }
                    break;
                case 9:
                    System.out.println(" - Update User - ");
                    System.out.print("Masukkan Email : "); String Email = input.nextLine();
                    NodeUser user = controllerUser.searchUser(Email);
                    if (user == null) {
                        System.out.println("Pengguna Tidak Ditemukan");
                    }
                    else {
                        System.out.print("Masukkan Password Baru : "); String newPass = input.nextLine(); 
                        System.out.print("Masukkan PIN Baru : "); String newPIN = input.nextLine();
                        controllerUser.updateUser(Email, newPass, newPIN);
                    }
                    break;
                case 10:
                    System.out.println(" - Delete User - ");
                    System.out.print("Masukkan Email : ");
                    Email = input.nextLine();
                    controllerUser.deleteUser(Email);
                    break;
                case 11:
                    ArrayList<NodeHarga> viewList = controllerHarga.viewAllHarga();
                    for (NodeHarga nodeHarga : viewList) {
                        System.out.println(nodeHarga.getId() + ". " + "Rp. " +nodeHarga.getHarga());
                    }
                    break;
                case 12:
                    System.out.print("Masukkan Harga Baru : "); double addHarga = input.nextDouble();
                    controllerHarga.insertHarga(addHarga);
                    break;
                case 13:
                    ArrayList<NodeHarga> hargaList = controllerHarga.viewAllHarga();
                    for (NodeHarga nodeHarga : hargaList) {
                        System.out.println(nodeHarga.getId() + ". " + "Rp. " +nodeHarga.getHarga());
                    }
                    System.out.print("Masukkan Id : "); int newId = input.nextInt();
                    System.out.print("Masukkan Harga Baru : "); double newHarga = input.nextDouble();
                    controllerHarga.updateharga(newId, newHarga);
                    break;
                case 14:
                    System.out.println("Masukkan Id Harga :"); int id = input.nextInt();
                    controllerHarga.deleteharga(id);
                    break;
                case 15 :
                    System.out.println(" - Anda Telah Logout - ");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}
