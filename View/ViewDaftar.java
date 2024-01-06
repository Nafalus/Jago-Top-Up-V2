package View;

import Controller.ControllerUser;
import java.util.Scanner;

public class ViewDaftar {
    private ControllerUser controllerUser;

    public ViewDaftar (ControllerUser controllerUser) {
        this.controllerUser = controllerUser;
    }

    public void Daftar () {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Email Baru : ");
        String email = input.nextLine();
        System.out.println("Masukkan Password Baru : ");
        String password = input.nextLine();
        System.out.println("Masukkan PIN Baru : ");
        String Pin = input.nextLine();
        double Saldo = 0;
        controllerUser.insertUser(email, password, Pin, Saldo);
    }
}
