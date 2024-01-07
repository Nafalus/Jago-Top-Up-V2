package View;

import Controller.*;
import Node.NodeGames;
import Node.NodeGames.Item;
import Node.NodeUser.Histori;
import Node.NodeHarga;
import Node.NodeUser;
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
        System.out.println("2. Info Akun\t\t|");
        System.out.println("3. Update Akun\t\t|");
        System.out.println("4. Isi Saldo\t\t|");
        System.out.println("5. Cek Saldo\t\t|");
        System.out.println("6. Histori Transaksi\t|");
        System.out.println("7. Logout\t\t|");
        System.out.println("-------------------------");
        System.out.print("Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("-------------------------");
            switch (pilih) {
                case 1:
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
                        System.out.println("- Menampilkan Item Game -");
                        if (game != null) {
                            System.out.println("Items:");
                            for (Item item : game.getAllItem()) {
                                System.out.println(item.getId() + ". " + item.getNamaItem());
                                System.out.println("   Harga: " + item.getHarga());
                            }
                        } else {
                            System.out.println("Game Tidak Ditemukan!");
                            break;
                        }
                        System.out.println("==============================");
                        System.out.println(" - Pilih Item -");
                        System.out.print("Masukkan Pilihan : "); int id = input.nextInt();
                        input.nextLine();
                        if (controllerUser.cekHarga(id, game.getAllItem(), Email)) {
                            System.out.println(" - Masukkan PIN Anda -"); String PIN = input.nextLine();
                            controllerUser.Pembelian(id, namaGame ,game.getAllItem(), PIN, Email);
                        } else {
                            System.out.println(" - Saldo Anda TIdak Cukup, Silahkan Lakukan Pengisian Saldo -");
                        }
                    break;
                case 2:
                    System.out.println("- Info Akun -");
                    System.out.println("Email : " + controllerUser.searchUser(Email).getEmail());;
                    System.out.println("Password : " + controllerUser.searchUser(Email).getPassword());
                    System.out.println("PIN : " + controllerUser.searchUser(Email).getPin());
                    break;
                case 3:
                    System.out.println("- Update Akun -");
                    System.out.print("Masukkan Password Baru : "); String newPass = input.nextLine(); 
                    System.out.print("Masukkan PIN Baru : "); String newPIN = input.nextLine();
                    controllerUser.updateUser(Email, newPass, newPIN);
                    break;
                case 4:
                    ArrayList<NodeHarga> hargaList = controllerHarga.viewAllHarga();
                    for (NodeHarga nodeHarga : hargaList) {
                        System.out.println(nodeHarga.getId() + ". " + String.format(formatRupiah, "Rp. %,.2f", nodeHarga.getHarga()));
                    }
                    System.out.print("Pilihan Anda : "); int pilihSaldo = input.nextInt();
                    controllerUser.isiSaldo(Email, pilihSaldo);
                    break;
                case 5:
                    System.out.println(" - Cek Saldo -");
                    System.out.println("Sisa Saldo anda tersisa : " + String.format(formatRupiah, "Rp. %,.2f", controllerUser.searchUser(Email).getSaldo()));
                    break;
                case 6:
                    System.out.println(" - Histori Transaksi -");
                    System.out.println("==============================");
                    NodeUser pengguna = controllerUser.searchUser(Email);
                    for (Histori histori : pengguna.getAllHistori()) {
                        if (histori.getTipe()) {
                            System.out.println(" - Anda Melakukan Pengisian Saldo -");
                            System.out.println("Tanggal Transaksi : " + histori.getTanggal());
                            System.out.println("Total Saldo yg Di isi : " + histori.getNominal());
                            System.out.println("==============================");
                        } else {
                            System.out.println(" - Anda Melakukan Pembelian Item Game -");
                            System.out.println("Tanggal Transaksi : " + histori.getTanggal());
                            System.out.println("Item Bernama : " + histori.getNamaitem() + " Pada Game " + histori.getNamaGame());
                            System.out.println("Total Pembelian : " + histori.getNominal());
                            System.out.println("==============================");
                        }
                    }
                    break;
                case 7:
                    System.out.println(" - Anda Telah Logout - ");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}