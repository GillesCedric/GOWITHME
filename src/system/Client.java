package system;

import java.io.IOException;
import java.net.Socket;

import utilities.Utilitie;

public class Client {
	private Socket clientSocket;
	private String inetAddress;
	private int port;

	public Client(String inetAddress, int port) {
		this.inetAddress = inetAddress;
		this.port = port;
	}

	public HandleServer launch() {
		System.out.println("Lancement du client");
		try {
			clientSocket = new Socket(inetAddress,port);
			HandleServer handleServer = new HandleServer(clientSocket);
			Thread t = new Thread(handleServer);
			t.start();
			return handleServer;
		} catch (IOException e) {
			Utilitie.error(Client.class.getName(), e);
		}
		return null;
	}
}
