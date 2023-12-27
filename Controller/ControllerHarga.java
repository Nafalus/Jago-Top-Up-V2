package Controller;

import Model.ModelHarga;
import Node.NodeHarga;
import java.util.ArrayList;


//Belum Selesai(kurang update dan delete) by Nopal
public class ControllerHarga {
    private ModelHarga modelHarga;

    public ControllerHarga(ModelHarga modelHarga){
        this.modelHarga = modelHarga;
    }

    public ArrayList<NodeHarga> viewAllHarga(){
        return modelHarga.getAllHarga();
    }

    public void insertHarga(double harga){
        modelHarga.addHarga(new NodeHarga(modelHarga.getLastId()+1, harga));
    }

    public NodeHarga searchHarga(int id){
        return modelHarga.searchHarga(id);
    }

    public void deleteharga(int id){
        NodeHarga harga = modelHarga.searchHarga(id);
        if (harga == null) {
            System.out.println("List Harga Tidak Ditemukan");
        } else {
            modelHarga.deleteHarga(harga);
            ArrayList<NodeHarga> replaceHarga = new ArrayList<NodeHarga>();
            for (NodeHarga nodeHarga : modelHarga.getAllHarga()) {
                // replaceHarga.set
            }
        }
    }
}
