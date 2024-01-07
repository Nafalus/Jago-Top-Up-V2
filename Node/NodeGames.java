package Node;

import java.util.ArrayList;

public class NodeGames {
    private String namaGame;
    private String namaCurrency;
    private ArrayList<Item> items;

    public NodeGames(String namaGame, String namaCurrency) {
        this.namaGame = namaGame;
        this.namaCurrency = namaCurrency;
        this.items = new ArrayList<>();
    }

    public void viewGame() {
        System.out.println("Nama Game: " + this.namaGame);
        System.out.println("Nama Currency: " + this.namaCurrency);
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("  - Nama Item: " + item.namaItem);
            System.out.println("    Harga: " + item.harga);
        }
    }

    public void setNamaGame(String namaGame) {
        this.namaGame = namaGame;
    }

    public String getNamaGame() {
        return this.namaGame;
    }

    public void setNamaCurrency(String namaCurrency) {
        this.namaCurrency = namaCurrency;
    }

    public String getNamaCurrency() {
        return this.namaCurrency;
    }

    public ArrayList<Item> getAllItem(){
        return this.items;
    }

    public void addItem(int id, String namaItem, double harga) {
        items.add(new Item(id, namaItem, harga));
    }

    public void updateItem(ArrayList<Item> listItem){
        this.items = listItem;
    }

    public void setItem (ArrayList<Item> listItem){
        this.items = listItem;
    }

    public static class Item {
        private int id;
        private String namaItem;
        private double harga;

        public Item(int id, String namaItem, double harga) {
            this.id = id;
            this.namaItem = namaItem;
            this.harga = harga;
        }

        public void setId(int id){
            this.id = id;
        }
    
        public int getId(){
            return this.id;
        }

        public void setNamaItem(String namaItem){
            this.namaItem = namaItem;
        }

        public String getNamaItem(){
            return this.namaItem;
        }

        public void setHarga(double harga){
            this.harga = harga;
        }

        public double getHarga(){
            return this.harga;
        }
    }
}