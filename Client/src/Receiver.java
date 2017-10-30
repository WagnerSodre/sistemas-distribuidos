import java.io.InputStream;
import java.util.Scanner;

public class Receiver implements Runnable {
	private InputStream server;
	public Receiver(InputStream servidor) {
	  this.server = servidor;
	}

   public void run() {
	 // recebe mensagens do servidor e imprime na tela
	 Scanner s = new Scanner(this.server);
	 while (s.hasNextLine()) {
	    System.out.println(s.nextLine());
     }
   }
}