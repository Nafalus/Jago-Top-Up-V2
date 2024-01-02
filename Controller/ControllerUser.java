package Controller;

import Model.ModelUser;
import Node.NodeHarga;
import Node.NodeUser;

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

    public void insertUser(String email, String password,int pin,double saldo) {
        modelUser.addUser(new NodeUser(email, password, pin, saldo));
    }

    public void updateUser (String Email, String newPass, int newPIN){
        NodeUser pengguna = modelUser.searchUser(Email);
        if (pengguna == null){
            System.out.println("Pengguna tidak ditemukan");
        }else{
            pengguna.setPassword(newPass);
            pengguna.setPIN(newPIN);
            modelUser.updateUser(Email, pengguna);
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

    public void isiSaldo (String Email, int opsiSaldo) {
        NodeUser pengguna = modelUser.searchUser(Email);
        ArrayList<NodeHarga> hargaList = controllerHarga.viewAllHarga();
        try {
            pengguna.tambahSaldo(hargaList.get(opsiSaldo - 1).getHarga());
            modelUser.updateUser(Email, pengguna);
        } catch (Exception e) {
            System.out.println("Harga Tidak Ditemukkan!!!");
        }
    }
}
