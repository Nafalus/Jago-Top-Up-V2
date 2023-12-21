package Controller;


import Model.ModelAdmin;
import Node.NodeAdmin;

public class ControllerAdmin {
        private ModelAdmin modelAdmin;

    public ControllerAdmin(ModelAdmin modelAdmin) {
        this.modelAdmin = modelAdmin;
    }

    // public ArrayList<NodeGames> viewAllAdmin() {
    //     return modelAdmin.getAllGames();
    // }

    public void insertAdmin(String email,String password) {
        modelAdmin.addAdmin(new NodeAdmin(email, password));
    }

}
