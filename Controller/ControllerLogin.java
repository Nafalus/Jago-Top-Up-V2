package Controller;

import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import ModelGSON.ModelGSON;
import Node.NodeAdmin;
import Node.NodeUser;
import View.ViewAdmin;
import View.ViewUser;

public class ControllerLogin {
    private ViewAdmin viewAdmin;
    private ViewUser viewUser;

    public ControllerLogin(ViewAdmin viewAdmin, ViewUser viewUser) {
        this.viewAdmin = viewAdmin;
        this.viewUser = viewUser;
    }

    public void ValidasiLogin(String email, String password) {
        ArrayList<NodeUser> listUsers = new ModelGSON<NodeUser>("Database/DatabaseUser.json").readFromFile(new TypeToken<ArrayList<NodeUser>>() {}.getType());
        if (listUsers != null) {
            for (NodeUser user : listUsers) {
                if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                    viewUser.MenuUser(email);
                    return;
                }
            }
        }

        ArrayList<NodeAdmin> listAdmins = new ModelGSON<NodeAdmin>("Database/DatabaseAdmin.json").readFromFile(new TypeToken<ArrayList<NodeAdmin>>() {}.getType());
        if (listAdmins != null) {
            for (NodeAdmin admin : listAdmins) {
                if (admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equalsIgnoreCase(password)) {
                    viewAdmin.MenuAdmin();
                    return;
                }
            }
        }
        System.out.println("Email atau Password Salah");
    }
}
