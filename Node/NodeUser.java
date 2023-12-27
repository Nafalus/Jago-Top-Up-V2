package Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import Interface.Node;

public class NodeUser implements Node{
    private String email;
    private String password;
    private int PIN;
    private double Saldo;

    public NodeUser(String email, String password, int PIN, double Saldo) {
        this.email = email;
        this.password = password;
        this.PIN = PIN;
        this.Saldo = Saldo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    // public void viewUser(){
    //     System.out.println("Email : " + getEmail());
    //     System.out.println("Password : " + getPassword());
    //     System.out.println("Pin  : " + this.PIN);
    //     System.out.println("Saldo : " + this.Saldo);
    // }

    public void setPIN(int PIN){
        this.PIN = PIN;
    }

    public int getPin(){
        return this.PIN;
    }

    public void tambahSaldo(double Nominal){
        this.Saldo = this.Saldo + Nominal;
    }

    public void ambilsaldo(double Nominal){
        this.Saldo = this.Saldo - Nominal;
    }

    public double getSaldo(){
        return this.Saldo;
    }

    //Sementara(Masih Bisa Berubah)!!!
    public static class Histori {
        private String Tanggal;
        private String namaGame;
        private String namaItem;
        private double Nominal;

        public Histori (String namaGame, String namaItem, double Nominal) {
            this.Tanggal = setTanggal();
            this.namaGame = namaGame;
            this.namaItem = namaItem;
            this.Nominal = Nominal;
        }

        private String setTanggal () {
            LocalDateTime currentDatetime = LocalDateTime.now();
            DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
            return currentDatetime.format(Format);
        }

        public String getTanggal(){
            return this.Tanggal;
        }

        public String getNamaGame(){
            return this.namaGame;
        }

        public String getNamaitem(){
            return this.namaItem;
        }

        public double Nominal(){
            return this.Nominal;
        }
    }
}