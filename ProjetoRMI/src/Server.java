import java.rmi.*;

public class Server {
  public static void main(String a[]) throws Exception {
    Classes obj = new Classes();
    Naming.rebind("ADD", obj);
    System.out.println("Server Started");
  }
}