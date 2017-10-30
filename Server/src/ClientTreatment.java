import java.io.InputStream;
import java.util.Scanner;

public class ClientTreatment implements Runnable {
	private InputStream client;
	private Server server;
	public ClientTreatment(InputStream client, Server server) {
		this.client = client;
		this.server = server;
	}
	public void run() {
		// quando recebe uma mensagem, replica
		Scanner s = new Scanner(this.client);
		while (s.hasNextLine()) {
			server.distributesClients(s.nextLine());
		}
		s.close();
	}
}