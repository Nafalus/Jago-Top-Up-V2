package Model;

import java.util.ArrayList;

import ModelGSON.ModelGSON;
import Node.NodeGames;


import com.google.gson.reflect.TypeToken;
public class ModelGames {
    ArrayList<NodeGames> listGame;
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

    public ArrayList<NodeGames> getAllGames() {
        return listGame;
    }

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