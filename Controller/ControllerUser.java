package Controller;

import Model.ModelUser;
import Node.NodeUser;

import java.util.ArrayList;

public class ControllerUser {
    private ModelUser user;

    public ControllerUser(ModelUser user) {
        this.user = user;
    }

    public ArrayList<NodeUser> viewAllUser() {
        return user.getAllUser();
    }

    public void insertUser(String email, String password,int pin,double saldo) {
        user.addUser(new NodeUser(email, password, pin, saldo));
    }

    public void updateUser (String username, String newPass){
        NodeUser pengguna = user.searchUser(username);
        if (pengguna == null){
            System.out.println("Pengguna tidak ditemukan");
        }else{
            pengguna.password = newPass;
            user.updateUser(username, pengguna);
        }
    }

    public void deleteUser (String username){
        NodeUser pengguna = user.searchUser(username);
        if (pengguna == null) {
            System.out.println("Pengguna tidak ditemukan");
        }else{
            user.deleteUser(pengguna);;
        }
    }

    public NodeUser searchUser(String username){
        return user.searchUser(username);
    }
}
