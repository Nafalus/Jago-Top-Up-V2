package View;

import Controller.ControllerUser;
import Controller.ControllerGame;
import Node.NodeUser;

import java.util.Scanner;

public class ViewUser {
    private ControllerUser controllerUser;

    public ViewUser(ControllerUser controllerUser){
        this.controllerUser = controllerUser;
    }

    public void MenuUser(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
        System.out.println("-------------------------");
        System.out.println("|\tMenu User\t|");
        System.out.println("-------------------------");
        System.out.println("1. Cari Game\t\t|");
        System.out.println("2. Lihat Game\t\t|");
        System.out.println("3. Update Akun\t\t|");
        System.out.println("4. Isi Saldo\t\t|");
        System.out.println("5. Lihat History\t\t|");
        System.out.println("6. Kembali\t\t|");
        System.out.println("-------------------------");
        System.out.print("Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("-------------------------");
            switch (pilih) {
                case 1:
                    insertUser();
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    searchUser();
                    break;
                case 6:
                    System.out.println("Program berakhir");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }

    public void viewUser(){
        System.out.println("- Menampilkan Data User -");
        for(NodeUser user : controllerUser.viewAllUser()){
            System.out.println("Username : "+user.email);
            System.out.println("Password : "+user.password);
            System.out.println("Pin : "+user.pin);
            System.out.println("Saldo  : "+user.saldo);
            System.out.println("==============================");
        }
    }

    public void insertUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Tambah User -");
        System.out.print("Masukkan Email : ");
        String email = input.nextLine();
        System.out.print("Masukkan Password : ");
        String password = input.nextLine();
        System.out.print("Masukkan Pin : ");
        int pin = input.nextInt();
        double saldo = 0;
        System.out.println("Berhasil Mendaftar");
        controllerUser.insertUser(email, password, pin, saldo);
    }

    public void updateUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Update User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        NodeUser user = controllerUser.searchUser(username);
        if(user == null){
            System.out.println("PENGGUNA TIDAK DITEMUKAN!");
        }else{
            System.out.println("Ubah No Telp : ");
            String newTelp = input.nextLine();
            controllerUser.updateUser(username, newTelp); 
        }
    }

    public void deleteUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Hapus User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        NodeUser user = controllerUser.searchUser(username);
        if(user == null){
            System.out.println("PENGGUNA TIDAK DITEMUKAN!");
        }else{
            System.out.println("- User Berhasil Di Hapus -");
            controllerUser.deleteUser(username);;
        }
    }

    public void searchUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Pencarian User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        NodeUser user = controllerUser.searchUser(username);
        if (user == null) {
            System.out.println("PENGGUNA TIDAK DITEMUKAN!");
        }else{
            System.out.println("- User Ditemukan -");
            System.out.println("Username : "+user.email);
            System.out.println("Password : "+user.password);
            System.out.println("Nama : "+user.pin);
            System.out.println("NIK  : "+user.saldo);
        }
    }
}