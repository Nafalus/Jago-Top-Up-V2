package Controller;

import Model.ModelUser;
import Node.NodeHarga;
import Node.NodeUser;
import Node.NodeGames.Item;
import Node.NodeUser.Histori;

import java.util.ArrayList;

public class ControllerUser {
    private ModelUser modelUser;
    private ControllerHarga controllerHarga;

    public ControllerUser(ModelUser modelUser, ControllerHarga controllerHarga) {
        this.modelUser = modelUser;
        this.controllerHarga = controllerHarga;
    }

    public ArrayList<NodeUser> viewAllUser() {
        return modelUser.getAllUser();
    }

    public void insertUser(String email, String password,String pin,double saldo) {
        modelUser.addUser(new NodeUser(email, password, pin, saldo));
    }

    public void updateUser (String Email, String newPass, String newPIN){
        NodeUser pengguna = modelUser.searchUser(Email);
        if (pengguna == null){
            System.out.println("Pengguna tidak ditemukan");
        }else{
            pengguna.setPassword(newPass);
            pengguna.setPIN(newPIN);
            modelUser.updateUser(pengguna);
        }
    }

    public void deleteUser (String username){
        NodeUser pengguna = modelUser.searchUser(username);
        if (pengguna == null) {
            System.out.println("Pengguna tidak ditemukan");
        }else{
            modelUser.deleteUser(pengguna);;
        }
    }

    public NodeUser searchUser(String username){
        return modelUser.searchUser(username);
    }

    public boolean cekHarga (int id, ArrayList<Item> listItem, String Email){
        NodeUser pengguna = modelUser.searchUser(Email);
        double hargaItem = 0;
        for (Item item : listItem) {
            if (id == item.getId()) {
                hargaItem = item.getHarga();
            }
        }
        if (pengguna.getSaldo() >= hargaItem) {
            return true;
        } else {
            return false;
        }
    }
    
    public void isiSaldo (String Email, int opsiSaldo) {
        NodeUser pengguna = modelUser.searchUser(Email);
        ArrayList<NodeHarga> hargaList = controllerHarga.viewAllHarga();
        try {
            pengguna.tambahSaldo(hargaList.get(opsiSaldo - 1).getHarga());
            pengguna.addHistrori(createHistori(true, "Isi Saldo", "IsiSaldo", hargaList.get(opsiSaldo - 1).getHarga()));
            modelUser.updateUser(pengguna);
        } catch (Exception e) {
            System.out.println("Harga Tidak Ditemukkan!!!");
        }
    }
    
    public void Pembelian (int id, String namaGame ,ArrayList<Item> listItem, String PIN, String Email){
        NodeUser pengguna = modelUser.searchUser(Email);
        double hargaItem = 0;
        String namaItem = null;
        if (pengguna.getPin().equalsIgnoreCase(PIN)) {
            for (Item item : listItem) {
                if (id == item.getId()) {
                    hargaItem = item.getHarga();
                    namaItem = item.getNamaItem();
                }
            }
            System.out.println(" - Pembelian Item Game Berhasil -");
            pengguna.ambilsaldo(hargaItem);
            pengguna.addHistrori(createHistori(false, namaGame ,namaItem, hargaItem));
        } else {
            System.out.println(" - PIN yg anda Masukkan Tidak Valid -");
        }
        modelUser.updateUser(pengguna);
    }

    public Histori createHistori (Boolean tipe, String namaGame,String namaItem, double Nominal) {
        Histori histori = new Histori (tipe, namaGame, namaItem, Nominal);
        return histori;
    }
}