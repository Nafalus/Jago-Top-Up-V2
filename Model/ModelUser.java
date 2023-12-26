package Model;

import java.util.ArrayList;
import ModelGSON.ModelGSON;
import Node.NodeUser;

import com.google.gson.reflect.TypeToken;
public class ModelUser {
    ArrayList<NodeUser> ListUser;
    ModelGSON<NodeUser> modelGSONUser;

    public ModelUser(){
        ListUser = new ArrayList<NodeUser>();
        modelGSONUser = new ModelGSON<>("Database/DatabaseUser.json");
        loadData();
    }

    public void addUser(NodeUser User) {
        ListUser.add(User);
        commitData();
    }

    public NodeUser searchUser(String email){
        NodeUser user = null;
        for (NodeUser akun : ListUser){
            if (akun.getEmail().equalsIgnoreCase(email)){
                return akun;
            }
        }
        return user;
    }

    public ArrayList<NodeUser> getAllUser(){
        return ListUser;
    }

    public void updateUser(String username, NodeUser user){
        ListUser.contains(user);
        commitData();
    }

    public void deleteUser(NodeUser user){
        ListUser.remove(user);
        commitData();
    }

    private void loadData(){
        ListUser = modelGSONUser.readFromFile(new TypeToken<ArrayList<NodeUser>>(){}.getType());
    }

    public void commitData(){
        modelGSONUser.WriteToFile(ListUser);
    }
}