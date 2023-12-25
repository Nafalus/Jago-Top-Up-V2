package Controller;

import Model.ModelUser;
import Node.NodeUser;

import java.util.ArrayList;

public class ControllerUser {
    private ModelUser modelUser;

    public ControllerUser(ModelUser modelUser) {
        this.modelUser = modelUser;
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
        switch (opsiSaldo) {
            case 1:
                pengguna.tambahSaldo(5000);
                break;
            case 2:
                pengguna.tambahSaldo(10000);
                break;
            case 3:
                pengguna.tambahSaldo(15000);
                break;
            case 4:
                pengguna.tambahSaldo(20000);
                break;
            case 5:
                pengguna.tambahSaldo(30000);
                break;
            case 6:
                pengguna.tambahSaldo(50000);
                break;
            case 7:
                pengguna.tambahSaldo(100000);
                break;
            case 8:
                pengguna.tambahSaldo(200000);
                break;
            default:
                System.out.println("INVALID INPUT!");
                break;
        }
        // pengguna.tambahSaldo(0);
        modelUser.updateUser(Email, pengguna);
    }
}
