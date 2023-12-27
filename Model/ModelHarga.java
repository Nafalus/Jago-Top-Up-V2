package Model;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import ModelGSON.ModelGSON;
import Node.NodeHarga;

//sementara cuma ini by Nopal
public class ModelHarga {
    ArrayList<NodeHarga> listHarga;
    ModelGSON<NodeHarga> modelGSONHarga;

    public ModelHarga(){
        listHarga = new ArrayList<NodeHarga>();
        modelGSONHarga = new ModelGSON<>("Database/DatabaseHarga.json");
        loadData();
    }

    public void addHarga(NodeHarga Harga){
        listHarga.add(Harga);
        commitData();
    }

    public NodeHarga searchHarga(int id){
        NodeHarga HargaKosong = null;
        for (NodeHarga harga : listHarga) {
            if (harga.getId() == id){
                return harga;
            }
        }
        return HargaKosong;
    }

    public ArrayList<NodeHarga> getAllHarga(){
        return listHarga;
    }

    public void updateHarga(NodeHarga harga){
        listHarga.contains(harga);
        commitData();
    }

    public void deleteHarga(NodeHarga harga){
        listHarga.remove(harga);
        commitData();
    }

    public int getLastId(){
        if (listHarga != null) {
            int id = 0;
            for (NodeHarga harga : listHarga) {
                id = harga.getId();
            }
            return id;
        }
        else {
            return 0;
        }
    }

    public void replaceList(ArrayList<NodeHarga> replaceHarga){
        this.listHarga = replaceHarga;
    }

    private void loadData(){
        listHarga = modelGSONHarga.readFromFile(new TypeToken<ArrayList<NodeHarga>>(){}.getType());
    }

    private void commitData(){
        modelGSONHarga.WriteToFile(listHarga);
    }
}
