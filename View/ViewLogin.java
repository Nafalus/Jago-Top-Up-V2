package View;

import java.util.Scanner;

import Controller.ControllerAdmin;
import Controller.ControllerLogin;
import Controller.ControllerUser;

public class ViewLogin {
    private ControllerAdmin controllerAdmin;
    private ControllerUser controllerUser;
    private ControllerLogin controllerLogin;

    public ViewLogin(ControllerUser controllerUser,ControllerAdmin controllerAdmin,ControllerLogin controllerLogin){
        this.controllerUser = controllerUser;
        this.controllerAdmin = controllerAdmin;
        this.controllerLogin = controllerLogin;
    }

    public void Login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Email : ");
        String email = input.nextLine();
        System.out.println("Masukkan Password : ");
        String password = input.nextLine();
        controllerLogin.ValidasiLogin(email, password);
    }
}
