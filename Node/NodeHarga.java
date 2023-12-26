package Node;

//done by Nopal
public class NodeHarga {
    private int id;
    private double harga;

    public NodeHarga(int id, double harga){
        this.id = id;
        this.harga = harga;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public double getHarga(){
        return this.harga;
    }
}
