package Model;

import java.util.ArrayList;

import ModelGSON.ModelGSON;
import Node.NodeGames;
import Node.NodeGames.Item;

import com.google.gson.reflect.TypeToken;
public class ModelGames {
    ArrayList<NodeGames> listGame;
    ArrayList<Item> listItem;
    ModelGSON<NodeGames> modelGsonGame;

    public ModelGames() {
        listGame = new ArrayList<>();
        modelGsonGame = new ModelGSON<>("Database/DatabaseGames.json");
        loadData();
    }

    public void addGames(NodeGames Game) {
        listGame.add(Game);
        commitData();
    }

    public NodeGames searchGame(String namaGame) {
        NodeGames game = null;
        for (NodeGames Game : listGame) {
            if (Game.getNamaGame().equalsIgnoreCase(namaGame)) {
                return Game;
            }
        }
        return game;
    }

    public Item searchItem (String namaItem, ArrayList<Item> listItem){
        Item item = null;
        for (Item Item : listItem) {
            if (Item.getNamaItem().equalsIgnoreCase(namaItem)){
                return Item;
            }
        }
        return item;
    }

    public int getLastIdItem (String namaGame){
        NodeGames Game = searchGame(namaGame);
        if (Game.getAllItem() != null){
            int lastID=0;
            for (Item listItem : Game.getAllItem()) {
                lastID = listItem.getId();
            }
            return lastID;
        }
        else {
            return 0;
        }
    }

    public ArrayList<NodeGames> getAllGames() {
        return listGame;
    }

    // public ArrayList<Item> getAllItem(String namaGame){
    //     return this.listItem = listGame;
    // }

    public void updateGame(String namaGame, NodeGames Game) {
        listGame.contains(Game);
        commitData();
    }

    public void deleteGame(NodeGames Game) {
        listGame.remove(Game);
    }

    private void loadData() {
        listGame = modelGsonGame.readFromFile(new TypeToken<ArrayList<NodeGames>>() {}.getType());
    }

    public void commitData() {
        modelGsonGame.WriteToFile(listGame);
    }
}