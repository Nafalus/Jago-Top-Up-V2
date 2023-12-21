import Model.ModelUser;
import Model.ModelAdmin;
import Model.ModelGames;
import Controller.ControllerUser;

import java.util.Scanner;

import Controller.ControllerAdmin;
import Controller.ControllerGame;
import Controller.ControllerLogin;
import View.ViewAdmin;
import View.ViewLogin;
import View.ViewUser;

public class Main {
    public static void main(String[] args) {
        ModelUser modeluser = new ModelUser();
        ModelGames modelGames = new ModelGames();
        ModelAdmin modelAdmin = new ModelAdmin();
        ControllerUser controllerUser = new ControllerUser(modeluser);
        ViewUser viewuser = new ViewUser(controllerUser);
        ControllerGame controllerGame = new ControllerGame(modelGames);
        ViewAdmin viewAdmin = new ViewAdmin(controllerUser, controllerGame);
        ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin);
        ControllerLogin controllerLogin = new ControllerLogin(viewAdmin, viewuser);
        ViewLogin viewLogin = new ViewLogin(controllerUser, controllerAdmin, controllerLogin);


        Scanner input = new Scanner(System.in);
        int pilih;
        x : while(true){
        System.out.println("1. Daftar woi");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Masukkan Pilihan : ");
        pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    input.nextLine();
                    System.out.println("Masukkan Email : ");
                    String email = input.nextLine();
                    System.out.println("Masukkan Password : ");
                    String password = input.nextLine();
                    System.out.println("Masukkan Pin : ");
                    int pin = input.nextInt();
                    double saldo = 0;
                    controllerUser.insertUser(email, password,pin,saldo);
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Masukkan Email : ");
                    email = input.nextLine();
                    System.out.println("Masukkan Password : ");
                    password = input.nextLine();
                    controllerLogin.ValidasiLogin(email, password);
                    break;
                case 3:
                    System.out.println("Program Berakhir");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}