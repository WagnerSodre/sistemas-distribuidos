import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	   public static void main(String[] args) 
		   throws UnknownHostException, IOException {
		   // inicia cliente
		   new Client("127.0.0.1", 5096).executes();
	   }	   
	   private String host;
	   private int port;
	   
	   public Client (String host, int port) {
	     this.host = host;
	     this.port = port;
	   }	   
	   public void executes() throws UnknownHostException, IOException {
	     Socket client = new Socket(this.host, this.port);
	     System.out.println("O cliente se conectou ao servidor!");
	     // recebe mensagem do servidor
	     Receiver r = new Receiver(client.getInputStream());
	     new Thread(r).start();
	     // recebe mensagens do teclado e envia para o server
	     Scanner keyboard = new Scanner(System.in);
	     PrintStream output = new PrintStream(client.getOutputStream());
	     while (keyboard.hasNextLine()) {
	       output.println(keyboard.nextLine());
	     }	    
	     output.close();
	     keyboard.close();
	     client.close();    
	   }
	 }