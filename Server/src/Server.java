import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	 public static void main(String[] args) throws IOException {
		 // inicia o servidor na porta 5096
		new Server(5096).executes();
	 }
	 private int port;
	 private ArrayList<PrintStream> clients;
	 public Server (int port) {
		 this.port = port;
		 this.clients = new ArrayList<PrintStream>();
	 }
	 public void executes() throws IOException {
		 ServerSocket server = new ServerSocket(this.port);
		 System.out.println("Port 5096 is open!");
		 while (true) {
			// aceita um cliente
			Socket client = server.accept();
			System.out.println("New conection with the client " +   
			client.getInetAddress().getHostAddress()
			);
	        // põe a saida do cliente na lista
			PrintStream ps = new PrintStream(client.getOutputStream());
			this.clients.add(ps);
			// trata o cliente em uma nova thread
			ClientTreatment tc = new ClientTreatment(client.getInputStream(), this);
				new Thread(tc).start();
		 }
	  }
	  public void distributesClients(String msg) {
		 // replica mensagens
	     for (PrintStream client : this.clients) {
	    	System.out.println(msg);
	        client.println("received the message: "+msg);
	     }
	  }
 }