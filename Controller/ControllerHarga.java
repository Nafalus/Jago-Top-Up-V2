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

    public void updateharga (int id, double Harga) {
        NodeHarga harga = modelHarga.searchHarga(id);
        if (harga == null){
            System.out.println("Harga tidak ditemukan");
        }
        else {
            harga.setHarga(Harga);
            modelHarga.updateHarga(harga);
        }
    }

    public void deleteharga(int id){
        NodeHarga harga = modelHarga.searchHarga(id);
        if (harga == null) {
            System.out.println("List Harga Tidak Ditemukan");
        } else {
            modelHarga.deleteHarga(harga);
            ArrayList<NodeHarga> hargaList = modelHarga.getHargaList();
            ArrayList<NodeHarga> replaceList = new ArrayList<NodeHarga>();
            int i = 1;
            for (NodeHarga nodeHarga : hargaList) {
                nodeHarga.setId(i);
                replaceList.add(nodeHarga);
                i++;
            }
            modelHarga.replaceList(replaceList);
        }
    }
}