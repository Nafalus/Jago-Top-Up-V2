import Model.ModelUser;
import Model.ModelAdmin;
import Model.ModelGames;
import Controller.ControllerUser;

import java.util.Scanner;

import Controller.ControllerAdmin;
import Controller.ControllerGame;
import Controller.ControllerLogin;
import View.ViewAdmin;
import View.ViewDaftar;
import View.ViewLogin;
import View.ViewUser;

public class Main {
    public static void main(String[] args) {
        ModelUser modeluser = new ModelUser();
        ModelGames modelGames = new ModelGames();
        ModelAdmin modelAdmin = new ModelAdmin();
        ControllerUser controllerUser = new ControllerUser(modeluser);
        ControllerGame controllerGame = new ControllerGame(modelGames);
        ViewUser viewuser = new ViewUser(controllerUser, controllerGame);
        ViewAdmin viewAdmin = new ViewAdmin(controllerUser, controllerGame);
        ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin);
        ControllerLogin controllerLogin = new ControllerLogin(viewAdmin, viewuser);
        ViewLogin viewLogin = new ViewLogin(controllerUser, controllerAdmin, controllerLogin);
        ViewDaftar viewDaftar = new ViewDaftar(controllerUser);


        Scanner input = new Scanner(System.in);
        int pilih;
        x : while(true){
        System.out.println("1. Daftar");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Masukkan Pilihan : ");
        pilih = input.nextInt();
            switch (pilih) {
                case 1:
                viewDaftar.Daftar();
                    break;
                case 2:
                viewLogin.Login();
                    break;
                case 3:
                    System.out.println("Program Berakhir");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
        input.close();
    }
}