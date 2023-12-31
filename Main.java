import java.util.Scanner;
import Model.*;
import Controller.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        ModelUser modeluser = new ModelUser();
        ModelGames modelGames = new ModelGames();
        ModelAdmin modelAdmin = new ModelAdmin();
        ModelHarga modelHarga = new ModelHarga();
        ControllerGame controllerGame = new ControllerGame(modelGames);
        ControllerHarga controllerHarga = new ControllerHarga(modelHarga);
        ControllerUser controllerUser = new ControllerUser(modeluser, controllerHarga);
        ViewUser viewuser = new ViewUser(controllerUser, controllerGame, controllerHarga);
        ViewAdmin viewAdmin = new ViewAdmin(controllerUser, controllerGame, controllerHarga);
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