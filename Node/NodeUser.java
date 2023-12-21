package Node;

public class NodeUser extends NodeAdmin{
    public int pin;
    public double saldo;

    public NodeUser(String email, String password,int pin,double saldo) {
        super(email, password);
        this.pin = pin;
        this.saldo = saldo;
       
    }

    public void viewUser(){
        System.out.println("Email : " + this.email);
        System.out.println("Password : " + this.password);
        System.out.println("Pin  : " + this.pin);
        System.out.println("Saldo : " + this.saldo);
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}