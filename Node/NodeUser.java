package Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;

public class NodeUser extends NodeAdmin{
    private String PIN;
    private double Saldo;
    private ArrayList<Histori> listHistori;

    public NodeUser(String email, String password, String PIN, double Saldo) {
        super(email, password);
        this.PIN = PIN;
        this.Saldo = Saldo;
        this.listHistori = new ArrayList<>();
    }

    public void setPIN(String PIN){
        this.PIN = PIN;
    }

    public String getPin(){
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

    public void addHistrori (Histori histori){
        this.listHistori.add(histori);
    }

    public ArrayList<Histori> getAllHistori (){
        return this.listHistori;
    }

    //Sementara(Masih Bisa Berubah)!!!
    public static class Histori {
        private boolean tipe;
        private String Tanggal;
        private String namaGame;
        private String namaItem;
        private double Nominal;

        public Histori (boolean tipe, String namaGame, String namaItem, double Nominal) {
            this.tipe = tipe;
            this.Tanggal = setTanggal();
            this.namaGame = namaGame;
            this.namaItem = namaItem;
            this.Nominal = Nominal;
        }

        public Boolean getTipe(){
            return this.tipe;
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

        public double getNominal(){
            return this.Nominal;
        }
    }
}