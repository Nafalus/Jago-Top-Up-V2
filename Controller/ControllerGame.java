// ControllerGame.java
package Controller;

import Model.ModelGames;
import Node.NodeGames;
import Node.NodeGames.Item;

import java.util.ArrayList;

public class ControllerGame {
    private ModelGames modelGames;

    public ControllerGame(ModelGames modelGames) {
        this.modelGames = modelGames;
    }

    public ArrayList<NodeGames> viewAllGames() {
        return modelGames.getAllGames();
    }

    public void insertGame(String namaGame, String namaCurrency) {
        NodeGames game = new NodeGames(namaGame, namaCurrency);
        modelGames.addGames(game);
    }

    public void insertItem(String namaGame, String namaItem, double harga) {
        NodeGames game = modelGames.searchGame(namaGame);
        if (game != null) {
            game.addItem(modelGames.getLastIdItem(namaGame) + 1, namaItem, harga);
            modelGames.updateGame(namaGame, game);
        } else {
            System.out.println("Game tidak ditemukan!");
        }
    }

    public void updateItem (String namaGame, String prevNamaItem ,String newNamaItem , double harga) {
        NodeGames game = modelGames.searchGame(namaGame);
        if (game != null) {
            ArrayList<Item> listItem = game.getAllItem();
            Item item = modelGames.searchItem(prevNamaItem, listItem);
            if (item != null){
                item.setNamaItem(newNamaItem);
                item.setHarga(harga);
                listItem.contains(item);
            }
            game.updateItem(listItem);
            modelGames.updateGame(namaGame, game);
        } else {
            System.out.println("Game Tidak Ditemukan!!!");
        }
    }

    public void updateGames(String namaGame, String newCurrency) {
        NodeGames game = modelGames.searchGame(namaGame);
        if (game != null) {
            game.setNamaCurrency(newCurrency);
            modelGames.updateGame(namaGame, game);
        } else {
            System.out.println("Game tidak ditemukan!");
        }
    }

    public void deleteGame(String namaGame) {
        NodeGames game = modelGames.searchGame(namaGame);
        if (game != null) {
            modelGames.deleteGame(game);
        } else {
            System.out.println("Game tidak ditemukan!");
        }
    }

    public NodeGames searchGames(String namaGame) {
        return modelGames.searchGame(namaGame);
    }
}
